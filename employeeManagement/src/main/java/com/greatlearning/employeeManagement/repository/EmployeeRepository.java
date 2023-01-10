package com.greatlearning.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeeManagement.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Long>{

}
