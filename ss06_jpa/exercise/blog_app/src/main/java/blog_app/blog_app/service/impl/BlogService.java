package blog_app.blog_app.service.impl;

import blog_app.blog_app.model.Blog;
import blog_app.blog_app.repository.IBlogRepository;
import blog_app.blog_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.delete(findById(id));
    }

    @Override
    public List<Blog> finByName(String name) {
        return iBlogRepository.searchByName(name);
    }


}
