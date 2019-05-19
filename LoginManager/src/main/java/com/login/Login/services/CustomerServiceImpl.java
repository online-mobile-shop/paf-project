package com.login.Login.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.login.Login.beans.Customer;
import com.login.LoginManager.*;


public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	
	}

	@Override
	public Customer loginCustomer(Customer customer) {
		
		return customerDao.loginCustomer(customer);
	}

}
