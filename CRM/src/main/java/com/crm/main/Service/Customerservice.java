package com.crm.main.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.main.Repo.CustomerRepo;
import com.crm.main.model.Customer;



public class Customerservice {


	@Autowired
	private CustomerRepo customerRepo;	

	public Customer registerCustomer(Customer customerDetail) {
		return customerRepo.save(customerDetail);
	}
	
	public Customer findUserByMailId(String mailid) {
		System.out.println("in service");
		return customerRepo.findByCustomerEmail(mailid);		
	}
	
	public Customer fetchCustomerByEmailAndPassword(String mailid, String password) {
		return	customerRepo.findByCustomerEmailAndCustomerPassword(mailid, password);
	}
	
	
}
