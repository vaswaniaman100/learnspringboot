package com.example.demo.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.helper.JwtUtil;
import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.service.CustomUsersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
@Controller
public class AppController {

@Autowired
EmployeeService empser;

@Autowired
CustomUsersDetailsService customUsersDetailsService;
@Autowired
JwtUtil jwtUtil;
@Autowired
AuthenticationManager authenticationManager;

//	Token Generation

	@PostMapping("/token")
	public ResponseEntity<JwtResponse> getToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println(jwtRequest);
		try{
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
		}catch (Exception e){
			e.printStackTrace();
			throw new Exception("wrong details");
		}

		UserDetails userDetails = this.customUsersDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	//homepag
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
