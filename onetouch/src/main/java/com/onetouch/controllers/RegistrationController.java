package com.onetouch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onetouch.models.LoginModel;
import com.onetouch.models.RegistrationModel;
import com.onetouch.services.RegisterService;

@RestController
@RequestMapping(value="registration")
public class RegistrationController {

	@Autowired
	RegisterService registerService;
	
	@RequestMapping(value="register",method=RequestMethod.POST,consumes = { "application/json" }, produces="application/json")
	public String registerUser(@RequestBody RegistrationModel registrationModel )
	{
		System.out.println("RegistrationModel :: "+registrationModel.toString());
		String registered =registerService.registerUser(registrationModel);
		System.out.println("Registerd :: "+registered);
		return registered;
	}
	
	@RequestMapping(value="validLogin",method=RequestMethod.POST,consumes = { "application/json" }, produces="application/json")
	public RegistrationModel validLogin(@RequestBody LoginModel loginModel)
	{
		System.out.println("LoginModel :: "+loginModel.toString());
		return registerService.validateLogin(loginModel);
	}
	
	
}
