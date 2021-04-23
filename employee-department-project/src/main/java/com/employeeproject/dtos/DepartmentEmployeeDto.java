package com.employeeproject.dtos;

import java.util.ArrayList;
import java.util.List;

public class DepartmentEmployeeDto {
	
	private Long id;
	private String name;
	private List<EmployeeDto> employee = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<EmployeeDto> getEmployee() {
		return employee;
	}
	public void setEmployee(List<EmployeeDto> employee) {
		this.employee = employee;
	}
	
	

}
