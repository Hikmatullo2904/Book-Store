package com.hikmatullo.book.controller;

import com.hikmatullo.book.entity.Book;
import com.hikmatullo.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/registerBook")
    public String getRegisterBook(@ModelAttribute("book") Book book) {
        return "bookRegister";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        bookService.save(book);
        model.addAttribute("message", "registered successfully");
        return "bookRegister";
    }

    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "bookEdit";
    }
    @PostMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Long id,  @ModelAttribute("book") Book book, Model model) {
        bookService.editBook(book, id);
        model.addAttribute("message", "updated successfully");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/availableBooks";
    }

    @GetMapping("/availableBooks")
    public String getAvailableBook(Model model) {
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);
        return "bookList";
    }

    @GetMapping("/deleteBook/{id}")
    public String deletebook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/availableBooks";
    }

}
