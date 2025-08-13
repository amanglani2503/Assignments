package com.hcl.exception;

public class UserAlreadyExists extends RuntimeException {

	public UserAlreadyExists(String email) {
		super("User with this email " + email + " already exists");
	}
}