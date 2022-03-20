package com.example.springsecurity.service;



import com.example.springsecurity.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
//    void save(User user);
//    void update(User user);
    User findById(int id);
}
