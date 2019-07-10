package com.employee.employeeDetails.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeeDetails.Dto.EmployeeDetailsDto;
import com.employee.employeeDetails.Repository.EmployeeDetailsRepository;
import com.employee.employeeDetails.entity.EmployeeDetails;
import com.employee.employeeDetails.service.EmployeeDetailsService;
import com.employee.employeeDetails.service.ResourceNotFoundException;

/**
 * The business logic of an application usually resides within the service layer
 * – so we’ll use the @Service annotation to indicate that a class belongs to
 * that layer:
 *
 */

@Service
public class EmployeeDetailsImpl implements EmployeeDetailsService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeDetailsImpl.class);

	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	@Override
	public List<EmployeeDetailsDto> getEmployeeDetails() {
		List<EmployeeDetailsDto> employeeDetailsDtoList = new ArrayList<EmployeeDetailsDto>();
		List<EmployeeDetails> employeeList = employeeDetailsRepository.findAll();

		employeeList.forEach(EmployeeDetails -> {
			com.employee.employeeDetails.Dto.EmployeeDetailsDto employee;
			EmployeeDetailsDto EmployeeDetailsDto = new EmployeeDetailsDto(EmployeeDetails.getId(),
					EmployeeDetails.getFirstName(), EmployeeDetails.getLastName(), EmployeeDetails.getSalary());

			employeeDetailsDtoList.add(EmployeeDetailsDto);
		});
		LOG.info("List of Prodcut details:{} ", employeeDetailsDtoList);
		return employeeDetailsDtoList;
	}

	@Override
	public EmployeeDetailsDto createEmployeeDetails(EmployeeDetailsDto employeeDetailsDto) {

		EmployeeDetails employeeDetails = new EmployeeDetails(employeeDetailsDto.getId(),
				employeeDetailsDto.getFirstName(), employeeDetailsDto.getLastName(), employeeDetailsDto.getSalary());

		employeeDetailsRepository.save(employeeDetails);
		return employeeDetailsDto;
	}

	@Override
	public EmployeeDetailsDto updateEmployeeDetails(EmployeeDetailsDto employeedetailsDto, Long id)
			throws ResourceNotFoundException {
		employeeDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		EmployeeDetails updatedEmployeeDetails = employeeDetailsRepository.save(new EmployeeDetails(id,
				employeedetailsDto.getFirstName(), employeedetailsDto.getLastName(), employeedetailsDto.getSalary()));

		EmployeeDetailsDto updatedEmployeeDetailsDto = new EmployeeDetailsDto(updatedEmployeeDetails.getId(),
				updatedEmployeeDetails.getFirstName(), updatedEmployeeDetails.getLastName(),
				updatedEmployeeDetails.getSalary());
		return updatedEmployeeDetailsDto;
	}

	@Override
	public void deleteEmployeeDetails(Long id) throws ResourceNotFoundException {
		EmployeeDetails EmployeeDetails = employeeDetailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
		employeeDetailsRepository.delete(EmployeeDetails);

	}

}
