/**
 * 
 */
package com.jsfurlfilter.context.factory;

import com.jsfurlfilter.context.DefaultUrlContext;
import com.jsfurlfilter.context.UrlContext;
import com.jsfurlfilter.filter.UrlFilter;

/**
 * Provides {@link UrlFilter} with instance of {@link DefaultUrlContext} for
 * each request.
 * 
 * @author Ashwin
 * 
 */
public class DefaultUrlContextFactory extends UrlContextFactory {

	/**
	 * Returns and instance of {@link DefaultUrlContext}, an implementation of
	 * {@link UrlContext}
	 */
	@Override
	public UrlContext getUrlContext(String url) {
		return new DefaultUrlContext(url);
	}
}
