package com.hikmatullo.book.service;

import com.hikmatullo.book.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book);
    Book findById(Long id);
    List<Book> getAllBooks();
    void editBook(Book book, Long id);
    void deleteBook(Long id);
}
