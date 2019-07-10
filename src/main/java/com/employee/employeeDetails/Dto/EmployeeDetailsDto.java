package com.employee.employeeDetails.Dto;

public class EmployeeDetailsDto {
	private long id;
	private String firstName;
	private String lastName;
	private long salary;

	public EmployeeDetailsDto() {

	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param salary
	 */

	public EmployeeDetailsDto(long id, String firstName, String lastName, long salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	/**
	 * Gets id.
	 *
	 * @return the id
	 */

	public long getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets first name.
	 *
	 * @return the first name
	 */

	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets first name.
	 *
	 * @param firstName the first name
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets Last name.
	 *
	 * @return the Last name
	 */

	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets Last name.
	 *
	 * @param lastName the Last name
	 */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets salary.
	 *
	 * @return the salary
	 */

	public long getSalary() {
		return salary;
	}

	/**
	 * Sets salary.
	 *
	 * @param salary the salary
	 */

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDetailsDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
				+ salary + "]";
	}

}
