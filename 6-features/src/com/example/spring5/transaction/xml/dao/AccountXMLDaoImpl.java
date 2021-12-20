package com.example.spring5.transaction.xml.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountXMLDaoImpl implements AccountXMLDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney(String username, int money) {
        String sql = "update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql, money, username);
    }

    @Override
    public void reduceMoney(String username, int money) {
        String sql = "update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql, money, username);
    }
}
