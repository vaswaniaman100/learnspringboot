package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value ="select * from employee e",nativeQuery=true)
	List<Employee> getemployeelist();
	
	@Query(value ="select * from employee where id in :id",nativeQuery=true)
	List<Employee> gettwobypath(@Param("id") List<Integer> id);
	
}
