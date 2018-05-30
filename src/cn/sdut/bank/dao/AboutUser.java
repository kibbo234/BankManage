package cn.sdut.bank.dao;

import cn.sdut.bank.tools.StrMoney;
import cn.sdut.bank.tools.StrUserId;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AboutUser {

    public static boolean isExist(Account user) throws SQLException {

        ResultSet rest;
        linkDatabase con = new linkDatabase();
        StrUserId cc = new StrUserId();
        String str = cc.SearchInformation(user);
        rest = con.gerResult(str);
        System.out.println(rest);
        return rest.next();

    }

    public static Account getAccount(Account user) throws SQLException {
        ResultSet rest;
        linkDatabase con = new linkDatabase();
        StrUserId cc = new StrUserId();
        String str = cc.SearchInformation(user);
        rest = con.gerResult(str);
        rest.next();
        String account = rest.getString(2);
        String name = rest.getNString(3);
        String password = rest.getNString(4);
        int power = rest.getInt(6);
        boolean exit = rest.getBoolean(7);
        user = new Account(account,name,password,power,exit);
        user.getData();
        return user;
    }

    public static boolean Register(Account user) throws SQLException {
        linkDatabase con = new linkDatabase();
        StrUserId cc = new StrUserId();
        String str = cc.InsertData(user);
        con.getInsert(str);
        return isExist(user);
    }



}
