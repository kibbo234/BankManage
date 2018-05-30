package cn.sdut.bank.tools;

import cn.sdut.bank.tools.Account;

public class CurrentUser {
    private static String account;
    private static String name;
//    private static String password;
    private static int power;
    private static boolean exist;
    private static String toAccount;

    public CurrentUser(Account user){
        account = user.account;
        name = user.name;
        power = user.power;
        exist = user.exist;
    }


    public static String getAccount(){
        return account;
    }
    public static String getName(){
        return name;
    }
    public static int getPower(){
        return power;
    }
    public static boolean getexist(){
        return exist;
    }
    public static String getToAccount() {return toAccount; }






}
