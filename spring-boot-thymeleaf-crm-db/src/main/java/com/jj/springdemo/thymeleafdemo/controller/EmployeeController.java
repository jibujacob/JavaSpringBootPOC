package com.jj.springdemo.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jj.springdemo.thymeleafdemo.entity.Employee;
import com.jj.springdemo.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/list")
	public String getEmployees(Model model) {
		
		List<Employee> employeeList = employeeService.getEmployees();
		model.addAttribute("empList",employeeList);
		
		return "employees/employee-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "employees/employee-add";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute ("employee") Employee employee) {
		
		employeeService.save(employee);
		
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id ,Model model) {
		
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "employees/employee-add";
	}
	
	@GetMapping("/showFormForDelete")
		public String showFormForDelete(@RequestParam("employeeId") int id ) {
		
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}


}
