package com.jsp.hibernate_simple_project.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
	
	@Id
	private int customerId;
	private String customerName;
	private String customerEmail;
	private String customerAddress;
	private long customerPhone;
	

}
