package cn.sdut.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.*;

public class linkData {
    public static void main(String[] args)throws Exception{
        static Connection conn = null;
        String sql;
        String url = "jdbc:mysql://vargoo.com:3306/BankManage?" + "user=root&password=liuxh&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            System.out.println("数据库连接成功！");
//            Statement stmt = conn.createStatement();
//            sql = "createtable student(NO char(20),name varchar(20),primary key(NO))";
//            int result = stmt.executeUpdate(sql);
//            if(result != -1){
//                System.out.println("创建数据表成功：");
//                sql = "insert into student(NO,name) values ('2016001','刘达')";
//                result = stmt.executeUpdate(sql);
//                sql = "insert into student(NO,name) values('2016002','陈二')";
//                result = stmt.executeUpdate(sql);
//                sql = "select * from student";
//                ResultSet rs = stmt.executeQuery(sql);
//                System.out.println("学号\t姓名");
//                while(rs.next()){
//                    System.out.println(rs.getString(1)+"\t"+rs.getLong(2));
//                }
//
//
//            }
//


        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println("Mysql操作错误");
            e.printStackTrace();
        } finally {
            System.out.printf("关闭成功");
            conn.close();
        }
    }




}
