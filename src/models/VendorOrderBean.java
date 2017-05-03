package models;


public class VendorOrderBean {
	
	int orderId;
	int customerId;
	String firstName;
	String lastName;
	
	public VendorOrderBean()
	{
		
	}
	
	public VendorOrderBean(int orderId, int customerId) {
		
		this.orderId = orderId;
		this.customerId = customerId;
	}
	
	public VendorOrderBean(int orderId, int customerId, String firstName, String lastName) {
		
		this.orderId = orderId;
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
