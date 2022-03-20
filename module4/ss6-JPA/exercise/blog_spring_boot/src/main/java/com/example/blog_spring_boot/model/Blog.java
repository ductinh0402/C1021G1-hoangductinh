package com.example.blog_spring_boot.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(columnDefinition = "longtext")
    private String content;
    private String description;

    @ManyToOne
    @JoinColumn(name = "blog_id", referencedColumnName = "id")
    private Category categories;
    private Date date;

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public Blog() {
    }

    public Blog(int id, String name, String content, String description, Category categories, Date date) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.description = description;
        this.categories = categories;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
