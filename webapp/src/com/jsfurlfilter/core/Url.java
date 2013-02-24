/**
 * 
 */
package com.jsfurlfilter.core;

/**
 * Saves all property values of Url.<br/>
 * <br/>
 * 
 * <b>url</b> - URI from browser - excluding the Context Path. <br/>
 * <br/>
 * <b>resourceUrl</b> - The internal url to which the request should be forwarded to. <br/>
 * <br/>
 * <b>execute</b> - Used in JSF 2.0, to execute an EL expression before restore phase
 * is called.<br/>
 * <br/>
 * <b>requestAttributes</b> - Comma separated string of key-value pairs to be saved as
 * request attributes. <br/>
 * <br/>
 * <b>isRedirect</b> - If true, the request will be redirected to URL specified in
 * 'redirectTo' property. <br/>
 * <br/>
 * <b>preserveParamsOnRedirect</b> - If true, the query string of current request are
 * sent along with the redirect URL. If false, the query string is ignored.<br/>
 * <br/>
 * <b>redirectTo</b> - URL to which current request should be redirected to. Valid only
 * when 'isRedirect' is set to true.
 * 
 * @author Ashwin
 * 
 */
public class Url {
	private String url;
	private String resourceUrl;
	private String execute;
	private String requestAttributes;
	private boolean isRedirect;
	private boolean preserveParamsOnRedirect;
	private String redirectTo;

	public Url(String url, String resourceUrl, String execute,
			String requestAttributes, boolean isRedirect,
			boolean preserveParamsOnRedirect, String redirectTo) {
		this.url = url;
		this.resourceUrl = resourceUrl;
		this.execute = execute;
		this.requestAttributes = requestAttributes;
		this.isRedirect = isRedirect;
		this.preserveParamsOnRedirect = preserveParamsOnRedirect;
		this.redirectTo = redirectTo;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the resourceUrl
	 */
	public String getResourceUrl() {
		return resourceUrl;
	}

	/**
	 * @param resourceUrl
	 *            the resourceUrl to set
	 */
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	/**
	 * @return the execute
	 */
	public String getExecute() {
		return execute;
	}

	/**
	 * @param execute
	 *            the execute to set
	 */
	public void setExecute(String execute) {
		this.execute = execute;
	}

	/**
	 * @return the requestAttributes
	 */
	public String getRequestAttributes() {
		return requestAttributes;
	}

	/**
	 * @param requestAttributes
	 *            the requestAttributes to set
	 */
	public void setRequestAttributes(String requestAttributes) {
		this.requestAttributes = requestAttributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Url)) {
			return false;
		}
		Url url2 = (Url) obj;
		return this.url.equals(url2.url);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.url.hashCode();
	}

	/**
	 * @return the isRedirect
	 */
	public boolean isRedirect() {
		return isRedirect;
	}

	/**
	 * @param isRedirect
	 *            the isRedirect to set
	 */
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	/**
	 * @return the preserveParamsOnRedirect
	 */
	public boolean isPreserveParamsOnRedirect() {
		return preserveParamsOnRedirect;
	}

	/**
	 * @param preserveParamsOnRedirect
	 *            the preserveParamsOnRedirect to set
	 */
	public void setPreserveParamsOnRedirect(boolean preserveParamsOnRedirect) {
		this.preserveParamsOnRedirect = preserveParamsOnRedirect;
	}

	/**
	 * @return the redirectTo
	 */
	public String getRedirectTo() {
		return redirectTo;
	}

	/**
	 * @param redirectTo
	 *            the redirectTo to set
	 */
	public void setRedirectTo(String redirectTo) {
		this.redirectTo = redirectTo;
	}

}
