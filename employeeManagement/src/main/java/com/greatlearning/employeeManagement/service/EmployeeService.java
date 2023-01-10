package com.greatlearning.employeeManagement.service;

import java.util.List;

import com.greatlearning.employeeManagement.Entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	Employee saveEmployee(Employee employee);

	Employee getEmployeeById(Long Id);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Long Id);

}
