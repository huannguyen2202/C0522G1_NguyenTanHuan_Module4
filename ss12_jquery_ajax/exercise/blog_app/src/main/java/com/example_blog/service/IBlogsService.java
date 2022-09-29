package com.example_blog.service;


import com.example_blog.dto.IBlogDto;
import com.example_blog.model.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogsService {

    List<Blogs> findAll();

    void save(Blogs blogs);

    Blogs findById(int id);


    void update(Blogs blogs);

    void remove(int id);

    Page<Blogs> findAll(Pageable pageable);

    Page<Blogs> findByTitleName(String name, Pageable pageable);

    List<IBlogDto> showList();

    List<Blogs> findByTitleName(String name);


}
