package com.example.demo.service;


import com.example.demo.model.Manager;
import com.example.demo.respository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    ManagerRepository managerRepository;


    public void saveManager(int id, String name , String address){
        Manager manager = new Manager();
        manager.setId(id);
        manager.setName(name);
        manager.setAddress(address);
        managerRepository.save(manager);
    }
    public List<Manager> getManagers(){
        return managerRepository.findAll();
    }

}
