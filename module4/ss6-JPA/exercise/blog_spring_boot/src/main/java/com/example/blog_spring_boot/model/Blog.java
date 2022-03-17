package com.example.blog_spring_boot.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name;
    private String content;
    private String description;
    private LocalDate date;

    public Blog() {
    }

    public Blog(int id, String name, String content, String description, LocalDate date) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
