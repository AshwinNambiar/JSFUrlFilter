/**
 * 
 */
package com.jsfurlfilter.context;

import java.util.HashMap;
import java.util.Map;

import com.jsfurlfilter.core.Url;

/**
 * Provides default implementation for {@link UrlContext} using a {@link Map}
 * with static values.
 * 
 * @author Ashwin
 * 
 */
public class DefaultUrlContext implements UrlContext {

	private static final Map<String, Url> urlMap = new HashMap<String, Url>();
	private Url url;

	static {
		prepareUrlMappings();
	}

	public DefaultUrlContext(String url) {
		loadUrl(url);
	}

	public static void prepareUrlMappings() {
		Url url1 = new Url("/home", "/faces/home.xhtml", null, null, false,
				false, null);
		urlMap.put("/home", url1);

		Url url2 = new Url("/page1", "/faces/page1.xhtml", "#{eLMethodBean.callElMethod('Page 1')}", null, false,
				false, null);
		urlMap.put("/page1", url2);

		Url url3 = new Url("/page2", "/faces/page2.xhtml", null, null, true,
				false, "/page1");
		urlMap.put("/page2", url3);

		Url url4 = new Url("/page3", "/faces/page3.xhtml", null, null, true,
				true, "/page1");
		urlMap.put("/page3", url4);
	}

	protected void loadUrl(String url) {
		this.url = ((Url) urlMap.get(url));
	}

	@Override
	public boolean isUrlMapped() {
		return this.url != null;
	}

	@Override
	public String getResourceUrl() {
		String returnVal = null;

		returnVal = this.url.getResourceUrl();

		return returnVal;
	}

	@Override
	public boolean isRedirectEnabled() {
		return this.url.isRedirect();
	}

	@Override
	public boolean isPreserveRedirectParamsEnabled() {
		return this.url.isPreserveParamsOnRedirect();
	}

	@Override
	public String redirectTo() {
		return this.url.getRedirectTo();
	}

	@Override
	public String getELExecute() {
		return url.getExecute();
	}

}
