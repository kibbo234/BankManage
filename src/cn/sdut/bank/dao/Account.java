package cn.sdut.bank.dao;


import java.lang.String;

/**
 * 用户帐号模型,用于用户之间传递账户信息
 */

public class Account {

    public String account;
    public String name;
    public String password;
    public int power;
    public boolean exist;


    public Account(){

    }

    public Account (String account){
        this.account = account;
        this.password = null;
        this.name = null;
        this.power = 0;
        this.exist = false;
    }

    public Account(String account, String password){
        this.account = account;
        this.password = password;
        this.name = null;
        this.power = 0;
        this.exist = false;
    }

    public Account(String account, String name, String password){
        this.account = account;
        this.name = name;
        this.password = password;
        this.power = 0;
        this.exist = false;
    }

    Account(String account, String name, String password, int power){
        this.account = account;
        this.name = name;
        this.password = password;
        this.power = power;
        this.exist = false;
    }

    Account(String account, String name, String password, int power, boolean exist){
        this.account = account;
        this.name = name;
        this.password = password;
        this.power = power;
        this.exist = exist;
    }

    public void getData(){
        System.out.println(this.account);
        System.out.println(this.name);
        System.out.println(this.password);
        System.out.println(this.power);
        System.out.println(this.exist);
    }



}
