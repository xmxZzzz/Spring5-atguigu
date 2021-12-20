package com.example.spring5.transaction.xml.entity;

public class Account {
    private String id;
    private String username;
    private int money;

    public Account() {
    }

    public Account(String id, String username, int money) {
        this.id = id;
        this.username = username;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", money=" + money +
                '}';
    }
}
