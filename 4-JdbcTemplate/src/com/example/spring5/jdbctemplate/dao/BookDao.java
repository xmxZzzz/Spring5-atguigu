package com.example.spring5.jdbctemplate.dao;


import com.example.spring5.jdbctemplate.entity.Book;

import java.util.List;

public interface BookDao {
    // 添加
    void addBook(Book book);

    // 更新
    void updateBook(Book book);

    //删除
    void deleteBook(String bookId);

    //查询返回表中的条数
    int findCount();

    //查询返回表中的一条数据
    Book findBookInfo(String id);

    //查询返回表中的所有数据
    List<Book> findAllBook();
}
