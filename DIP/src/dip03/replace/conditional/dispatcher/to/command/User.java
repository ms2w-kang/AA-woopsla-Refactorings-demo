package dip03.replace.conditional.dispatcher.to.command;

public class User {

	private String name;
	private String address;
	private String phone;
	
	public User(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}
}
