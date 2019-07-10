package com.employee.employeeDetails.ControllerTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.employee.employeeDetails.Controller.EmployeeDetailsController;
import com.employee.employeeDetails.Dto.EmployeeDetailsDto;
import com.employee.employeeDetails.entity.EmployeeDetails;
import com.employee.employeeDetails.service.EmployeeDetailsService;
import com.employee.employeeDetails.service.ResourceNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class EmployeeDetailsControllerTest {
	@InjectMocks
	private EmployeeDetailsController employeeDetailsController;

	@Mock
	private EmployeeDetailsService employeeDetailsService;
	private EmployeeDetails employeeDetails;
	private EmployeeDetailsDto employeeDetailsDto;

	@Before
	public void setUp() {
		employeeDetails = new EmployeeDetails();
		employeeDetails.setFirstName("Pritam");
		employeeDetails.setLastName("Thakur");
		employeeDetails.setId(12345L);
		employeeDetails.setSalary(50000);

		employeeDetailsDto = new EmployeeDetailsDto();
		employeeDetailsDto.setFirstName("Pritam");
		employeeDetailsDto.setLastName("Thakur");
		employeeDetailsDto.setId(12345L);
		employeeDetailsDto.setSalary(50000);

	}

	@Test
	public void testGetEmployeeDetails() throws Exception {

		List<EmployeeDetailsDto> empDetailListDtoList = new ArrayList<>();
		empDetailListDtoList.add(employeeDetailsDto);

		Mockito.when(this.employeeDetailsService.getEmployeeDetails()).thenReturn(empDetailListDtoList);

		ResponseEntity<List<EmployeeDetailsDto>> responseEntity = this.employeeDetailsController
				.getEmployeeDetailsController();
		assertNotNull(responseEntity);

	}

	@Test
	public void testGetEmployeeDetailsFailure() throws Exception {

		List<EmployeeDetailsDto> empDetailListDtoList = new ArrayList<>();
		empDetailListDtoList.add(employeeDetailsDto);

		Mockito.when(this.employeeDetailsService.getEmployeeDetails()).thenReturn(empDetailListDtoList);

		ResponseEntity<List<EmployeeDetailsDto>> responseEntity = this.employeeDetailsController
				.getEmployeeDetailsController();
		assertNotEquals("Failure", responseEntity.getBody().get(0).getFirstName());

	}

	@Test
	public void testCreateEmployeeDetails() {
		EmployeeDetailsDto employeeDetailsDto = new EmployeeDetailsDto();
		Mockito.when(this.employeeDetailsService.createEmployeeDetails(employeeDetailsDto))
				.thenReturn(employeeDetailsDto);
		ResponseEntity<EmployeeDetailsDto> responseEntity = this.employeeDetailsController
				.createEmployeeDetails(employeeDetailsDto);
	}

	@Test
	public void testUpdateEmployeeDetails() throws ResourceNotFoundException {
		EmployeeDetailsDto employeeDetailsDto = new EmployeeDetailsDto();
		Long id = 12345L;
		Mockito.when(this.employeeDetailsService.updateEmployeeDetails(employeeDetailsDto, id))
				.thenReturn(employeeDetailsDto);
		ResponseEntity<EmployeeDetailsDto> responseEntity = this.employeeDetailsController
				.updateEmployeeDetails(employeeDetailsDto, id);

	}

	@Test
	public void testDeleteEmployeeDetails() throws ResourceNotFoundException {
		Long id = 1222L;
		Mockito.doNothing().when(employeeDetailsService).deleteEmployeeDetails(id);

	}

}
