/**
 * 
 */
package com.crs.flipkart.application;

import org.glassfish.jersey.server.ResourceConfig;

//import org.glassfish.jersey.server.ResourceConfig;

import com.crs.flipkart.restcontroller.CustomerController;

/**
 * @author Mehak Goel
 *
 */



public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {

	register(CustomerController.class);


	}

}