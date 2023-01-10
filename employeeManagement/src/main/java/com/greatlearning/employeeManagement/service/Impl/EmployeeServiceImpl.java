package com.greatlearning.employeeManagement.service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.greatlearning.employeeManagement.Entity.Employee;
import com.greatlearning.employeeManagement.repository.EmployeeRepository;
import com.greatlearning.employeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeerepository;

	public EmployeeServiceImpl(EmployeeRepository employeerepository) {
		super();
		this.employeerepository = employeerepository;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeerepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeerepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long Id) {
		return employeerepository.findById(Id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeerepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long Id) {
		employeerepository.deleteById(Id);
	}

}
