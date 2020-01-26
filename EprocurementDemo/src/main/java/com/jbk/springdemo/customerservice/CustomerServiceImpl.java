package com.jbk.springdemo.customerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jbk.springdemo.dao.CustomerDAO;
import com.jbk.springdemo.entity.Customer;
import com.jbk.springdemo.entity.User;
@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerDAO customerDAO;
	
	
	
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		return customerDAO.getCustomer();
	}



	@Override
	@Transactional
	public void savecustomer(Customer thecustomer) {
		customerDAO.savecustomer(thecustomer);
		
	}



	@Override
	@Transactional
	public Customer getCustomers(int theid) {
	
		return customerDAO.getCustomers(theid);
	}



	@Override
	@Transactional
	public void delete(int theid) {
		customerDAO.deletecustomer(theid);
		
	}



	@Override
	@Transactional
	public Customer checkuser(User user) {
		
		return customerDAO.checkuser(user);
	}



	@Override
	@Transactional
	public boolean checkAdmin(String userName, String password) {
		// TODO Auto-generated method stub
		return customerDAO.checkadmin(userName,password);
	}

}
