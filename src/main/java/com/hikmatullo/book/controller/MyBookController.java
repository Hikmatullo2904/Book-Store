package com.hikmatullo.book.controller;

import com.hikmatullo.book.entity.Book;
import com.hikmatullo.book.entity.MyBook;
import com.hikmatullo.book.service.BookService;
import com.hikmatullo.book.service.MyBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MyBookController {
    private final MyBookService myBookService;
    private final BookService bookService;

    public MyBookController(MyBookService myBookService, BookService bookService) {
        this.myBookService = myBookService;
        this.bookService = bookService;
    }

    @GetMapping("/addToMyBooks/{id}")
    public String addToMyBook(@PathVariable Long id) {
        Book byId = bookService.findById(id);
        myBookService.addToMyBook(byId);
        return "redirect:/availableBooks";
    }

    @GetMapping("/myBooks")
    public String getMyBooks(Model model) {
        List<MyBook> myBookList = myBookService.getMyBookList();
        model.addAttribute("myBooks", myBookList);
        return "myBooks";
    }

    @GetMapping("/deleteFromMyBook/{id}")
    public String deleteFromMyBook(@PathVariable Long id) {
        myBookService.deleteMyBook(id);
        return "redirect:/myBooks";
    }
}
