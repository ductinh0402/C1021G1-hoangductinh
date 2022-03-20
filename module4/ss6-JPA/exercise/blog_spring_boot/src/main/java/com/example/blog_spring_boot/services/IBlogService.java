package com.example.blog_spring_boot.services;

import com.example.blog_spring_boot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    void deleteById(Integer id);


    Optional<Blog> findById(Integer id);

    Page<Blog> search(String name, Pageable pageable);
}
