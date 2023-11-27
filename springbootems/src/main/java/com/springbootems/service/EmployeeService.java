package com.springbootems.service;

import java.util.List;
import java.util.Optional;

import com.springbootems.model.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public Optional<Employee> findById(Integer id);
	
	public void add(Employee emp);
	public Optional<Employee> delete(Integer id);
}
