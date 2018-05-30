package cn.sdut.bank;

import cn.sdut.bank.dao.*;
import cn.sdut.bank.dao.linkDatabase;
import cn.sdut.bank.view.Login;
import cn.sdut.bank.view.Menu;

public class Main {

    public static void main(String[] args) {

       new Login();

        /*String str = "INSERT INTO userId (account, name, password, subTime, power)\n" +
                "    VALUES\n" +
                "      ('root123','admin', MD5('123456'),NOW() ,-1);";
        linkDatabase con = new linkDatabase();
        boolean rs = con.instData(str);
        if(rs){
            System.out.println("yes");
        }else{
            System.out.println("No!");
        }*/

    }
}
