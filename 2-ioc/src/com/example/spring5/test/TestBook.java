package com.example.spring5.test;

import com.example.spring5.bean.Book;
import com.example.spring5.bean.Course;
import com.example.spring5.bean.Stu;
import com.example.spring5.bean.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: spring5-code
 * @Package: spring5.test
 * @ClassName: TestBook
 * @Author: guoyy
 * @Description:
 * @Date: 2021/8/30 上午12:45
 * @UpdateDate: 2021/8/30 上午12:45
 * @Version: 1.0
 */
public class TestBook {

    @Test
    public void testBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book.getName()+"::"+book.getAuthor()+"::"+book.getVersion());
        System.out.println(book.getCreateTime()+"::"+book.getAddress());
        System.out.println(book.getArticle()+"::"+book.getBook1());
    }

    @Test
    public void testBookCollection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu);
    }

    @Test
    public void testBookUtilNamespace(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("course", Course.class);
        System.out.println(course);
        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println(teacher);
        System.out.println(course.getCname()==teacher.getCname());
    }
}
