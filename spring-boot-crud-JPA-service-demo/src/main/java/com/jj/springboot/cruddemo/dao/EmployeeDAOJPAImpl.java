package com.jj.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jj.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getEmployees() {
		
		
		TypedQuery<Employee> queryResult = entityManager.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = queryResult.getResultList();
		
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {

		
		Employee employee = entityManager.find(Employee.class,id);

		return employee;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub

		Employee dbemployee = entityManager.merge(employee);
		
		employee.setId(dbemployee.getId());
		
	}

	@Override
	public void deleteById(int id) {

	
		Query queryResult = entityManager.createQuery("delete from Employee where id=:id");
		queryResult.setParameter("id",id);
		queryResult.executeUpdate();
		
	}

}
