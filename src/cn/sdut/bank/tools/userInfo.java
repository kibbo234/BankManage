package cn.sdut.bank.tools;

public class userInfo {
    private String name;
    private String account;
    private int power;
//    private String password;

    userInfo(String name,String account, int power){
        super();
        this.name = name;
        this.account = account;
        this.power = power;
    }
    public String getName(){
        return this.name;
    }
    public String getAccount(){
        return this.account;
    }
    public int getPower(){
        return this.power;
    }

    public boolean setName(String name){
        this.name = name;
        return true;
    }
    public boolean setAccount(String account){
        this.account = account;
        return true;
    }
    public boolean setPower(int power){
        this.power = power;
        return true;
    }

}

