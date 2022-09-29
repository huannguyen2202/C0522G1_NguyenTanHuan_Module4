package com.example_blog.dto;

import com.example_blog.model.Blogs;

import java.util.Set;

public class CategoryDto {
    private int id;
    private String nameCategory;
    private Set<Blogs> blogs;

    public CategoryDto() {
    }

    public CategoryDto(int id, String nameCategory, Set<Blogs> blogs) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.blogs = blogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Set<Blogs> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blogs> blogs) {
        this.blogs = blogs;
    }
}
