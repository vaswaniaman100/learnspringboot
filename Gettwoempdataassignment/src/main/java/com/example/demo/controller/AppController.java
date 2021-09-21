package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
@Controller
public class AppController {

@Autowired
EmployeeService empser;
	//homepage
	@RequestMapping("/")
	@ResponseBody
	public String hello() {

		return "Welcome	";
		
	}
	
	//  view employees
	
	@GetMapping("/view")
	@ResponseBody
	public List<Employee> view() {
	List<Employee> emp=	empser.getemployees();
	
		return emp;
	}
	
	@GetMapping("/viewtwobyhibernate")
	@ResponseBody
	public List<Employee> viewtwobyhibernate() {
		List<Employee> emp=	empser.viewtwobyhibernate();
		
			return emp;
	}
	@GetMapping("/viewtwobypath/{id}")
	@ResponseBody
	public List<Employee> viewtwobypath(@PathVariable List<Integer> id) {
		List<Employee> emp=	empser.viewtwobypath(id);
		System.out.println(id);
			return emp;
	}
	
	
	
	

}
