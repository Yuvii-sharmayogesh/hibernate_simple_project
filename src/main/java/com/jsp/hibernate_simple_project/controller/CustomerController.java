package com.jsp.hibernate_simple_project.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_simple_project.dto.Customer;
import com.jsp.hibernate_simple_project.service.CustomerService;

public class CustomerController {
	
		public static void main(String[] args) {
		Scanner key = new  Scanner(System.in);
		
		CustomerService customerService = new CustomerService();
		
		while(true) {
			System.out.println("1.INSERT\n2.GETBYID\n3.UPDATE\n4.DELETE\n5.GETAllCUSTOMER");
			System.out.println("Choose Your Option......");
			
			int ch = key.nextInt();
			switch (ch) {
			
			case 1:{
				customerService.saveCustomerService(new Customer(512, "Ganesh datt", "ganeshcastus@gmail.com", "Noida", 9857545));
			}break;
			
			case 2:{
					System.out.println("Enter customer id");
					int id = key.nextInt();
					
					Customer customer=customerService.getcustomerByIdService(id);
					
					if(customer!=null) {
//						System.out.println("id = "+customer.getCustomerId());
//						System.out.println("name = "+customer.getCustomerName());
//						System.out.println("email = "+customer.getCustomerEmail());
//						System.out.println("address = "+customer.getCustomerAddress());
//						System.out.println("phone = "+customer.getCustomerPhone());
						
						System.out.println(customer);
					}else {
						System.out.println("id is not found please check once....");
					}
			}break;
			
			case 3:{
				System.out.println("Enter customer id");
				int id = key.nextInt();
				System.out.println("enter customer new name");
				String name = key.next();
				
				customerService.updateCustomerByIdService(id, name);
			}break;
			
			case 4:{
				System.out.println("enter customer id");
				int id = key.nextInt();
				customerService.deleteCustomerByIdService(id);
			}break;
			
			case 5:{
				List<Customer> customers=customerService.getAllcustomerDataService();
				
				Iterator<Customer> iterator = customers.iterator();
				
				while(iterator.hasNext()) {
					Customer customer = iterator.next();
					
					System.out.println("customerId = "+customer.getCustomerId());
					System.out.println("customerName = "+customer.getCustomerName());
					System.out.println("customerEmail = "+customer.getCustomerEmail());
					System.out.println("customerPhone = "+customer.getCustomerPhone());
					System.out.println("customerAddress = "+customer.getCustomerAddress());
				}
				
			
			}break;

			default:
				break;
			}
		}
		
	}
}

		
	
		
		
			
		
	
