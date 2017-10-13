package com.jxsd.zdq;

public class PasswordUtils {
	@UseCase(id = "40",description = "Passwords must contain at least one numeric")
	public boolean validatePassword(String password) {
		return password.matches("\\w*\\d\\w*");
	}
	@UseCase(id = "41")
	public String encryptPassword(String password) {
		return new StringBuilder(password).reverse().toString();
	}
}
