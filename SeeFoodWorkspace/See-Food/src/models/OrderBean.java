package models;

import java.util.Date;

public class OrderBean {
	Integer id;
	String name;
	String description;
	Double weight;
	Double length;
	Integer quantity;
	Date date;
	
	public OrderBean(int id, String name, String description, double weight, double length, int quantity, Date date){
		this.id = id;
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.length = length;
		this.date = date;
		this.quantity = quantity;
	}
}