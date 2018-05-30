package cn.sdut.bank.service;

import cn.sdut.bank.dao.linkDatabase;
import cn.sdut.bank.po.StrLogs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AboutlLogs {



//    查询日志内容
    public static ResultSet getLogs() throws SQLException {
        ResultSet rest;
        linkDatabase con = new linkDatabase();
        StrLogs cc = new StrLogs();
        String str = cc.SearchInformation();
        rest = con.gerResult(str);
        System.out.println(rest);
        return rest;
    }





}
