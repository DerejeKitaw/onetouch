package com.onetouch.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetouch.dao.RegistrationDao;
import com.onetouch.models.LoginModel;
import com.onetouch.models.RegistrationModel;
import com.onetouch.services.RegisterService;

@Service
public class RegistrationServiceImpl implements RegisterService {

	@Autowired
	RegistrationDao registrationDao;

	@Override
	public RegistrationModel registerUser(RegistrationModel registrationModel) {
		// TODO Auto-generated method stub
		return registrationDao.registerUser(registrationModel);
	}

	@Override
	public RegistrationModel validateLogin(LoginModel loginModel) {
		// TODO Auto-generated method stub
		return registrationDao.validateLogin(loginModel);
	}

	@Override
	public String updateProfile(RegistrationModel registrationModel) {
		// TODO Auto-generated method stub
		return registrationDao.updateProfile(registrationModel);
	}

}
