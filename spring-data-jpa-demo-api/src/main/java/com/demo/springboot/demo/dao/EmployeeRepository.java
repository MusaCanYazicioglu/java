package com.demo.springboot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
