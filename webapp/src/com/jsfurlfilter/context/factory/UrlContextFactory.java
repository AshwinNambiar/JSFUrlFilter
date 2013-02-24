/**
 * 
 */
package com.jsfurlfilter.context.factory;

import javax.servlet.ServletContext;

import com.jsfurlfilter.context.UrlContext;
import com.jsfurlfilter.filter.UrlFilter;

/**
 * Factory used by {@link UrlFilter} to obtain an instance of {@link UrlContext}
 * for each request.<br/>
 * <br/>
 * Sub-classes can be used to provide implementation(s) of {@link UrlContext}.
 * 
 * @see DefaultUrlContextFactory
 * @author Ashwin
 * 
 */
public abstract class UrlContextFactory {

	protected static ServletContext servletContext;

	/**
	 * Returns an instance of a class implementing {@link UrlContextFactory}.
	 * The class implementing {@link UrlContextFactory} is defined using the
	 * context parameter "UrlContextFactoryClassName".
	 * 
	 * @param servletContext
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	public static UrlContextFactory getUrlContextFactory(
			ServletContext servletContext) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		UrlContextFactory.servletContext = servletContext;
		String urlContextFactoryClassName = servletContext
				.getInitParameter("UrlContextFactoryClassName");
		Class<? extends UrlContextFactory> class1 = (Class<? extends UrlContextFactory>) Class
				.forName(urlContextFactoryClassName);
		return class1.newInstance();
	}

	/**
	 * Returns an instance of {@link UrlContext} implementation.
	 * 
	 * @param url
	 * @return
	 */
	public abstract UrlContext getUrlContext(String url);
}
