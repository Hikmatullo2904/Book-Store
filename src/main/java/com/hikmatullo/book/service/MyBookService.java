package com.hikmatullo.book.service;

import com.hikmatullo.book.entity.Book;
import com.hikmatullo.book.entity.MyBook;
import org.apache.catalina.User;

import java.util.List;

public interface MyBookService {
    MyBook addToMyBook(Book book);
    void deleteMyBook(Long id);
    List<MyBook> getMyBookList();
}
