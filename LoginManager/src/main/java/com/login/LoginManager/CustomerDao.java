package com.login.LoginManager;

import com.login.Login.beans.Customer;

public interface CustomerDao {
	
	public void saveCustomer(Customer customer);
	public Customer loginCustomer(Customer customer);

}
