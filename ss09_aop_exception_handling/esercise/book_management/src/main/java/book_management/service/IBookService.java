package book_management.service;

import book_management.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(int id);

    void update(Book book);


}
