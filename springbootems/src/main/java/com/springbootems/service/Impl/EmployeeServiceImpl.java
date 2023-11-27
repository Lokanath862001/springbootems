package com.springbootems.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootems.model.Employee;
import com.springbootems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	public static List<Employee> empList = new ArrayList<>();
	private static Integer counter =1;
	static {
		Employee emp = new Employee(counter++, "Lokanath", "Sethy", 39, 10);
		empList.add(emp);
		emp = new Employee(counter++, "Madhusmita", "Samantaray", 39, 20);
		empList.add(emp);
	}
	@Override
	public List<Employee> findAll(){
		return empList;
	}

	@Override
	public Optional<Employee> findById(Integer id) {
		return empList.stream().filter(emp->emp.getEmpId()==id).findFirst();
	}

	@Override
	public void add(Employee emp) {
		emp.setEmpId(counter++);
		empList.add(emp);
	}

	@Override
	public Optional<Employee> delete(Integer id) {
		return Optional.empty();
	}
}