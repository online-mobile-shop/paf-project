package com.login.Login.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.login.Login.beans.Customer;
import com.login.Login.services.CustomerService;
import com.login.Login.validation.CustomerValidation;

@Controller
@RequestMapping(value = "/")

public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	//following methods are used for register processing
	@RequestMapping(value= "/register",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		model.put("customerData", new Customer());
		return "register/Register";
}
	
	@RequestMapping(value= "/register",method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("customerData")@Valid Customer customer, BindingResult br, HttpSession session) {
		CustomerValidation customerValidation = new CustomerValidation();
		customerValidation.validate(customerValidation, br);
	
		if(br.hasErrors()) {
			return "/register/Register";
			
		}else
			customerService.saveCustomer(customer);
		session.setAttribute("customer", customer);
		return "redirect:success";
	}

	//following two methods are for logging processing
	@RequestMapping(value= "/login",method = RequestMethod.GET)
	public String showLogin(ModelMap model, HttpSession session) {
		if(session.getAttribute("customer")==null) {
			model.put("customerData", new Customer());
			return "/login/Login";
		}else {
			return "redirect:success"; 
		}
	}
	
	@RequestMapping(value= "/login",method = RequestMethod.POST)
	public String DoLogin(ModelMap model, @ModelAttribute("customerData")Customer customer, HttpSession session){
		if(customer.getC_mail()!= null && customer.getC_password() != null && session.getAttribute("customer")==null) {
			customer = customerService.loginCustomer(customer);
			if(customer==null) {
				session.setAttribute("customer",customer);
				return "redirect:success"; 
			}else{
					model.put("failed", "Login failed");
					return "/login/Login";
				}
			}else{
					return "redirect:success"; 
				}
				
			}
	
	//this method is used to logout
	@RequestMapping(value= "/logout",method = RequestMethod.GET)
	public String logOut(ModelMap model, HttpSession session) {
		session.removeAttribute("customer");
		return "redirect:success"; 
	}
	
	/*@RequestMapping(value= "/success",method = RequestMethod.GET)
	public String logOut(ModelMap model) {
		model.put("success", new Customer());
		return "success"; 
	}*/
}