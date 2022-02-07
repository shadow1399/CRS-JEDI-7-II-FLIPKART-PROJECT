/**
 * 
 */
package com.flipkart.restController;

import org.glassfish.jersey.server.ResourceConfig;


/*
 * All the API's are configured in this APPLication Config class
 * */

public class ApplicationConfig extends ResourceConfig {
	
	public ApplicationConfig() {
		// for student API adding the respective class.
		register(StudentRestAPI.class);
		//for professor API adding the respective class.
		register(ProfessorRestAPI.class);
		//for admin API adding the respective class.
		register(AdminRestAPI.class);
		//for user API adding the respective class.
		register(UserRestAPI.class);
	}
	

}
