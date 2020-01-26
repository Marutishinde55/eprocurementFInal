package com.jbk.springdemo.customerservice;

import java.util.List;

import com.jbk.springdemo.entity.Customer;
import com.jbk.springdemo.entity.User;

public interface CustomerService {
	
 public List<Customer> getCustomer();

public void savecustomer(Customer thecustomer);

public Customer getCustomers(int theid);

public void delete(int theid);

public boolean checkAdmin(String userName, String password);

public Customer checkuser(User user);


}
  