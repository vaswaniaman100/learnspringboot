package com.example.demo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.respository.EmployeeRepository;


@Service
public class EmployeeService {
	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	EmployeeRepository rep;
	
	
	Employee emp;
	
	
	public List<Employee> getemployees(){
		
		return rep.findAll();
	}
	public List<Employee> viewtwobyhibernate(){
		Pageable limit = PageRequest.of(0,2	);
		return rep.findAll(limit).getContent();
	}
	public List<Employee> viewtwobypath(List<Integer>  id){

		return rep.gettwobypath(id);
	}
}
