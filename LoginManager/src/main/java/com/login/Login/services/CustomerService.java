package com.login.Login.services;

import com.login.Login.beans.Customer;

public interface CustomerService {

	public void saveCustomer(Customer customer);
	public Customer loginCustomer(Customer customer);
}
