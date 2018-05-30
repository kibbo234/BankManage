package cn.sdut.bank.service;

import cn.sdut.bank.dao.linkDatabase;
import cn.sdut.bank.po.StrMoney;
import cn.sdut.bank.po.StrUserId;
import cn.sdut.bank.tools.Account;
import cn.sdut.bank.tools.CurrentUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AboutMoney {

//    用户账户余额
    public static int getMoney() throws SQLException {
        int Balance;
        ResultSet rest;
        linkDatabase con = new linkDatabase();
        StrMoney cc = new StrMoney();
        String str = cc.SearchInformation();
        rest = con.gerResult(str);
        rest.next();
        Balance = rest.getInt(4);
        return Balance;
    }


//     用户存取金额
    public static boolean addMoney(int add) {
        boolean rest;
        linkDatabase con = new linkDatabase();
        StrMoney cc = new StrMoney();
        String str = cc.UpdateAddData(add);
        rest = con.getInsert(str);
        return rest;
    }


//    用户提取金额
    public static boolean cutMoney(int cut) {
        boolean rest;
        linkDatabase con = new linkDatabase();
        StrMoney cc = new StrMoney();
        String str = cc.UpdateCutData(cut);
        rest = con.getInsert(str);
        return rest;
    }


//    用户转账内容
    public static boolean transerToOthers(){
        String str = CurrentUser.getToAccount();
        boolean rest = true;

        return rest;
    }




}
