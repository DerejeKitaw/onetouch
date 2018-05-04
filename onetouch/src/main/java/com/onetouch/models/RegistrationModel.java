package com.onetouch.models;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * This is the Enity for Registration 
 * Table : ot_registration
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationModel {

	private String first_name;
	private String last_name;
	private String phone_no;
	private String email_id;
	private String role;
	private String password;
	private int status;
	private String dob;
	private String profile_pic;
	private String message;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getProfile_pic() {
		return profile_pic;
	}
	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "RegistrationModel [first_name=" + first_name + ", last_name=" + last_name + ", phone_no=" + phone_no
				+ ", email_id=" + email_id + ", role=" + role + ", password=" + password + ", status=" + status
				+ ", dob=" + dob + ", profile_pic=" + profile_pic + ", message=" + message + "]";
	}

	

}
