package com.example.blog_spring_boot.services;

import org.springframework.beans.factory.annotation.Autowired;

public class BlogService implements IBlogService{

    @Autowired
    private IBlogService iBlogService;
}
