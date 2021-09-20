package com.example.demo.respository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
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

}
