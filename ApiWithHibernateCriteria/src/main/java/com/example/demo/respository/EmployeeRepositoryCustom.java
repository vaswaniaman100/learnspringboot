package com.example.demo.respository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeRepositoryCustom  {
	List<Employee> getemployeelist();
	void deleteEmployee(int id);
	void insertEmployee(Employee emp);
	void updateEmployee(Employee emp);
	
}
