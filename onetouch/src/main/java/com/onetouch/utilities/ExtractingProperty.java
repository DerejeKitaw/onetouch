package com.onetouch.utilities;

import java.util.ResourceBundle;

import org.springframework.util.StringUtils;

public class ExtractingProperty {

	

	public static String getProperty(String key, String defaultValue,String propertyFileName) {
		// System.out.println("The get Key is "+resourceBundle.getString(key));
		 ResourceBundle resourceBundle = ResourceBundle.getBundle(propertyFileName);
		if (null == resourceBundle) {
			// LOG.info(&quot;resourceBundle Value is Null&quot;);
			return null;
		}
		if (StringUtils.isEmpty(resourceBundle.getString(key))) {
			return defaultValue;
		} else {

			return resourceBundle.getString(key);
		}
	}

	/*public static void main(String args[]) {
		String value = getProperty("validLogin", "","");
		System.out.println("value :: " + value);
		
		 * String url=MessageFormat.format(value, "D:\\nasim\\media\\test.jpg","50%");
		 * System.out.println("url :: "+url);
		 

	}*/
}
