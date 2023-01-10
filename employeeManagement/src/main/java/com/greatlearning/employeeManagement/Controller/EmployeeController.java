package com.greatlearning.employeeManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.employeeManagement.Entity.Employee;
import com.greatlearning.employeeManagement.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// handler method to handle list employees and return mode and view
	@GetMapping("/employees")
	public String listemployee(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "employees";
	}

	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{Id}")
	public String editEmployeeForm(@PathVariable Long Id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(Id));
		return "edit_employee";
	}
	
	@PostMapping("/employees/{Id}")
	public String updateEmployeeById(@PathVariable Long Id, @ModelAttribute("employee") Employee employee, Model model) {
		//get employee from database by Id 
		Employee existingEmployee = employeeService.getEmployeeById(Id);
		existingEmployee.setId(Id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//save updated employee details
		employeeService.saveEmployee(existingEmployee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/{Id}")
	public String deleteEmployeeById(@PathVariable Long Id) {
		employeeService.deleteEmployeeById(Id);
		return"redirect:/employees";
	}

}
