package com.onetouch.utilities;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


public class SendMessageUtility {

	public static String sendSms(String message, String mobileNumber) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://api.msg91.com/api/v2/sendsms";
		String messageRequestData = "{ " + "\"sender\": \"SOCKET\", " + "\"route\": \"4\"," + " \"country\": \"91\", "
				+ "\"sms\": [ { " + "\"message\":\"" + message + "\"," + " \"to\": [\"" + mobileNumber + "\" ] } ] }";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("authkey", "213299A8JMuPMBXPs5ae87513");
		HttpEntity<String> entity = new HttpEntity<String>(messageRequestData, headers);
		String answer = restTemplate.postForObject(url, entity, String.class);
		System.out.println("The answer is ::" + answer);

		return answer;

	}

	/*public static void main(String args[]) {

		System.out.println(ExtractingProperty.getProperty("successfullRegistration", "", "smsMessages"));
		//sendSms(ExtractingProperty.getProperty("successfullRegistration", "", "smsMessages"), "9030141");

	}*/
}
