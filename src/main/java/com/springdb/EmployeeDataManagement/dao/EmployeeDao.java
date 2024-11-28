package com.springdb.EmployeeDataManagement.dao;

import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdb.EmployeeDataManagement.entity.Employee;

import jakarta.persistence.criteria.AbstractQuery;
import jakarta.persistence.criteria.Root;


@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory factoty;
	
	public String insertData(Employee e) {
		
		Session ss = factoty.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(e);
		tr.commit();
		ss.close();
		
		return "Employee has been added....";		
		
	}
	
	public String deleteData(int emp_id) {
		
		Session ss = factoty.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e = ss.get(Employee.class, emp_id);
		ss.remove(e);
		tr.commit();
		ss.close();
		
		return "Employee has been removed....";		
		
	}

	public Employee getSingleData(int emp_id) {
		Session ss = factoty.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e = ss.get(Employee.class, emp_id);
		
		return e;
	}

	public List<Employee> getAllData() {

		Session ss = factoty.openSession();
		Transaction tr = ss.beginTransaction();
		
		HibernateCriteriaBuilder cb = ss.getCriteriaBuilder();
		JpaCriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = ((AbstractQuery<Employee>)cq).from(Employee.class);
		cq.select(root);
		Query<Employee> query = ss.createQuery(cq);
		
		List<Employee> list = query.getResultList();				
		
		return list;
	}

	public String updateData(Employee e, int emp_id) {
		Session ss = factoty.openSession();
		Transaction tr = ss.beginTransaction();
		
		Employee e1 = ss.get(Employee.class, emp_id);
		e1.setEmp_age(e.getEmp_age());
		
		ss.merge(e1);
		tr.commit();
		ss.close();
		return "Employee has been updated....";		
	}
	
	
	
	
}
