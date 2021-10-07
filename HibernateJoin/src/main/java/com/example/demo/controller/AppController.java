package com.example.demo.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class AppController {

    @Autowired
    EmployeeService empser;

    @Autowired
    ManagerService managerService;

    @RequestMapping("/insertemployee")
	public List<Employee> insertemployee(@RequestParam("id" )String id,@RequestParam("name" )String name,
                               @RequestParam("address") String address,@RequestParam("manager") String manager){

        System.out.println(name+" "+address+" "+manager );
        empser.saveEmployee(Integer.parseInt(id),name,address,manager);
        return empser.getEmployees();

	}
    @RequestMapping("/insertmanager")
    public List<Manager> insertManager(@RequestParam("id" )String id,@RequestParam("name" )String name,
                                       @RequestParam("address") String address){

        managerService.saveManager(Integer.parseInt(id),name,address);
        return managerService.getManagers();

    }
    @RequestMapping("/getemployee")
    public List<Employee> getemployee(){


        return empser.getEmployees();

    }
    @RequestMapping("/getmanager")
    public List<Manager> getmanager(){

        return managerService.getManagers();

    }


}
