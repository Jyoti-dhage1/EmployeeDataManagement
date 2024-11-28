package com.springdb.EmployeeDataManagement.controller;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdb.EmployeeDataManagement.entity.Employee;
import com.springdb.EmployeeDataManagement.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService emp_serv;
	
	@PostMapping("/saveData")
	public String insertData(@RequestBody Employee e) {
		String msg =  emp_serv.insertData(e);
		return msg;
		
	}
	
	@DeleteMapping("/deleteData/{emp_id}")
	public String deleteData(@PathVariable int emp_id) {
		String msg =  emp_serv.deleteData(emp_id);
		return msg;
	}
	
	@GetMapping("/getSingleData/{emp_id}")
	public Employee getSingleData(@PathVariable int emp_id) {
		Employee e =  emp_serv.getSingleData(emp_id);
		return e;
	}
	
	@GetMapping("/getAllData")
	public List<Employee> getAllData() {
		List<Employee> e =  emp_serv.getAllData();
		return e;
	}
	
	@PutMapping("/updateData/{emp_id}")
	public String updateData(@RequestBody Employee e, @PathVariable int emp_id) {
		String msg =  emp_serv.updateData(e, emp_id);
		return msg;		
	}	
	
	
	

}
