package com.onetouch.services;


import com.onetouch.models.LoginModel;
import com.onetouch.models.RegistrationModel;


public interface RegisterService {

	public RegistrationModel registerUser(RegistrationModel registrationModel);
	public RegistrationModel validateLogin(LoginModel loginModel);
	public String updateProfile(RegistrationModel registrationModel);
}
