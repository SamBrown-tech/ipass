package nl.hu.ipass.gitaarshop.model;

public class Person {
	private int person_id;
	private String email;
	private String firstname;
	private String lastname;
	private String city;
	private String zip_code;
	private String password;
	private String phone_number;
	private String role;
	
	// Getters

	public int getId() {
		return person_id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getZipCode() {
		return zip_code;
	}
	
	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phone_number;
	}
	
	public String getRole() {
		return role;
	}
	
	// Setters

	public void setId(int person_id) {
		this.person_id = person_id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}

	public void setRole(String role) {
		this.role = role;
	}
}