package com.employee.employeeDetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.employeeDetails.entity.EmployeeDetails;

/**
 * @author 758344 Method to fetch the employee details on the basis of
 *         designation by using Elastic-Search-Repository. DAO or Repository
 *         classes usually represent the database access layer in an
 *         application, and should be annotated with @Repository: @Repository -
 *         indicates that an annotated class is a repository, which is an
 *         abstraction of data access and storage.
 *
 */

@Repository
@Transactional
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {

}
