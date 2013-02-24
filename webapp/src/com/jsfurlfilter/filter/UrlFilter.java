/**
 * 
 */
package com.jsfurlfilter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jsfurlfilter.context.UrlContext;
import com.jsfurlfilter.context.factory.UrlContextFactory;
import com.jsfurlfilter.http.ResponseWrapper;
import com.jsfurlfilter.util.Constants;

/**
 * Filters all incoming requests. It checks to see if a request URI is mapped as
 * a {@link UrlContext}. <br/>
 * If Yes, it dispatches the request to the corresponding resource mapped in the
 * UrlContext. <br/>
 * If No, the request is passed on in the filter chain.<br/>
 * <br/>
 * The class also checks to see whether the URI mapped in UrlContext is enabled
 * for redirection. Also, if redirection is enabled, it allows for preserving
 * request parameters, if required.
 * 
 * @author Ashwin
 */
public class UrlFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UrlFilter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String contextPath = request.getServletContext().getContextPath();
		String browserUrl = request.getRequestURI().substring(
				contextPath.length());

		// Strip jsessionid from URL.(i.e. part of URL after ';')
		int indexOfJsessionId = browserUrl.indexOf(';');
		if (indexOfJsessionId > -1) {
			browserUrl = browserUrl.substring(0, browserUrl.indexOf(';'));
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("URL to be checked is : " + browserUrl);
		}

		UrlContext urlContext = null;

		// Get UrlContext for URI.
		try {
			urlContext = UrlContextFactory.getUrlContextFactory(
					request.getServletContext()).getUrlContext(browserUrl);
		} catch (ClassNotFoundException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("Error getting URL Context", e);
			}
		} catch (InstantiationException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("Error getting URL Context", e);
			}
		} catch (IllegalAccessException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("Error getting URL Context", e);
			}
		}

		// Check to see if URI is mapped in UrlContext.
		if (urlContext.isUrlMapped()) {

			// Is UrlContext mapped for redirection.
			if (urlContext.isRedirectEnabled()) {
				String queryString = "";
				// Should request parameters be preserved while redirection.
				if (urlContext.isPreserveRedirectParamsEnabled()) {
					queryString = "?" + request.getQueryString();
				}

				// Redirect URI.
				((HttpServletResponse) servletResponse).sendRedirect(urlContext
						.redirectTo() + queryString);
			} else {
				// Set url and url context as request attributes for further use
				// in request lifecycle, if required.
				request.setAttribute(Constants.REQUEST_ATTR_URL, browserUrl);
				request.setAttribute(Constants.REQUEST_ATTR_URL_CONTEXT,
						urlContext);

				// Dispatch URI to mapped resource.
				request.getRequestDispatcher(urlContext.getResourceUrl())
						.forward(
								request,
								new ResponseWrapper(
										(HttpServletResponse) servletResponse,
										browserUrl));
			}
		} else {
			// If URI is not mapped, continue in filter chain.
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
