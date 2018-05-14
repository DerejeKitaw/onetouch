package com.onetouch.daoImpl;

import java.text.MessageFormat;

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
import com.onetouch.utilities.SendMessageUtility;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public RegistrationModel userProfileData(String mobileNo) {
		String updateDataQuery = ExtractingProperty.getProperty("updatedProfileData", "", "queries");
		log.info("Profile Updation Query " + updateDataQuery);
		RegistrationModel registrationModel = new RegistrationModel();
		if (mobileNo != null) {
			registrationModel = jdbcTemplate.queryForObject(updateDataQuery, new Object[] { mobileNo },
					new BeanPropertyRowMapper<RegistrationModel>(RegistrationModel.class));
			// log.info("Profile Data After Updation"+registrationModel.toString());
			registrationModel.setMessage("profileUpdatedSuccessfully");
			log.info("Profile Data After Message Updation" + registrationModel.toString());
			return registrationModel;
		} else {
			registrationModel.setMessage("NoMobileNumber");
			log.info("Profile Data After Message Updation" + registrationModel.toString());
			return registrationModel;
		}

	}

	@Override
	public RegistrationModel registerUser(RegistrationModel registrationModel) {
		// TODO Auto-generated method stub
		String registerUserQuery = ExtractingProperty.getProperty("register", "", "queries");
		log.info("registerUserQuery :: " + registerUserQuery);
		System.out.println("registerUserQuery :: " + registerUserQuery);
		log.info("password encryotion ::" + RegisterUtility.encrypt(registrationModel.getPassword()));
		System.out.println("password encryotion ::" + RegisterUtility.encrypt(registrationModel.getPassword()));
		/*
		 * int inserted = jdbcTemplate.update(registerUserQuery, new Object[] {
		 * registrationModel.getFirst_name(), registrationModel.getLast_name(),
		 * registrationModel.getDob(), registrationModel.getPhone_no(),
		 * registrationModel.getEmail_id(), registrationModel.getRole(),
		 * registrationModel.getProfile_pic(),
		 * RegisterUtility.encrypt(registrationModel.getPassword()) });
		 */

		int inserted = jdbcTemplate.update(registerUserQuery,
				new Object[] { registrationModel.getFirst_name(), registrationModel.getLast_name(),
						registrationModel.getPhone_no(), registrationModel.getEmail_id(), registrationModel.getRole(),
						RegisterUtility.encrypt(registrationModel.getPassword()), registrationModel.getStatus() });
		String smsResponse = "";

		if (inserted == 1) {
			smsResponse = SendMessageUtility.sendSms(
					ExtractingProperty.getProperty("successfullRegistration", "", "smsMessages"),
					registrationModel.getPhone_no());
			log.info("SMS Repsonse " + smsResponse);

			registrationModel.setMessage("successfullyRegistered");
			log.info("After Registration Status " + registrationModel.toString());
			return registrationModel;
		} else {
			log.info("SMS Repsonse " + smsResponse);
			registrationModel.setMessage("failed");
			log.info("After Registration Status " + registrationModel.toString());
			return registrationModel;
		}

	}

	@Override
	public RegistrationModel validateLogin(LoginModel loginModel) {
		// TODO Auto-generated method stub
		String loginQuery = ExtractingProperty.getProperty("validLogin", "", "queries");
		log.info("loginQuery :: " + loginQuery);
		System.out.println("loginQuery :: " + loginQuery);
		log.info("password encryption ::" + RegisterUtility.encrypt(loginModel.getPassword()));
		System.out.println("password encryotion ::" + RegisterUtility.encrypt(loginModel.getPassword()));
		RegistrationModel registrationModel = jdbcTemplate.queryForObject(loginQuery,
				new Object[] { loginModel.getEmail_id(), loginModel.getPhone_no(),
						RegisterUtility.encrypt(loginModel.getPassword()) },
				new BeanPropertyRowMapper<RegistrationModel>(RegistrationModel.class));
		System.out.println("extracted user info ::" + registrationModel.toString());
		log.info("extracted user info ::" + registrationModel.toString());
		return registrationModel;
	}

	@Override
	public RegistrationModel updateProfile(RegistrationModel registrationModel) {
		// TODO Auto-generated method stub
		String updateFields = "";
		log.info("registrationModel" + registrationModel.toString());
		if (registrationModel.getFirst_name() != null && registrationModel.getFirst_name() != "") {
			updateFields += "first_name = '" + registrationModel.getFirst_name() + "',";
		}
		if (registrationModel.getLast_name() != null && registrationModel.getLast_name() != "") {
			updateFields += "last_name = '" + registrationModel.getLast_name() + "',";
		}
		if (registrationModel.getDob() != null && registrationModel.getDob() != "") {
			updateFields += "dob = '" + registrationModel.getDob() + "',";
		}
		if (registrationModel.getPhone_no() != null && registrationModel.getPhone_no() != "") {
			updateFields += "phone_no = '" + registrationModel.getPhone_no() + "',";
		}
		if (registrationModel.getEmail_id() != null && registrationModel.getEmail_id() != "") {
			updateFields += "email_id = '" + registrationModel.getEmail_id() + "',";
		}
		if (registrationModel.getProfile_pic() != null && registrationModel.getProfile_pic() != "") {
			updateFields += "profile_pic = '" + registrationModel.getProfile_pic() + "',";
		}
		log.info("updateFields :: " + updateFields);

		String updateProfileQuery = MessageFormat.format(ExtractingProperty.getProperty("updateProfile", "", "queries"),
				updateFields.substring(0, updateFields.lastIndexOf(",")), registrationModel.getPhone_no());
		log.info("updateProfileQuery :: " + updateProfileQuery);
		int updated = jdbcTemplate.update(updateProfileQuery);
		log.info("Profile Updated " + updated);
		String smsResponse = "";
		if (updated == 1) {
			smsResponse = SendMessageUtility.sendSms(
					ExtractingProperty.getProperty("updatedProfile", "", "smsMessages"),
					registrationModel.getPhone_no());
			log.info("SMS Repsonse " + smsResponse);
		} else {
			log.info("SMS Repsonse " + smsResponse);
		}
		return userProfileData(registrationModel.getPhone_no());

	}

	@Override
	public String forgotPassword(String phone_no) {
		// TODO Auto-generated method stub
		String forgotPasswordQuery = ExtractingProperty.getProperty("forgotPassword", "", "queries");
		log.info("loginQuery :: " + forgotPasswordQuery);
		String encPassword = jdbcTemplate.queryForObject(forgotPasswordQuery, new Object[] { phone_no }, String.class);
		log.info("Encrypted Password :: " + encPassword);
		String smsResponse = "";
		if (encPassword != "" || encPassword.length() != 0) {
			log.info("Decrypted Password :: " + RegisterUtility.decrypt(encPassword));
			smsResponse = SendMessageUtility.sendSms(MessageFormat.format(
					ExtractingProperty.getProperty("forgotPassword", "", "smsMessages"), RegisterUtility.decrypt(encPassword)), phone_no);
			return "passwordSent";
		} else {
			smsResponse = "";
			return "wrongNumber";
		}

	}

}
