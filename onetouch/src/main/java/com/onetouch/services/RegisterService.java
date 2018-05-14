package com.onetouch.services;


import com.onetouch.models.LoginModel;
import com.onetouch.models.RegistrationModel;


public interface RegisterService {

	public RegistrationModel registerUser(RegistrationModel registrationModel);
	public RegistrationModel validateLogin(LoginModel loginModel);
	public RegistrationModel updateProfile(RegistrationModel registrationModel);
	public String forgotPassword(String phone_no);
}
