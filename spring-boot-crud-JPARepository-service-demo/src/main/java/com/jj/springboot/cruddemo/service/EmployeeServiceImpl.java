package com.jj.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jj.springboot.cruddemo.dao.EmployeeRepository;
import com.jj.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee =null;
		if (result.isPresent())
			employee = result.get();
		else
			throw new RuntimeException("No employee with the id: "+id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);

	}

}
