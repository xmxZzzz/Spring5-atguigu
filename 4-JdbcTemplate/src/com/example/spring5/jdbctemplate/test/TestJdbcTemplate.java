package com.example.spring5.jdbctemplate.test;

import com.example.spring5.jdbctemplate.entity.Book;
import com.example.spring5.jdbctemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.example.spring5.jdbctemplate.test
 * @ClassName: TestJdbcTemplate
 * @Author: guoyy
 * @Description: 测试JdbcTemplate
 * @Date: 2021/11/26 上午2:30
 * @Version: 1.0
*/
public class TestJdbcTemplate {

    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        // 测试添加操作
//        bookService.addBook(new Book("1", "java","on"));

        //测试更新操作
//        bookService.updateBook(new Book("1", "Java", "off"));

        //测试删除操作
//        bookService.deleteBook("1");

        //测试查询返回某个值：表中数据记录数
//        int count = bookService.findCount();
//        System.out.println(count);

        //测试查询返回某个对象：Book
//        Book book = bookService.findOne("1");
//        System.out.println(book);

        //测试查询返回某个对象：Book
        List<Book> books = bookService.findAll();
        System.out.println(books.toString());
    }

    @Test
    public void testBatch(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        //批量插入
//        Object[] o1={"3","c++","a"};
//        Object[] o2={"4","c#","b"};
//        Object[] o3={"5","mysql","c"};
//        bookService.batchAdd(Arrays.asList(o1,o2,o3));

        //批量更新
//        Object[] o1={"C++","aa","3"};
//        Object[] o2={"C#","bb","4"};
//        Object[] o3={"MySQL","cc","5"};
//        bookService.batchUpdate(Arrays.asList(o1,o2,o3));

        //批量删除
        Object[] o1={"3"};
        Object[] o2={"4"};
        bookService.batchDelete(Arrays.asList(o1,o2));
    }
}
