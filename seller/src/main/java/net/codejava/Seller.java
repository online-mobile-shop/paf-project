package net.codejava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seller {
	private int idSeller;
	private String Name;
	private String Address;
	private String p_details;
	
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdSeller() {
		return idSeller;
	}

	public void setIdSeller(int idSeller) {
		this.idSeller = idSeller;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getP_details() {
		return p_details;
	}

	public void setP_details(String p_details) {
		this.p_details = p_details;
	}
	
	

}
