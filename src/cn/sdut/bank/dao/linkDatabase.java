package cn.sdut.bank.dao;

import org.xml.sax.SAXException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.*;

import java.sql.*;
import java.util.Dictionary;

public class linkDatabase {
    public static Connection conn = null ;
    public String url = "jdbc:mysql://vargoo.com:3306/BankManage?" + "user=root&password=liuxh&useUnicode=true&characterEncoding=UTF8";
    public static Statement stmt = null;
    public String str;
    public boolean rs ;
    public ResultSet ru ;

    //链接到数据库

//    public boolean instData(String str){
//        if(conn!=null){
//            try{
//                conn.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(url);
//            Statement stmt = conn.createStatement();
//            this.rs = stmt.execute(str);
//            System.out.println("数据库连接成功！");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("Mysql操作错误");
//            e.printStackTrace();
//        } finally {
//            System.out.println("关闭成功");
//        }
//        return this.rs;
//    }

    public ResultSet gerResult(String str){
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            this.ru = stmt.executeQuery(str);
            System.out.println("数据库链接成功");

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } finally {

        }
        return this.ru;
    }

    public boolean getInsert(String str){

        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            this.rs = stmt.execute(str);
            System.out.println("数据库链接成功");

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } finally {

        }
        return this.rs;
    }

}
