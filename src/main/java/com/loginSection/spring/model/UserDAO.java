package com.loginSection.spring.model;

public interface UserDAO {
	public String saveUser(User user);
	
	public boolean verifyUser(User user);
}
