package com.employee.employeeDetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.employeeDetails.Dto.EmployeeDetailsDto;

/**
 * @Service - indicates that an annotated class is a service class.
 *
 */

@Service
public interface EmployeeDetailsService {

	public List<EmployeeDetailsDto> getEmployeeDetails();

	public EmployeeDetailsDto createEmployeeDetails(EmployeeDetailsDto employeeDetailsDto);

	public EmployeeDetailsDto updateEmployeeDetails(EmployeeDetailsDto employeedetailsDto, Long id)

			throws ResourceNotFoundException;

	public void deleteEmployeeDetails(Long id) throws ResourceNotFoundException;

}
