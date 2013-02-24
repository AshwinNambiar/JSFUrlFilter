/**
 * 
 */
package com.jsfurlfilter.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Sample request scoped Managed bean to demonstrate invoking of EL expression 
 * @author Ashwin
 *
 */
@ManagedBean
@RequestScoped
public class ELMethodBean {
	
	public void callElMethod(String value) {
		System.out.println(value);
	}
	
}
