package com.example.demo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;


@Service
public class EmployeeService {
	@Autowired
	JdbcTemplate jdbc;
	
	public void insert(int id, String name,String address) {
		
		jdbc.execute("insert into employee value(?,?,?)",new PreparedStatementCallback<Boolean>(){  
		    @Override  
		    public Boolean doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		              
		        ps.setInt(1,id);  
		        ps.setString(2,name);  
		        ps.setString(3,address);  
		              
		        return ps.execute();  
		              
		    }  
		  });  
	
	}
	public void insertorupdate(int id, String name,String address) {
		
		jdbc.execute("insert into employee value(?,?,?) ON DUPLICATE KEY UPDATE id =?,name=?,address =?",new PreparedStatementCallback<Boolean>(){  
			@Override  
			public Boolean doInPreparedStatement(PreparedStatement ps)  
					throws SQLException, DataAccessException {  
				
				ps.setInt(1,id);  
				ps.setString(2,name);  
				ps.setString(3,address);  
				ps.setInt(4,id);  
				ps.setString(5,name);  
				ps.setString(6,address);  
				
				return ps.execute();  
				
			}  
		});  	
	}
	public void delete(int id) {
		
		String delsql = "delete from employee where id = ?";
		
		jdbc.update(delsql,id);
	}
	
	
	public List<Employee> getemployees(){
		List<Employee> ls = jdbc.query("select * from employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setAddress(rs.getString(3));
				return emp;
			}
			
		});
		return ls;
	}
}
