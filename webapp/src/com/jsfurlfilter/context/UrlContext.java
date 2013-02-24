/**
 * 
 */
package com.jsfurlfilter.context;

import com.jsfurlfilter.filter.UrlFilter;

/**
 * Used to provide {@link UrlFilter} with details of a mapped page URI, if any.<br/>
 * <br/>
 * 
 * Implementations can be created to fetch URL information from various sources
 * like, XML, database, services or even static values (like
 * {@link DefaultUrlContext}).<br/>
 * <br/>
 * 
 * Pre-loading URL values is responsibility of individual implementations.<br/><br/>
 * 
 * @see DefaultUrlContext
 * 
 * @author Ashwin
 * 
 */
public interface UrlContext {

	boolean isUrlMapped();

	String getResourceUrl();

	boolean isRedirectEnabled();

	boolean isPreserveRedirectParamsEnabled();

	String redirectTo();
	
	String getELExecute();
}
