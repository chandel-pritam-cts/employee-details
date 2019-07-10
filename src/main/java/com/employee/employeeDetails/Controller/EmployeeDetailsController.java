package com.employee.employeeDetails.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeeDetails.Dto.EmployeeDetailsDto;
import com.employee.employeeDetails.service.EmployeeDetailsService;
import com.employee.employeeDetails.service.ResourceNotFoundException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author 758344 Main implementation class which serves two purpose in a spring
 *         boot application: Configuration and bootstrapping.
 *         The @RestController annotation tells Spring to render the resulting
 *         string directly back to the caller.
 */

/**
 * @EnableAutoConfiguration, as its name says, enables auto-configuration. It
 * means that Spring Boot looks for auto-configuration beans on its classpath
 * and automatically applies them.
 *
 */

@AutoConfigurationPackage
@RestController
@Validated

@ApiResponses(value = { @ApiResponse(code = 400, message = "The request requires user authentication"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden "),
		@ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI") })

public class EmployeeDetailsController {
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeDetailsController.class);

	@Autowired
	private EmployeeDetailsService employeeservice;

	/**
	 * Method to fetch all employees from the database.The @RequestMapping
	 * annotation provides “routing” information. It is telling Spring that any HTTP
	 * request with the path “/” should be mapped to the home method
	 */

	/**
	 * @return
	 * @throws Exception
	 */

	@GetMapping("/getEmployeeDetails")
	public ResponseEntity<List<EmployeeDetailsDto>> getEmployeeDetailsController() throws Exception {

		LOG.info("Controller getEmployeeDetail for registration");
		List<EmployeeDetailsDto> employeeDetailsList = new ArrayList<EmployeeDetailsDto>();

		try {
			employeeDetailsList = employeeservice.getEmployeeDetails();
		} catch (Exception e) {
			throw new Exception("Unable to fetch employee details list:{}", e.getCause());
		}
		return new ResponseEntity<List<EmployeeDetailsDto>>(employeeDetailsList, HttpStatus.OK);

	}

	/**
	 * Method to save the employees in the database. We can pass named parameters to
	 * our queries using @Param:
	 */

	/**
	 * @param employeeDetailsDto
	 * @return
	 */

	@PostMapping(value = "/createEmployeeDetails")
	public ResponseEntity<EmployeeDetailsDto> createEmployeeDetails(
			@RequestBody EmployeeDetailsDto employeeDetailsDto) {
		LOG.info("Inside EmployeeDetailsController createEmployeeDetailsDetails method");
		employeeservice.createEmployeeDetails(employeeDetailsDto);
		// return HttpStatus.OK;
		return new ResponseEntity<EmployeeDetailsDto>(employeeservice.createEmployeeDetails(employeeDetailsDto),
				HttpStatus.OK);
	}

	/**
	 * We can pass named parameters to our queries using @Param:
	 * 
	 * @param employeeDetailsDto
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */

	/**
	 * Method to update employee by id.
	 */

	@PutMapping(value = "/updateEmployeeDetails/{id}")
	public ResponseEntity<EmployeeDetailsDto> updateEmployeeDetails(@RequestBody EmployeeDetailsDto employeeDetailsDto,
			@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		LOG.info("Inside EmployeeDetailsController updateEmployeeDetailsDetails method");

		return new ResponseEntity<EmployeeDetailsDto>(employeeservice.updateEmployeeDetails(employeeDetailsDto, id),
				HttpStatus.OK);
		// employeeservice.updateEmployeeDetails(employeeDetailsDto, id);
	}

	/**
	 * We can pass named parameters to our queries using @Param:
	 * 
	 * @param id
	 * @throws ResourceNotFoundException
	 */

	/**
	 * Method to delete employee by id.
	 * 
	 * @return
	 */

	@DeleteMapping(value = "/getEmployeeDetails/{id}")
	public void deleteEmployeeDetails(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		LOG.info("Inside deleteEmployeeDetails updateEmployeeDetails method");
		employeeservice.deleteEmployeeDetails(id);
	}
}
