package com.learnstruts.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learnstruts.controller.Employee;



public class EmployeeDao {
	public void addemployee(int id,String name,String address) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
	      //Getting the connection
	      String mysqlUrl = "jdbc:mysql://localhost/employee";
	      Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
	      PreparedStatement stmt=con.prepareStatement("insert into checkemp values(?,?,?)");  
	      stmt.setInt(1,id);//1 specifies the first parameter in the query  
	      stmt.setString(2,name);  
	      stmt.setString(3,address);  
	        
	      int i=stmt.executeUpdate();  
	      con.close();
	}
	
	public List<Employee> getemplist() throws SQLException, ClassNotFoundException{

		List<Employee> empl = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		String mysqlUrl = "jdbc:mysql://localhost/employee";
		 Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
		 String sql ="call GETEMPLOYEE";
		  CallableStatement stmt = con.prepareCall(sql);
		  stmt.execute();
		  ResultSet rs = stmt.getResultSet();
		  while(rs.next()) {
			  Employee emp = new Employee();
			  emp.setId(rs.getInt(1));
			  emp.setName(rs.getString(2));
			  emp.setAddress(rs.getString(3));
			  empl.add(emp);
			  
		  }
		  System.out.println(empl.toString());
		return empl;
	}
	public void updateEmp(int id,String name,String address) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String mysqlUrl = "jdbc:mysql://localhost/employee";
		 Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
		 String sql ="call UPDATEEMP(?,?,?)";
		  CallableStatement stmt = con.prepareCall(sql);
		  stmt.setInt(1,id);
		  stmt.setString(2,name);  
		  stmt.setString(3,address);  
		  stmt.executeUpdate();  
	      con.close();
	}
	public void deleteemp(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String mysqlUrl = "jdbc:mysql://localhost/employee";
		 Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
		 String sql ="call DELETEEMP(?)";
		  CallableStatement stmt = con.prepareCall(sql);
		  stmt.setInt(1,id);  
		  stmt.executeUpdate();  
	      con.close();
	}
	
} 
