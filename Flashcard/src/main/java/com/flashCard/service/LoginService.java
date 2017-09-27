package com.flashCard.service;

import com.flashCard.model.User;

public interface LoginService {

    public User validateLogin(User user);

    public void saveLogin(User user);

    public void deleteLogin(int id);

    
}

