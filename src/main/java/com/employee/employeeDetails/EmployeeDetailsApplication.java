package com.employee.employeeDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication encapsulates @Configuration, @EnableAutoConfiguration,
 *                        and @ComponentScan annotations with their default
 *                        attributes. @SpringBootApplication - enables Spring
 *                        Boot auto configuration and component scanning.
 * 
 */

@SpringBootApplication
public class EmployeeDetailsApplication {

	/**
	 * @param args
	 */

	/**
	 * Method to save the employees in the database. We can pass named parameters to
	 * our queries using @Param:
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetailsApplication.class, args);
	}

}
