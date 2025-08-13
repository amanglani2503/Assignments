package com.hcl.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(Long id) {
		super("User with this "+ id +" doesn't exist"); 
	}
}