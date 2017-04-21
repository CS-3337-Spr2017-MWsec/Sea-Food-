package models;

public class CustomerBean {
	String firstName;
	String lastName;
	String username;
	String password;
	String shippingAddress;
	String number;
	String email;
	String billingAddress;
	//TODO Finish list of properties.
	
	public CustomerBean(String username, String email, String password){
		this.username = username;
		this.email = email;
		this.password = password;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return shippingAddress;
	}

	public void setAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getBillingAddress(){
		return billingAddress;
	}
	
	public void setBillingAddress(String billingAddress){
		this.billingAddress = billingAddress;
	}
}