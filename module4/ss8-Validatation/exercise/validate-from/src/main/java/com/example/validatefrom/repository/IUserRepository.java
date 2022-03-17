package com.example.validatefrom.repository;

import com.example.validatefrom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
