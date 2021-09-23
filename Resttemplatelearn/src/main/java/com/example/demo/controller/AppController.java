package com.example.demo.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.client.RestTemplate;

@Controller
public class AppController {

    @Autowired
    EmployeeService empser;

    @Autowired
    RestTemplate template;

//    @RequestMapping("/template/view")
//    @ResponseBody
//    public ResponseEntity<String> templateview() {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        System.out.println(template.getForEntity("http://localhost:8080/view", String.class));
//        return template.getForEntity("http://localhost:8080/view", String.class);
//    }

    @GetMapping(value = "/template/view")
    @ResponseBody
    public List<Employee> templateView() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return Arrays.asList( template.exchange("http://localhost:8080/view", HttpMethod.GET, null, Employee[].class).getBody());
    }
//
//    @PostMapping(value = "/template/insert" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<Employee[]> postTemplateInsert(@RequestBody Employee emp) throws Exception {
//
//
//        System.out.println(emp.getName());
//        ResponseEntity<Employee[]> re =template.postForEntity("http://localhost:8080/insert",emp ,Employee[].class);
//        return re;
//
//    }
    @PostMapping(value = "/template/insert" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Employee> postTemplateInsert(@RequestBody Employee emp) throws Exception {


        MultiValueMap<String, String> req= new LinkedMultiValueMap<String, String>();
        req.add("name", emp.getName());
        req.add("address", emp.getAddress());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(req,headers);


        return Arrays.asList( template.exchange("http://localhost:8080/insert", HttpMethod.POST, entity, Employee[].class).getBody());

    }

    @PutMapping(value = "/template/insert" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Employee> putTemplateInsert(@RequestBody Employee emp) throws Exception {


        MultiValueMap<String, Object> req= new LinkedMultiValueMap<String, Object>();
        req.add("id", emp.getId());
        req.add("name", emp.getName());
        req.add("address", emp.getAddress());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(req,headers);


        return Arrays.asList( template.exchange("http://localhost:8080/insert", HttpMethod.PUT, entity, Employee[].class).getBody());

    }

    @DeleteMapping(value = "/template/delete/{id}")
    @ResponseBody
    public List<Employee> putTemplateDelete(@PathVariable int id) throws Exception {


        return Arrays.asList( template.exchange("http://localhost:8080/delete/"+ id, HttpMethod.DELETE, null, Employee[].class).getBody());

    }




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
        List<Employee> emp = empser.getemployees();

        return emp;
    }


    //insert employees

    @PostMapping(path = "/insert")
    @ResponseBody
    public List<Employee> insert(HttpServletRequest request ) {

        String name = request.getParameter("name");

        String address = request.getParameter("address");
        empser.insert(name, address);

        return this.view();
    }
//    @PostMapping(path = "/insert")
//    @ResponseBody
//    public ResponseEntity<List<Employee>> insert( @RequestBody Employee emp) {
//        System.out.println("hello");
//        String name = emp.getName();
//
//        String address = emp.getAddress();
//        empser.insert(name, address);
//
//        return new ResponseEntity<List<Employee>>(this.view(), HttpStatus.OK);
//    }


    // insert or update employees
    @PutMapping(path = "/insert")
    @ResponseBody

    public List<Employee> putinsert(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        empser.insertorupdate(id, name, address);

        return this.view();
    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseBody
    public List<Employee> delete(@PathVariable int id) {


        empser.delete(id);

        return this.view();
    }

}
