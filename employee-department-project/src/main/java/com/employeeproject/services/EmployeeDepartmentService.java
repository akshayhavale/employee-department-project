package com.employeeproject.services;

import java.util.List;

import com.employeeproject.dtos.DepartmentDto;
import com.employeeproject.dtos.DepartmentEmployeeDto;
import com.employeeproject.dtos.EmployeeDepartmentDto;
import com.employeeproject.dtos.EmployeeDto;

public interface EmployeeDepartmentService {

	// this is for department
	public DepartmentDto createDepartment(DepartmentDto dto);

	public DepartmentEmployeeDto getFullInformationByDepartmentId(Long id);

	public List<DepartmentEmployeeDto> getAllDepartmentWithEmployeeInfo();

	public void deleteDepartmentById(Long id);

	// this is for employee

	public EmployeeDepartmentDto createEmployee(EmployeeDto empDto, Long departmentId);

	public EmployeeDepartmentDto getEmployeeFullInfoById(Long id);

	public void deleteEmployeeById(Long id);

}
