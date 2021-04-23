package com.employeeproject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeproject.dtos.DepartmentDto;
import com.employeeproject.dtos.DepartmentEmployeeDto;
import com.employeeproject.dtos.EmployeeDepartmentDto;
import com.employeeproject.dtos.EmployeeDto;
import com.employeeproject.model.Department;
import com.employeeproject.model.Employee;
import com.employeeproject.repository.DepartmentRepository;
import com.employeeproject.repository.EmployeeRepository;

@Service
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	/**
	 * these all are Department related informations
	 */
	@Override
	public DepartmentDto createDepartment(DepartmentDto dto) {
		Department model = new Department();
		model.setName(dto.getName());
		model = departmentRepository.save(model);
		dto.setId(model.getId());
		return dto;
	}

	@Override
	public DepartmentEmployeeDto getFullInformationByDepartmentId(Long id) {
		Department model = departmentRepository.findById(id).get();
		DepartmentEmployeeDto departmentDto = new DepartmentEmployeeDto();
		departmentDto.setId(model.getId());
		departmentDto.setName(model.getName());
		List<EmployeeDto> employeeDtos = new ArrayList<>();
//		model.getEmployee().forEach(empModel -> {
//			EmployeeDto empDto = new EmployeeDto();
//			empDto.setId(empModel.getId());
//			empDto.setName(empModel.getName());
//			employeeDtos.add(empDto);
//		});

		for (Employee empModel : model.getEmployee()) {
			EmployeeDto empDto = new EmployeeDto();
			empDto.setId(empModel.getId());
			empDto.setName(empModel.getName());
			employeeDtos.add(empDto);

		}
		departmentDto.setEmployee(employeeDtos);
		return departmentDto;
	}

	@Override
	public List<DepartmentEmployeeDto> getAllDepartmentWithEmployeeInfo() {
		List<Department> models = departmentRepository.findAll();
		List<DepartmentEmployeeDto> dtos = new ArrayList<>();
		for (Department model : models) {
			DepartmentEmployeeDto departmentDto = new DepartmentEmployeeDto();
			departmentDto.setId(model.getId());
			departmentDto.setName(model.getName());
			List<EmployeeDto> employeeDtos = new ArrayList<>();
//			model.getEmployee().forEach(empModel -> {
//				EmployeeDto empDto = new EmployeeDto();
//				empDto.setId(empModel.getId());
//				empDto.setName(empModel.getName());
//				employeeDtos.add(empDto);
//			});

			for (Employee empModel : model.getEmployee()) {
				EmployeeDto empDto = new EmployeeDto();
				empDto.setId(empModel.getId());
				empDto.setName(empModel.getName());
				employeeDtos.add(empDto);

			}
			departmentDto.setEmployee(employeeDtos);
			dtos.add(departmentDto);
		}
		return dtos;
	}

	@Override
	public void deleteDepartmentById(Long id) {
		departmentRepository.deleteById(id);

	}

	/**
	 * these all are employee related implementations
	 */
	@Override
	public EmployeeDepartmentDto createEmployee(EmployeeDto empDto, Long departmentID) {

		Employee model = new Employee();
		model.setName(empDto.getName());
		Department departmentModel = departmentRepository.findById(departmentID).get();
		model.setDepartment(departmentModel);
		model = employeeRepository.save(model);
		EmployeeDepartmentDto dto = new EmployeeDepartmentDto();
		dto.setId(model.getId());
		dto.setName(model.getName());
		DepartmentDto departDto = new DepartmentDto();
		departDto.setId(model.getDepartment().getId());
		departDto.setName(model.getDepartment().getName());
		dto.setDepartment(departDto);
		return dto;
	}

	@Override
	public EmployeeDepartmentDto getEmployeeFullInfoById(Long id) {

		Employee empModel = employeeRepository.findById(id).get();
		EmployeeDepartmentDto dto = new EmployeeDepartmentDto();
		dto.setId(empModel.getId());
		dto.setName(empModel.getName());
		DepartmentDto departDto = new DepartmentDto();
		departDto.setId(empModel.getDepartment().getId());
		departDto.setName(empModel.getDepartment().getName());
		dto.setDepartment(departDto);
		return dto;

	}

	@Override
	public void deleteEmployeeById(Long id) {

		employeeRepository.deleteById(id);

	}

}
