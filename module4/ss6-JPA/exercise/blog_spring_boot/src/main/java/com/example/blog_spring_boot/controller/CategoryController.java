package com.example.blog_spring_boot.controller;

import com.example.blog_spring_boot.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;


}
