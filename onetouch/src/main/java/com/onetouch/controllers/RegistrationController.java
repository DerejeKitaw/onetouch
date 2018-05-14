package com.onetouch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onetouch.models.LoginModel;
import com.onetouch.models.RegistrationModel;
import com.onetouch.services.RegisterService;

import lombok.extern.slf4j.Slf4j;




@RestController
@RequestMapping(value="registration")
@Slf4j
public class RegistrationController {

	@Autowired
	RegisterService registerService;
	
	//@CrossOrigin(origins = "http://172.17.12.95:8080",maxAge = 3600)
	@RequestMapping(value="register",method=RequestMethod.POST,consumes = { "application/json" }, produces="application/json")
	public RegistrationModel registerUser(@RequestBody RegistrationModel registrationModel )
	{
		log.info("Inside Registration Controller");
		log.info("RegistrationModel :: "+registrationModel.toString());
		return registerService.registerUser(registrationModel);
	}
	
	@RequestMapping(value="validLogin",method=RequestMethod.POST,consumes = { "application/json" }, produces="application/json")
	public RegistrationModel validLogin(@RequestBody LoginModel loginModel)
	{
		log.info("LoginModel :: "+loginModel.toString());
		return registerService.validateLogin(loginModel);
	}
	

	@RequestMapping(value="updateProfile",method=RequestMethod.POST,consumes = { "application/json" }, produces="application/json")
	public RegistrationModel updateProfile(@RequestBody RegistrationModel registrationModel)
	{
		log.info("updateProfile :: "+registrationModel.toString());
		return registerService.updateProfile(registrationModel);
	}
	
	@RequestMapping(value="forgotPassword",method=RequestMethod.POST)
	public String forgotPassword(@RequestParam("mobileNo") String phone_no)
	{
		log.info("forgotPassword :: "+phone_no);
		return registerService.forgotPassword(phone_no);
	}
}
