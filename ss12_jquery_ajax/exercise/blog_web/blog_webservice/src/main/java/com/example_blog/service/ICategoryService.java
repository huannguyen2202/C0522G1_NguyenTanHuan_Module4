package com.example_blog.service;

import com.example_blog.model.Blogs;
import com.example_blog.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    void save(Category category);

    Category findById(int id);


    void update(Category category);

    void remove(int id);
}
