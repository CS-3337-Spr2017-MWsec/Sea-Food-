package models;

public class CustomerBean {
	String username;
	String password;
	String email;

	String firstName;
	String lastName;
	String shippingAddress;
	String number;
	String billingAddress;
	Integer card;
	//TODO Finish list of properties.
	
	//adding properties for orderDetails module
	String shippingState;
	int shippingZip;
	String shippingStreetAddress;
	String telephone;
	String billingStreetAddress;
	String billingCity;
	String billingState;
	int billingZip;

	
	
	
	public CustomerBean(String username, String email, String password){
		this.username = username;
		this.email = email;
		this.password = password;
	}
	

	public CustomerBean(String firstName) {
		this.firstName = firstName;
	}

	//constructor for orderDetailsController
	public CustomerBean(String firstName, String lastName, String shippingStreetAddress,
			String shippingCity, String shippingState, int shippingZip, String billingStreetAddress, String billingCity,
			String billingState, int billingZip, String telephone, String email) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.shippingStreetAddress = shippingStreetAddress;
		this.shippingCity = shippingCity;
		this.shippingState = shippingState;
		this.shippingZip = shippingZip;
		this.billingStreetAddress = billingStreetAddress;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZip = billingZip;
	}

	//testing constructor for orderDetailsController
	public CustomerBean(String firstName, String lastName, String shippingStreetAddress,
			String shippingCity, String shippingState, int shippingZip,String email, String telephone) {

		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.shippingStreetAddress = shippingStreetAddress;
		this.shippingCity = shippingCity;
		this.shippingState = shippingState;
		this.shippingZip = shippingZip;
		this.telephone = telephone;
		
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
	
	public Integer getCard(){
		return card;
	}
	public void setCard(Integer card){
		this.card = card;
	}
	
	String shippingCity;
	public String getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public String getShippingCity() {
		return shippingCity;
	}


	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}


	public String getShippingState() {
		return shippingState;
	}


	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}


	public int getShippingZip() {
		return shippingZip;
	}


	public void setShippingZip(int shippingZip) {
		this.shippingZip = shippingZip;
	}


	public String getShippingStreetAddress() {
		return shippingStreetAddress;
	}


	public void setShippingStreetAddress(String shippingStreetAddress) {
		this.shippingStreetAddress = shippingStreetAddress;
	}


	public String getBillingStreetAddress() {
		return billingStreetAddress;
	}


	public void setBillingStreetAddress(String billingStreetAddress) {
		this.billingStreetAddress = billingStreetAddress;
	}


	public String getBillingCity() {
		return billingCity;
	}


	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}


	public String getBillingState() {
		return billingState;
	}


	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}


	public int getBillingZip() {
		return billingZip;
	}


	public void setBillingZip(int billingZip) {
		this.billingZip = billingZip;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}