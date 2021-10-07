package com.example.demo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Manager;
import com.example.demo.respository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.respository.EmployeeRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmployeeService {
//	@Autowired
//	JdbcTemplate jdbc;

	@Autowired
	ManagerRepository managerRepository;

	@Autowired
	EmployeeRepository rep;

	@Transactional
	public void saveEmployee(int id,String name,String address,String managername){
	 Manager ma	=  managerRepository.findByName(managername);
	 Employee emp = new Employee();
	 emp.setId(id);
	 emp.setName(name);
	 emp.setAddress(address);
	 emp.setManager(ma);
	 rep.save(emp);

	 if(ma.getEmployees()==null){
		 List<Employee> employeeList = new ArrayList<>();
		 employeeList.add(emp);
		 ma.setEmployees(employeeList);
		 managerRepository.save(ma);

	 }
	 else{
		 List<Employee> employeeList = ma.getEmployees();
		 employeeList.add(emp);
		 ma.setEmployees(employeeList);
		 managerRepository.save(ma);
	 }

	}
	public List<Employee> getEmployees(){
		return rep.findAll();
	}
}
