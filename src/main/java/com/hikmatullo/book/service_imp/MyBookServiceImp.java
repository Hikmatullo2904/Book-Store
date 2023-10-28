package com.hikmatullo.book.service_imp;

import com.hikmatullo.book.entity.Book;
import com.hikmatullo.book.entity.MyBook;
import com.hikmatullo.book.repository.MyBookRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import com.hikmatullo.book.service.MyBookService;
@Service
public class MyBookServiceImp implements MyBookService {

    private final MyBookRepository myBookRepository;

    public MyBookServiceImp(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }

    @Override
    public MyBook addToMyBook(Book book) {
        MyBook myBook = new MyBook();
        myBook.setAuthor(book.getAuthor());
        myBook.setTitle(book.getTitle());
        myBook.setPrice(book.getPrice());
        return myBookRepository.save(myBook);
    }

    @Override
    public void deleteMyBook(Long id) {
        myBookRepository.deleteById(id);
    }


    @Override
    public List<MyBook> getMyBookList() {
        return myBookRepository.findAll();
    }
}
