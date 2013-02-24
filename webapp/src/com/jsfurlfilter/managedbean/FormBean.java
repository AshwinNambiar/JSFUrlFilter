/**
 * 
 */
package com.jsfurlfilter.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Sample Managed bean to demonstrate form submission in JSF 2.0.
 * 
 * @author Ashwin
 * 
 */
@ManagedBean
@ViewScoped
public class FormBean {

	private String text1;

	/**
	 * @return the text1
	 */
	public String getText1() {
		return text1;
	}

	/**
	 * @param text1
	 *            the text1 to set
	 */
	public void setText1(String text1) {
		this.text1 = text1;
	}

	@PostConstruct
	private void init() {
		text1 = "test";

	}

}
