package cn.sdut.bank.dao;

import java.sql.Statement;

public class persMage {
    private String account;
    private String name;
    private String password;
    private int power;

    persMage(String account){
        this.account = account;
        this.password = null;
        this.name = null;
        this.power = 0;
    }

    persMage(String account , String password){
        this.account = account;
        this.password = password;
        this.name = null;
        this.power = 0;
    }

    persMage(String account, String name, String password){
        this.account = account;
        this.name = name;
        this.password = password;
        this.power = 0;
    }

    persMage(String account, String name, String password, int power){
        this.account = account;
        this.name = name;
        this.password = password;
        this.power = power;
    }


}
