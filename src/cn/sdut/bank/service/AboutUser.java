package cn.sdut.bank.service;

import cn.sdut.bank.tools.Account;
import cn.sdut.bank.dao.linkDatabase;
import cn.sdut.bank.po.StrUserId;
import cn.sdut.bank.tools.CurrentUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AboutUser {
//      查询账户是否存在
    public static boolean isExist(Account user) throws SQLException {
        ResultSet rest;
        linkDatabase con = new linkDatabase();
        StrUserId cc = new StrUserId();
        String str = cc.SearchInformation(user);
        rest = con.gerResult(str);
        System.out.println(rest);
        return rest.next();

    }
//      获取账户信息
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

//    注册账户
    public static boolean Register(Account user) throws SQLException {
        linkDatabase con = new linkDatabase();
        StrUserId cc = new StrUserId();
        String str = cc.InsertData(user);
        con.getInsert(str);
        return isExist(user);
    }

//    查询用户是否可用   #用来确认是不是销户了
    public static boolean ifCanUse(){
        boolean ret = CurrentUser.getexist();
        return ret;
    }

//    挂失用户 禁止使用存钱和取钱操作
    public static boolean isLose(){


        return true;
    }


//    更改用户密码
    public static boolean setPassword(String password){


        return true;
    }


}
