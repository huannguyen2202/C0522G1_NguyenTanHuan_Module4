package com.example_blog.controller;

import com.example_blog.model.Blogs;
import com.example_blog.service.IBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blogs")
public class ApiBlogsController {
    @Autowired
    private IBlogsService iBlogsService;

    @GetMapping
    public ResponseEntity<List<Blogs>> getBlogsList() {
        List<Blogs> blogsList = iBlogsService.findAll();
        if (blogsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blogs> findBlogById(@PathVariable int id) {
        Blogs blogs = iBlogsService.findById(id);
        if (blogs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blogs>> showName(@RequestParam(value = "") String name) {
        List<Blogs> blogsList = iBlogsService.findByTitleName(name);
        if (blogsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogsList, HttpStatus.OK);

    }

}
