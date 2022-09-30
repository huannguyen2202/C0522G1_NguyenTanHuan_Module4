package com.example_blog.service.impl;

import com.example_blog.model.Blogs;
import com.example_blog.model.Category;
import com.example_blog.repository.ICategoryRepository;
import com.example_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatrgoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public void update(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void remove(int id) {
        iCategoryRepository.delete(findById(id));
    }
}
