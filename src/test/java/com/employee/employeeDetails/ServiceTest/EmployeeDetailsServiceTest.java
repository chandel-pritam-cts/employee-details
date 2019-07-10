package com.employee.employeeDetails.ServiceTest;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.employee.employeeDetails.Dto.EmployeeDetailsDto;
import com.employee.employeeDetails.Repository.EmployeeDetailsRepository;
import com.employee.employeeDetails.entity.EmployeeDetails;
import com.employee.employeeDetails.service.ResourceNotFoundException;
import com.employee.employeeDetails.serviceImpl.EmployeeDetailsImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class EmployeeDetailsServiceTest {

	@InjectMocks
	private EmployeeDetailsImpl employeeDetailsImpl;
	List<EmployeeDetails> empDetailListDtoList = new ArrayList<>();

	@Mock
	private EmployeeDetailsRepository employeeDetailsRepository;
	EmployeeDetails employeeDetails;
	EmployeeDetailsDto employeeDetailsDto;

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
	public void testGetEmployeeDetails() {
		empDetailListDtoList.add(employeeDetails);
		Mockito.when(this.employeeDetailsRepository.findAll()).thenReturn(this.empDetailListDtoList);
		List<EmployeeDetailsDto> newEmployeeDetails = employeeDetailsImpl.getEmployeeDetails();
		assertNotNull(newEmployeeDetails);

	}

	@Test
	public void testCreateEmployeeDetails() {
		Mockito.when(this.employeeDetailsRepository.save(employeeDetails)).thenReturn(employeeDetails);
		EmployeeDetailsDto newEmployeeDetails = employeeDetailsImpl.createEmployeeDetails(employeeDetailsDto);
		assertNotNull(newEmployeeDetails);
	}

	@Test(expected = NullPointerException.class)
	public void testUpdateEmployeeDetails() throws ResourceNotFoundException {
		Long id = 12345L;
		Mockito.when(this.employeeDetailsRepository.findById(id)).thenReturn(Optional.of(this.employeeDetails));
		Mockito.when(this.employeeDetailsRepository.save(employeeDetails)).thenReturn(this.employeeDetails);
		EmployeeDetailsDto newEmployeeDetails = employeeDetailsImpl.updateEmployeeDetails(employeeDetailsDto, id);
		assertNotNull(newEmployeeDetails);

	}

	@Test
	public void testDeleteEmployeeDetails() throws ResourceNotFoundException {
		Long id = 12345L;
		Mockito.doNothing().when(this.employeeDetailsRepository).deleteById(id);

	}
}
