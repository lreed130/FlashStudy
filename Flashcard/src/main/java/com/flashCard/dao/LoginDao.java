package com.flashCard.dao;

import java.sql.Statement;

import com.flashCard.model.User;

public interface LoginDao {

	public void saveLogin(User user);
		
	public User validateLogin(User login){
		validateEmail(user);
		validateUsername(user);
	}
}
