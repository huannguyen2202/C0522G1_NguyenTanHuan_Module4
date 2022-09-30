package com.example_blog.repository;

import com.example_blog.model.Blogs;
import com.example_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    Category findById(int id);
}
