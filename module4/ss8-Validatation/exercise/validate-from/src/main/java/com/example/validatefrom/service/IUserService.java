package com.example.validatefrom.service;

import com.example.validatefrom.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {


    Page<User> findAll(Pageable pageable);

    void save(User user);
}
