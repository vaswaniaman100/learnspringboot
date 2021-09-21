package com.example.demo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.respository.EmployeeRepository;
import com.example.demo.respository.EmployeeRepositoryCustom;

@Service
public class EmployeeService {
	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	EmployeeRepository rep;
	
	
	
	@Autowired
	@Qualifier("employeeRepositoryCustomImpl") //optional for ambiguity
	EmployeeRepositoryCustom customrep;

	Employee emp;

	public void insert(String name, String address) {
		emp = new Employee();
		emp.setName(name);
		emp.setAddress(address);
		customrep.insertEmployee(emp);

	}

	public void insertorupdate(int id, String name, String address) {
		emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setAddress(address);
		customrep.updateEmployee(emp);

	}


	public List<LinkedHashMap<String, Object>> getemployeedata() {
		Object[][] vemp = rep.getemployeedata();
		List<LinkedHashMap<String, Object>> listemp = new ArrayList<>();
		for(int i =0;i<vemp.length;i++) {
			LinkedHashMap<String, Object> empobj = new LinkedHashMap<>();
			
			empobj.put("id", vemp[i][0]);
			empobj.put("name", vemp[i][1]);
			empobj.put("address", vemp[i][2]);
			listemp.add(empobj);
		}
		
		return listemp;
		

	}

	public List<Employee> getemployees() {

		return rep.getemployeelist();
	}

	public void delete(int id) {
//		emp = new Employee();
//		emp.setId(id);
		customrep.deleteEmployee(id);
		
	}
	
	public List<Employee> criteriagetemployees() {

		return customrep.getemployeelist();
	}
}
