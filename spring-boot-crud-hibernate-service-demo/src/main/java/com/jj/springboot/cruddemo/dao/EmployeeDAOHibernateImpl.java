package com.jj.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jj.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	
	public List<Employee> getEmployees() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> queryResult = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = queryResult.getResultList();
		
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class,id);

		return employee;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query queryResult = currentSession.createQuery("delete from Employee where id=:id");
		queryResult.setParameter("id", id);
		queryResult.executeUpdate();
		
	}

}
