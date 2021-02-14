package com.demo.springboot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.springboot.demo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// create a querry
		Query theQuery = entityManager.createQuery("from Employee");

		// execute quarry and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		// get the employee
		Employee theEmployee = entityManager.find(Employee.class, theId);

		// return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		// save or update employee
		Employee dbEmployee = entityManager.merge(theEmployee);

		// update with id from db
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {

		// delete object with id
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
