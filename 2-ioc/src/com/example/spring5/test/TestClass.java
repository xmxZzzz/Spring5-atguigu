package com.example.spring5.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.spring5.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

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
public class TestClass {

    /*
     * @Method testBook
     * @Version  1.0
     * @Description 测试注入属性：一般注入、其他类型注入(null、特殊符号等)
     * @param
     * @Return void
     * @Exception
     * @Date 2021/11/23 上午1:28
     */
    @Test
    public void testBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book.getName()+"::"+book.getAuthor()+"::"+book.getVersion());
        System.out.println(book.getCreateTime()+"::"+book.getAddress());
        System.out.println(book.getArticle()+"::"+book.getBook1());
    }

    /*
     * @Method testBookCollection
     * @Version  1.0
     * @Description 测试注入集合：array、list、map、set
     * @param
     * @Return void
     * @Exception
     * @Date 2021/11/23 上午1:27
     */
    @Test
    public void testBookCollection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu);
    }

    /*
     * @Method testBookUtilNamespace
     * @Version  1.0
     * @Description 测试引用公共集合 util:list
     * @param
     * @Return void
     * @Exception
     * @Date 2021/11/23 上午1:26
     */
    @Test
    public void testBookUtilNamespace(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("course", Course.class);
        System.out.println(course);
        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println(teacher);
        System.out.println(course.getCname()==teacher.getCname());

        //测试bean的作用域：singleton
        Course course1 = context.getBean("course", Course.class);
        System.out.println(course1);
    }

    /*
     * @Method testFactoryBean
     * @Version  1.0
     * @Description 测试FactoryBean，生成指定返回类型
     * @param
     * @Return void
     * @Exception
     * @Date 2021/11/23 上午1:24
     */
    @Test
    public void testFactoryBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    /*
     * @Method testLifeCircle
     * @Version  1.0
     * @Description 测试bean的生命周期
     * @param
     * @Return void
     * @Exception
     * @Date 2021/11/23 上午1:24
     */
    @Test
    public void testLifeCircle(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println("第四步 使用bean");
        System.out.println(order);
        //手动销毁bean
        ((ClassPathXmlApplicationContext)context).close();
    }

    /*
     * @Method testAutowired
     * @Version  1.0
     * @Description 测试自动装配
     * @param
     * @Return void
     * @Exception
     * @Date 2021/11/23 上午1:41
     */
    @Test
    public void testAutowired(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    /*
     * @Method testProperties
     * @Version  1.0
     * @Description 测试druid连接池
     * @param
     * @Return void
     * @Exception
     * @Date 2021/11/23 上午2:13
     */
    @Test
    public void testProperties(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        DataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource);
    }
}
