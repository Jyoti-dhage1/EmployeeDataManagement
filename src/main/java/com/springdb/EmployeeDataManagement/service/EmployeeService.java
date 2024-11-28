package com.springdb.EmployeeDataManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdb.EmployeeDataManagement.dao.EmployeeDao;
import com.springdb.EmployeeDataManagement.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao empdao;
	
	public String insertData(Employee e) {
		String msg = empdao.insertData(e);		
		return msg;		
	} 

	
	public String deleteData(int emp_id) {
		String msg = empdao.deleteData(emp_id);
		return msg;
	}


	public Employee getSingleData(int emp_id) {
		Employee e = empdao.getSingleData(emp_id);
		return e;
	}


	public List<Employee> getAllData() {
		List<Employee> e =  empdao.getAllData();
		return e;
	}


	public String updateData(Employee e, int emp_id) {
		String msg =  empdao.updateData(e, emp_id);
		return msg;			
	}


}
