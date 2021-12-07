package com.example.spring5.transaction.annotation.dao;

public interface AccountDao {

    //给username加money钱
    void addMoney(String username,int money);

    //给username减money钱
    void reduceMoney(String username,int money);
}
