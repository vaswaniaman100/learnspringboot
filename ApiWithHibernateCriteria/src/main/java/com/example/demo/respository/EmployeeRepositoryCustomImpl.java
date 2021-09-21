package com.example.demo.respository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Component  //optional for ambiguity
@Qualifier("employeeRepositoryCustomImpl")  //optional for ambiguity
@Repository("employeeRepositoryCustom")
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {
	@Autowired
	EmployeeRepository repo;
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Employee> getemployeelist() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		Root<Employee> root = query.from(Employee.class);
		query.select(root);
		
		
		//Query q = (Query) em.createQuery(select);
		TypedQuery<Employee> q =  em.createQuery(query);
				
		List<Employee> list = q.getResultList();  
		return list;
	}
	@Override
	@Transactional
	public void deleteEmployee(int id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<Employee> cd = cb.createCriteriaDelete(Employee.class);
		Root<Employee> root = cd.from(Employee.class);
		cd.where(cb.equal(root.get("id"), id));
		em.createQuery(cd).executeUpdate();
		
	}
	@Override
	public void insertEmployee(Employee emp) {
		 
		  repo.save(emp);
		
	}
	
	@Override
	@Transactional
	public void updateEmployee(Employee emp) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<Employee> update = cb.createCriteriaUpdate(Employee.class);
		Root<Employee> root = update.from(Employee.class);
		update.set("name", emp.getName());
		update.set("address", emp.getAddress());
		update.where(cb.equal(root.get("id"), emp.getId()));
		int a = em.createQuery(update).executeUpdate();
		if(a==0) {
			this.insertEmployee(emp);//only if update fails
		}
	}

}
