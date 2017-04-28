package models.practice;

public class Lab4User {
	
	static final int counter = 0;
	int id;
	String name;
	String username;
	String password;
	
	public Lab4User(String name, String username, String password)
	{
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public int id() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


}
