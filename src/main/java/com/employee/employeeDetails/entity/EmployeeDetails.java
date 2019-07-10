package com.employee.employeeDetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details")

public class EmployeeDetails {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "Employee_firstName")
	private String firstName;

	@Column(name = "Employee_lasttName")
	private String lastName;

	@Column(name = "Salary")
	private long Salary;

	public EmployeeDetails() {

	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param salary
	 */
	public EmployeeDetails(Long id, String firstName, String lastName, long salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		Salary = salary;
	}

	/**
	 * Gets id.
	 *
	 * @return the id
	 */

	public Long getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(Long id) {
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
		return Salary;
	}

	/**
	 * Sets salary.
	 *
	 * @param salary the salary
	 */

	public void setSalary(long salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Salary="
				+ Salary + "]";
	}

}
