package blog_app.blog_app.service;

import blog_app.blog_app.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);

    List<Blog> finByName(String name);

}
