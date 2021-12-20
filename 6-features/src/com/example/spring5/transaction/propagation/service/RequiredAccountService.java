package com.example.spring5.transaction.propagation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequiredAccountService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addMoney() {
        String sql = "update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql, 100, "mary");
    }

    /*
     * @Method reduceMoney
     * @Version  1.0
     * @Description 如果调用方法有事务则加入事务中，无事务新建事务
     * @Date 2021/12/8 上午2:25
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void reduceMoney() {
        String sql = "update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql, 100, "lucy");
        throw new RuntimeException("测试异常");
    }

    /*
     * @Method reduceMoney1
     * @Version  1.0
     * @Description 如果调用方法有事务则加入事务中，如果没有则什么都不做，相当于没事务
     * @Date 2021/12/8 上午2:22
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public void reduceMoney1() {
        String sql = "update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql, 100, "lucy");
        throw new RuntimeException("测试异常");
    }

    /*
     * @Method reduceMoney2
     * @Version  1.0
     * @Description 无论调用方法有无事务，该方法都处于无事务
     * @Return void
     * @Date 2021/12/8 上午2:39
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void reduceMoney2() {
        String sql = "update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql, 100, "lucy");
        throw new RuntimeException("测试异常");
    }

    /*
     * @Method reduceMoney3
     * @Version  1.0
     * @Description
     *  1、若调用方法有事务，
     *      （1）其内部所有方法无异常，则支持提交和回滚；
     *      （2）当前方法出现异常，只回滚当前方法
     *      （3）调用方法中的其他方法出现异常，则所有方法一起回滚
     *  2、若调用方法无事务，则当前方法创建一个新事务，与调用方法中的其它方法无关
     * @Return void
     * @Date 2021/12/8 上午3:38
     */
    @Transactional(propagation = Propagation.NESTED)
    public void reduceMoney3() {
        String sql = "update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql, 100, "lucy");
        throw new RuntimeException("测试异常reduceMoney0");
    }

    public void reduceMoney0() {
        String sql = "update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql, 100, "tom");
//        throw new RuntimeException("测试异常reduceMoney0");
    }

    public void addMoney0() {
        String sql = "update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql, 100, "jerry");
        throw new RuntimeException("测试异常addMoney0");
    }

    /*
     * @Method addMoney1
     * @Version  1.0
     * @Description 如果调用方法有事务，则加入事务中；如果调用方法无事务，则抛出异常
     *  IllegalTransactionStateException: No existing com.example.spring5.transaction found for com.example.spring5.transaction marked with propagation 'mandatory'
     * @Return void
     * @Date 2021/12/8 上午2:47
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void addMoney1() {
        String sql = "update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql, 100, "mary");
    }

    /*
     * @Method addMoney2
     * @Version  1.0
     * @Description 如果调用方法无事务，则正常执行；如果调用方法有事务，则抛出异常
     *  IllegalTransactionStateException: Existing com.example.spring5.transaction found for com.example.spring5.transaction marked with propagation 'never'
     * @Return void
     * @Date 2021/12/8 上午2:59
     */
    @Transactional(propagation = Propagation.NEVER)
    public void addMoney2() {
        String sql = "update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql, 100, "mary");
        throw new RuntimeException("测试异常");
    }

    /*
     * @Method addMoney3
     * @Version  1.0
     * @Description 无法调用方法有无事务，该方法都执行在自己的事务中，提交和回滚也在自己的事务中完成，与调用方法的事务无关。
     * @Return void
     * @Date 2021/12/8 上午3:22
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addMoney3() {
//        String sql = "update t_account set money=money+? where username=?";
//        jdbcTemplate.update(sql, 100, "mary");
        throw new RuntimeException("测试异常");
    }
}
