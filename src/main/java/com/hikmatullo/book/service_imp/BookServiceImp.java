package com.hikmatullo.book.service_imp;

import com.hikmatullo.book.entity.Book;
import com.hikmatullo.book.repository.BookRepository;
import com.hikmatullo.book.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void editBook(Book book, Long id) {
        Book oldBook = bookRepository.findById(id).get();
        oldBook.setId(id);
        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setPrice(book.getPrice());
        bookRepository.save(oldBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
