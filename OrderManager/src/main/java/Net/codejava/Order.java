package Net.codejava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
	private int idorders;
	private String ItemName;
	private String Quantity;
	private String Item_details;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdorders() {
		return idorders;
	}
	public void setIdorders(int idorders) {
		this.idorders = idorders;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public String getItem_details() {
		return Item_details;
	}
	public void setItem_details(String item_details) {
		Item_details = item_details;
	}
	
	
	

}
