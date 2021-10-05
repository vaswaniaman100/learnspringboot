package com.example.demo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.respository.EmployeeRepository;


@Service
public class EmployeeService {
//	@Autowired
//	JdbcTemplate jdbc;
	
	@Autowired
	EmployeeRepository rep;
	
	
	Employee emp;
	public void insert(String name,String address) {
		emp = new Employee();
		emp.setName(name);
		emp.setAddress(address);
		rep.save(emp);
		
	}
	public void insertorupdate(int id, String name,String address) {
		emp = new Employee();
		try {
			emp = rep.getById(id);
		}
		catch (Exception e) {
			
		}
		
		emp.setName(name);
		emp.setAddress(address);
		rep.save(emp);
		
	}
	public void delete(int id) {
		emp= new Employee();
		emp.setId(id);
		rep.delete(emp);
		
	}
	
	
	public List<Employee> getemployees(){
		
		return rep.getemployeelist();
	}
}
