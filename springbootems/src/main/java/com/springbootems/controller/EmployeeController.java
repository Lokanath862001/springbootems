package com.springbootems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootems.model.Employee;
import com.springbootems.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return new ResponseEntity<List<Employee>> (empService.findAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Optional<Employee> empOpt = empService.findById(id);
		if(empOpt.isPresent()) {
			return new ResponseEntity<Employee>(empOpt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/add")
	public ResponseEntity<?> add(@Validated @RequestBody Employee emp){
		empService.add(emp);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
