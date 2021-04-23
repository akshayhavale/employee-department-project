package com.employeeproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeproject.dtos.DepartmentDto;
import com.employeeproject.dtos.DepartmentEmployeeDto;
import com.employeeproject.services.EmployeeDepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private EmployeeDepartmentService employeeDepartmentService;

	@PostMapping("/department/create")
	public DepartmentDto createDepartment(@RequestBody DepartmentDto dto) {
		return employeeDepartmentService.createDepartment(dto);
	}

	@GetMapping("/department/{departId}")
	public DepartmentEmployeeDto getDepartmentById(@PathVariable(value = "departId") Long departId) {
		return employeeDepartmentService.getFullInformationByDepartmentId(departId);
	}

	@GetMapping("/departments")
	public List<DepartmentEmployeeDto> getAllDepartments() {
		return employeeDepartmentService.getAllDepartmentWithEmployeeInfo();
	}

	@DeleteMapping("/department/{departId}")
	public void deleteDepartmentById(@PathVariable(value = "departId") Long departId) {
		employeeDepartmentService.deleteDepartmentById(departId);
	}

}
