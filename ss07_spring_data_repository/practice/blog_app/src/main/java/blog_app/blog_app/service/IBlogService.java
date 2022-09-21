package blog_app.blog_app.service;

import blog_app.blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);

    Page<Blog> finByName(String name, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);
}
