package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUsersDetailsService implements UserDetailsService {

    @Autowired
    EmployeeService empservice;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employee emp =empservice.getbyEmployeeName(username);
        if(empservice.getEmployeeName(username) !=null){
            return new User(emp.getName(),emp.getAddress(),new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("user not found");
        }

    }
}
