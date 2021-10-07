package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="cemployee")
public class Employee {
	@Id
	@Column(name="id")
	int id;
	@Column(name="name")
	String name;

	@Column(name="address")
	String address;

	//	@Transient
	@JsonIgnore
	@OneToOne()
//	@JoinColumn(name = "eid")
	Manager manager;

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

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Employee(int id, String name, String address, Manager manager) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.manager = manager;
	}

	public Employee(){

	}
}
