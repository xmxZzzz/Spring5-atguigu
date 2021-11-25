package com.example.spring5.jdbctemplate.service;

import com.example.spring5.jdbctemplate.dao.BookDao;
import com.example.spring5.jdbctemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBook(Book book){
        bookDao.addBook(book);
    }

    public void updateBook(Book book){
        bookDao.updateBook(book);
    }

    public void deleteBook(String bookId){
        bookDao.deleteBook(bookId);
    }

    public int findCount(){
        return bookDao.findCount();
    }

    public Book findOne(String id){
        return bookDao.findBookInfo(id);
    }

    public List<Book> findAll(){
        return bookDao.findAllBook();
    }
}
