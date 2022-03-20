package com.example.blog_web_service.service.iplm;

import com.example.blog_web_service.model.Blog;
import com.example.blog_web_service.repository.BlogRepository;
import com.example.blog_web_service.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }
}
