package com.example.demo.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
@Controller
public class AppController {
	//get post put delete
@Autowired
JdbcTemplate jdbctemplate;
@Autowired
EmployeeService empser;
	
	@RequestMapping("/")
	public String hello() {

		return "insert.jsp";
		
	}
	@RequestMapping("/view")
	public String view(Model m) {
	List<Employee> emp=	empser.getemployees();
	m.addAttribute("employeedata", emp);
		return "viewemployee.jsp";
	}
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(HttpServletRequest request) {
		int id =Integer.parseInt( request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String a = empser.insert(id, name,address); 
		return a;
	}
	

}
