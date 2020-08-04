package com.softserve.edu;

public class User {
	private String email;
	private String userName;
	private String password;
	private String confPassword;

	public User(String email, String userName, String password, String confPassword) {
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.confPassword = confPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getConfPassword() {
		return confPassword;
	}

}
