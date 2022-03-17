package com.example.blog_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.blog_spring_boot.repository.IBlogRepository;

@Controller
public class BlogController {

    @Autowired
    private IBlogRepository iBlogRepository;

    @GetMapping("/blog")
    public ModelAndView listBlog() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blogList", iBlogRepository.findAll());
        return modelAndView;
    }
}
