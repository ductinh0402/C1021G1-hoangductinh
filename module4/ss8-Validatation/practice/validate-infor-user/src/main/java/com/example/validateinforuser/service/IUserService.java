package com.example.validateinforuser.service;

import com.example.validateinforuser.model.User;
import com.example.validateinforuser.repository.IUserRepository;
import com.example.validateinforuser.vailidateUser.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserService {
    Page<User> findAll(Pageable pageable);


    void save(User user);
}

