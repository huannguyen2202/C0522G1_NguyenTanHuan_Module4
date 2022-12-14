package blog_app.blog_app.service;

import blog_app.blog_app.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(int id);

    void update(Category category);

    void remove(int id);
}
