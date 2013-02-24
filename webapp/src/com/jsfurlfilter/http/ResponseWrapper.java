/**
 * 
 */
package com.jsfurlfilter.http;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.jsfurlfilter.core.Url;
import com.jsfurlfilter.filter.UrlFilter;

/**
 * HTML forms in JSF 2.0 have their action attribute populated using call to
 * encoded request URL. However, this encoded URL will always point to an XHTML
 * file or 'resourceUrl' of a {@link Url}. <br/>
 * <br/>
 * We require the form action attribute to point to the original URL from the
 * browser ('url' from {@link Url}) and not to the 'resourceUrl'. <br/>
 * <br/>
 * To achieve this, {@link UrlFilter} wraps the response and provides the
 * original URL as a parameter in constructor. The original URL is saved in
 * 'url' property. The methods encodeUrl, encodeURL, encodeRedirectUrl,
 * encodeRedirectURL are overridden to return the encoded original URL instead
 * of the encoded 'resourceUrl'.
 * 
 * @author Ashwin
 * 
 */
public class ResponseWrapper extends HttpServletResponseWrapper {

	private String url;

	public ResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	public ResponseWrapper(HttpServletResponse response, String url) {
		this(response);
		this.url = url;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String encodeUrl(String url) {
		if (this.url != null) {
			return super.encodeUrl(this.url);
		} else {
			return super.encodeUrl(url);
		}
	}

	@Override
	public String encodeURL(String url) {
		if (this.url != null) {
			return super.encodeURL(this.url);
		} else {
			return super.encodeURL(url);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public String encodeRedirectUrl(String url) {
		if (this.url != null) {
			return super.encodeRedirectUrl(this.url);
		} else {
			return super.encodeRedirectUrl(url);
		}
	}

	@Override
	public String encodeRedirectURL(String url) {
		if (this.url != null) {
			return super.encodeRedirectURL(this.url);
		} else {
			return super.encodeRedirectURL(url);
		}
	}
}
