package com.employeeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeproject.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
