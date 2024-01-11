package com.jsp.hibernate_simple_project.service;

import java.util.List;

import com.jsp.hibernate_simple_project.dao.CustomerDao;
import com.jsp.hibernate_simple_project.dto.Customer;

public class CustomerService {
	
	CustomerDao customerDao= new CustomerDao();
	
	/*
	 * save customer method....
	 */
	public Customer saveCustomerService(Customer customer) {
		
		return customerDao.saveCustomer(customer);
	}
	
	/*
	 * get customer by id
	 */
	
	public Customer getcustomerByIdService(int id) {
		return customerDao.getcustomerByIdDao(id);
	}
	
	/*
	 * update customerById
	 */
	public Customer updateCustomerByIdService(int id,String name) {
		Customer customer=customerDao.updateCustomerByIdDao(id, name);
		
		if(customer!=null) {
			System.out.println("Data---Updated");
		}else {
			System.out.println("Id is not present....");
		}
		return customer;
	}
	/*
	 * delete CustomerById
	 */
	
	public void deleteCustomerByIdService(int customerId) {
		Customer customer=customerDao.getcustomerByIdDao(customerId);
	
		
		if(customer!=null) {
		customerDao.deleteCustomerByIdDao(customerId);	
		System.out.println("Data---Deleted");
		}else {
			System.out.println("Id is not present....");
		}
		}
	/*
	 * getAllCustomerdata
	 */
	
	public List<Customer> getAllcustomerDataService(){
		return customerDao.getAllcustomerDataDao();
	}
}
