package com.example.blog_spring_boot.services;

import com.example.blog_spring_boot.model.Category;
import com.example.blog_spring_boot.repository.IBlogRepository;
import com.example.blog_spring_boot.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }
}
