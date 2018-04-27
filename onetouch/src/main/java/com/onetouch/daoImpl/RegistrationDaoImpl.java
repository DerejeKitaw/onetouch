package com.onetouch.daoImpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.onetouch.dao.RegistrationDao;
import com.onetouch.models.LoginModel;
import com.onetouch.models.RegistrationModel;
import com.onetouch.utilities.ExtractingProperty;
import com.onetouch.utilities.RegisterUtility;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String registerUser(RegistrationModel registrationModel) {
		// TODO Auto-generated method stub
		String registerUserQuery = ExtractingProperty.getProperty("register", "");
		log.info("registerUserQuery :: " + registerUserQuery);
		System.out.println("registerUserQuery :: " + registerUserQuery);
		log.info("password encryotion ::" + RegisterUtility.encrypt(registrationModel.getPassword()));
		System.out.println("password encryotion ::" + RegisterUtility.encrypt(registrationModel.getPassword()));
		int inserted = jdbcTemplate.update(registerUserQuery,
				new Object[] { registrationModel.getFirst_name(), registrationModel.getLast_name(),
						registrationModel.getDob(), registrationModel.getPhone_no(), registrationModel.getEmail_id(),
						registrationModel.getRole(), registrationModel.getProfile_pic(),
						RegisterUtility.encrypt(registrationModel.getPassword()) });
		return "" + inserted;
	}

	@Override
	public RegistrationModel validateLogin(LoginModel loginModel) {
		// TODO Auto-generated method stub
		String loginQuery = ExtractingProperty.getProperty("validLogin", "");
		log.info("loginQuery :: " + loginQuery);
		System.out.println("loginQuery :: " + loginQuery);
		log.info("password encryotion ::" + RegisterUtility.encrypt(loginModel.getPassword()));
		System.out.println("password encryotion ::" + RegisterUtility.encrypt(loginModel.getPassword()));
		RegistrationModel registrationModel = jdbcTemplate.queryForObject(loginQuery,
				new Object[] { loginModel.getEmail_id(), loginModel.getPhone_no(),
						RegisterUtility.encrypt(loginModel.getPassword()) },
				new BeanPropertyRowMapper<RegistrationModel>(RegistrationModel.class));
		System.out.println("extracted user info ::" + registrationModel.toString());
		log.info("extracted user info ::" + registrationModel.toString());
		return registrationModel;
	}

}
