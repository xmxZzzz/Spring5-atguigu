package com.example.spring5.jdbctemplate.dao;

import com.example.spring5.jdbctemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addBook(Book book) {
        String sql="insert into t_book values(?,?,?)";
        Object[] obj = {book.getBookId(),book.getBookName(),book.getBookStatus()};
        int update = jdbcTemplate.update(sql, obj);
        System.out.println(update);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set book_name=?,book_status=? where book_id=?";
        Object[] obj = {book.getBookName(),book.getBookStatus(),book.getBookId()};
        int update = jdbcTemplate.update(sql, obj);
        System.out.println(update);
    }

    @Override
    public void deleteBook(String bookId) {
        String sql = "delete from t_book where book_id=?";
        int update = jdbcTemplate.update(sql, bookId);
        System.out.println(update);
    }

    @Override
    public int findCount() {
        String sql = "select count(1) from t_book";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from t_book where book_id=?";
        // RowMapper是一个接口，返回不同的类型数据，使用这个接口里的实现类完成数据的封装
        // BeanPropertyRowMapper就是RowMapper的一个实现类
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> findAllBook() {
        String sql = "select * from t_book";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }
}
