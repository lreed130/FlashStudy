package com.flashCard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashCard.dao.LoginDao;
import com.flashCard.model.User;
import com.flashCard.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

    public User validateLogin(User login) {
        User user = loginDao.validateLogin(login);

        return user;
    }

    public void saveLogin(User user) {
    	loginDao.saveLogin(user);
    }

    public void deleteLogin(int id) {

    }

}
