package com.login.Login.beans;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotEmpty;
import javax.persistence.*;

@Entity
@Table
public class Customer {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int c_id;
	
	@NotEmpty
	@Column
	private String c_name;
	
	@NotEmpty
	@Column
	private String c_mobile;
	
	@NotEmpty
	@Column
	private String c_mail;
	
	@NotEmpty
	@Column
	private String c_password;

	//setters and getters
	
	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_mobile() {
		return c_mobile;
	}

	public void setC_mobile(String c_mobile) {
		this.c_mobile = c_mobile;
	}

	public String getC_mail() {
		return c_mail;
	}

	public void setC_mail(String c_mail) {
		this.c_mail = c_mail;
	}

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}
	
	
	
}
