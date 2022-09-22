package com.codegym.service;

import com.codegym.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);

    void delete(Integer id);

}
