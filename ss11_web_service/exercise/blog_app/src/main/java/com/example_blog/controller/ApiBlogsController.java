package com.example_blog.controller;

import com.example_blog.dto.BlogsDto;
import com.example_blog.model.Blogs;
import com.example_blog.model.Category;
import com.example_blog.service.IBlogsService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class ApiBlogsController {
    @Autowired
    private IBlogsService iBlogsService;
    @GetMapping
    public ResponseEntity<List<Blogs>> getBlogsList(){
        List<Blogs> blogsList = iBlogsService.findAll();
        if (blogsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogsList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Blogs>> findBlogsById(@PathVariable int id) {
        Blogs blogs = iBlogsService.findById(id);
        if (blogs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
