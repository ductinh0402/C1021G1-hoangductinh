package com.example.blog_web_service.service.iplm;

import com.example.blog_web_service.model.Category;
import com.example.blog_web_service.repository.BlogRepository;
import com.example.blog_web_service.repository.CategoryRepository;
import com.example.blog_web_service.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
