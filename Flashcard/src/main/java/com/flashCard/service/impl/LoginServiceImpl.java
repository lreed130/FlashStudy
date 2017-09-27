package com.flashCard.service.impl;

import org.springframework.stereotype.Service;

import com.flashCard.model.User;
import com.flashCard.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    public User validateLogin(User login) {
        User user = new User();
       

        return user;
    }

    public void saveLogin(User user) {

    }

    public void deleteLogin(int id) {

    }

}
