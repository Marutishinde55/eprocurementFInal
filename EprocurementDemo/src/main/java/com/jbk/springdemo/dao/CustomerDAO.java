package com.jbk.springdemo.dao;

import java.util.List;

import com.jbk.springdemo.entity.Customer;
import com.jbk.springdemo.entity.User;

public interface CustomerDAO  {

	
	
	public List<Customer> getCustomer();

	public void savecustomer(Customer thecustomer);

	public Customer getCustomers(int theid);

	public void deletecustomer(int theid);

	
	public boolean checkadmin(String userName, String password);

	public Customer checkuser(User user);

	


	
}
