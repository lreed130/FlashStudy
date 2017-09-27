package com.flashCard.dao;

import com.flashCard.model.User;

public interface LoginDao {

	public void saveLogin(User user);
	public User validateLogin(User login);
}
