package com.employeeproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeproject.dtos.EmployeeDepartmentDto;
import com.employeeproject.dtos.EmployeeDto;
import com.employeeproject.services.EmployeeDepartmentService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDepartmentService employeeDepartmentService;

	@PostMapping("/employee/department/{departmentId}/create")
	public EmployeeDepartmentDto createEmployee(@RequestBody EmployeeDto dto,
			@PathVariable(value = "departmentId") Long departmentId) {

		return employeeDepartmentService.createEmployee(dto, departmentId);

	}

	@GetMapping("/employee/{employeeId}")
	public EmployeeDepartmentDto getById(@PathVariable(value = "employeeId") Long id) {
		return employeeDepartmentService.getEmployeeFullInfoById(id);
	}

	@DeleteMapping("/employee/{employeeId}")
	public void deleteById(@PathVariable(value = "employeeId") Long id) {
		employeeDepartmentService.deleteEmployeeById(id);
	}

}
