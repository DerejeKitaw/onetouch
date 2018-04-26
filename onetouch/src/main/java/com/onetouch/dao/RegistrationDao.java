package com.onetouch.dao;



import com.onetouch.models.LoginModel;
import com.onetouch.models.RegistrationModel;

public interface RegistrationDao {

	public String registerUser(RegistrationModel registrationModel);
	public RegistrationModel validateLogin(LoginModel loginModel);
}
