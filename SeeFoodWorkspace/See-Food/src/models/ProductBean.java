package models;

public class ProductBean {
	static int idCount = 1000;
	
	Integer id;
	String name;
	int quantity;
	int stock;
	String description;
	boolean delete;
	Double price;
	
	public ProductBean(String name, String description, int stock, double price){
		this.id = idCount++;
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.delete = false;
		this.price = price;
	}
	
	public Integer getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public int getQuantity(){
		return quantity;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public int getStock(){
		return stock;
	}
	public void setStock(int stock){
		this.stock = stock;
	}
	
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	
	public boolean isDelete(){
		return delete;
	}
	public void setDelete(boolean delete){
		this.delete = delete;
	}
	
	public Double getPrice(){
		return price;
	}
	public void setPrice(Double price){
		this.price = price;
	}
}