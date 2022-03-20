package com.example.blog_spring_boot.repository;

import com.example.blog_spring_boot.model.Blog;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
//    @Query(value = "select * from blog where name=:keyword", nativeQuery = true)
//    Page<Blog> searchByName(@Param("keyword") String keyword, Pageable pageable);
    Page<Blog> findByNameContaining(String name,Pageable pageable);
}
