package com.login.Login.validation;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.login.Login.beans.Customer;

public class CustomerValidation implements Validator{

	public boolean supports(Class<?>argo) {
		return Customer.class.equals(argo);
		
	}
	

	@Override
	public void validate(Object argo, Errors arg1) {
		// TODO Auto-generated method stub
		
	}
}
