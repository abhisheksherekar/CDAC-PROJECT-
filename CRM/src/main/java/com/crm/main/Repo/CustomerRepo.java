package com.crm.main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.main.model.Customer;



@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	public Customer findByCustomerEmail(String mailid);
	public Customer findByCustomerEmailAndCustomerPassword(String mailid, String password);
}
