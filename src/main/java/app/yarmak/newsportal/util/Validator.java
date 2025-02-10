package app.yarmak.newsportal.util;

import java.util.regex.Pattern;

public class Validator {
	
	public static boolean isNullOrEmpty(String value) {
		return value==null || value.trim().isEmpty();
	}
	
	public static boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"; 
		Pattern pattern = Pattern.compile(emailRegex); 
		
		return pattern.matcher(email).matches();
	}
	
	public static boolean arePasswordMatching(String password, String confirmPassword) {
	    return password != null && confirmPassword != null
	           && password.trim().equals(confirmPassword.trim());
	}

	
	public static boolean isValidId(String id) {
		try {
			Integer.parseInt(id);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

}
