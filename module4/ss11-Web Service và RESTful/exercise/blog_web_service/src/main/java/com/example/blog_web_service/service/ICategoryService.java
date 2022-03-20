package com.example.blog_web_service.service;

import com.example.blog_web_service.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
