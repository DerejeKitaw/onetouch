package com.onetouch.models;

public class LoginModel {

	private String phone_no;
	private String email_id;
	private String password;

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginModel [phone_no=" + phone_no + ", email_id=" + email_id + ", password=" + password + "]";
	}

}
