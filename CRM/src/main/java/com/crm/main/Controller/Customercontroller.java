package com.crm.main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.main.Service.Customerservice;
import com.crm.main.model.Customer;

@RestController
public class Customercontroller {
	
	@Autowired
	private Customerservice customerService;
	
	
	//addCustomer
	@PostMapping(value = "/addCustomer")
	@CrossOrigin(origins="*") //for CORS policy 
	public Customer addCustomer(@RequestBody Customer customerDetail) throws Exception {
		String mailid = customerDetail.getCustomerEmail();
		//System.out.println("MAil id = "+mailid+ " "+mailid.length()); /// 
		if(mailid.length() > 1) {
			Customer tempuser = customerService.findUserByMailId(mailid);
			if(tempuser != null) {
				System.out.println("abh");
				throw new Exception("Customer with "+mailid+" Already exist. ");
			}
		}
		return customerService.registerCustomer(customerDetail);
	}
	
	//loginCustomer
	@PostMapping(value = "/loginCustomer")
	@CrossOrigin(origins="*")
	public Customer loginCustomer(@RequestBody Customer customer) throws Exception {
		String tempEmail = customer.getCustomerEmail();
		String tempPass = customer.getCustomerPassword();
		System.out.println(tempEmail+" ==== "+tempPass);
		Customer customerObj = null;
		if(tempEmail != null && tempPass != null) {
			 customerObj = customerService.fetchCustomerByEmailAndPassword(tempEmail, tempPass);
		}
		if(customerObj == null ) {
			throw new Exception("BAD CREDENTIALS.!!!!");
		}
		//productdetails.setCustomerId(customerObj.getCustomerId());
		return customerObj;
	}
	
	
}
