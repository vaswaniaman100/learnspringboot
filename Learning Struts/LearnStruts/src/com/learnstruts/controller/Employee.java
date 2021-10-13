package com.learnstruts.controller;

import java.sql.SQLException;
import java.util.List;

import com.learnstruts.service.EmployeeDao;

public class Employee {
	public int id;
	public String name;
	public String address;
	public List<Employee> empList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	public String register() throws ClassNotFoundException, SQLException {
		if(getId()!=0 && getName()!=null && getAddress()!=null) {
			
			new EmployeeDao().addemployee(getId(), getName(), getAddress());
		}
		System.out.println(this.getId()+" "+this.getName()+" "+this.getAddress());
		return "success";
	}
	
	public String getdata() throws ClassNotFoundException, SQLException {
		
		List<Employee> empl = new EmployeeDao().getemplist();
		setEmpList(empl);
		
		
		
		return "success";
	}
	
	public String updateemp() throws ClassNotFoundException, SQLException {
		
		if(getId()!=0 && getName()!=null && getAddress()!=null) {			
			new EmployeeDao().updateEmp(getId(), getName(), getAddress());
		}
		return "success";
		
	}
	public String deleteemp() throws ClassNotFoundException, SQLException {
		
		if(getId()!=0 ) {			
			new EmployeeDao().deleteemp(getId());
		}
		return "success";
		
	}
		
	
	
	
}
