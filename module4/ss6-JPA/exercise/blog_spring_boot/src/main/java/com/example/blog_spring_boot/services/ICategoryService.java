package com.example.blog_spring_boot.services;

import com.example.blog_spring_boot.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();
}
