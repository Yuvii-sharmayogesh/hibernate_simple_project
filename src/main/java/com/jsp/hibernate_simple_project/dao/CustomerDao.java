package com.jsp.hibernate_simple_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernate_simple_project.dto.Customer;

public class CustomerDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("yogesh");
	EntityManager entitymanager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entitymanager.getTransaction();
	
	/*
	 * save customer method........
	 */
	public Customer saveCustomer(Customer customer) {

		entityTransaction.begin();
		entitymanager.persist(customer);
		entityTransaction.commit();
		
		return customer;
	}
	
	/*
	 * get Customer by id
	 */
	
	public Customer getcustomerByIdDao(int id) {
		return entitymanager.find(Customer.class, id);
	}
	
	
	
	/*
	 * update Customer by id
	 */
	public Customer updateCustomerByIdDao(int id,String name) {
		Customer customer=getcustomerByIdDao(id);
		if(customer!=null) {
			customer.setCustomerName(name);
			entityTransaction.begin();
			entitymanager.merge(customer);
			entityTransaction.commit();
			
			return customer;
		}else {
			return customer;
		}
	}
	
	/*
	 * deleteCustomer by id
	 */
	public void deleteCustomerByIdDao(int customerId) {
		Customer customer=getcustomerByIdDao(customerId);
		
		if (customer!=null) {
			entityTransaction.begin();
			entitymanager.remove(customer);
			entityTransaction.commit();
			
		}

	}
	/*
	 * getAllCustomerdata
	 */
	
	public List<Customer> getAllcustomerDataDao(){
		String displayQuery = "FROM Customer";
		return entitymanager.createQuery(displayQuery).getResultList();
		//return query.getResultList();
	}
}
