package com.service;

import com.model.User;
import com.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository repository;
    @Override
    public void save(User user) {
        repository.save(user);
    }
}
