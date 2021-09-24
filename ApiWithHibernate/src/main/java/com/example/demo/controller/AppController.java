package com.example.demo.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	@GetMapping("/viewemployeebyname")
	@ResponseBody
	public List<LinkedHashMap<String,String>> viewemployeebyname() {
	List<Employee> emp=	empser.getemployees();
	List<LinkedHashMap<String,String>> namesofemp = new ArrayList<>();
	for(Employee e : emp) {
		namesofemp.add(new LinkedHashMap<String, String>(){
			{
				put("name", e.getName());		
			}
		});
	}
	
		return namesofemp;
	}
	
	//insert employees
	
	@PostMapping(path = "/insert")
	@ResponseBody
	public List<Employee> insert(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		empser.insert( name,address); 
		
		return this.view();
	}
	
	
	// insert or update employees
	@PutMapping(path = "/insert")
	@ResponseBody
	public List<Employee> putinsert(HttpServletRequest request) {
		int id =Integer.parseInt( request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		empser.insertorupdate(id, name,address); 
		
		return this.view();
	}
	@DeleteMapping(path = "/delete/{id}")
	@ResponseBody
	public List<Employee> delete(@PathVariable int id) {
		
		
		empser.delete(id); 
		
		return this.view();
	}

}
