package cn.sdut.bank.po;

import cn.sdut.bank.tools.Account;

public class StrUserId {
    private String sql;

//      建立表格
    public String BulidTable(){
        this.sql = "CREATE TABLE IF NOT EXISTS `userId`(\n" +
                "  `id` INT UNSIGNED AUTO_INCREMENT, \n" +
                "  `account` varchar(15) ,\n" +
                "  `name` VARCHAR(15) NOT NULL ,\n" +
                "  `password` VARCHAR(15) ,\n" +
                "  `subTime` DATE,\n" +
                "  `power` INT ,\n" +
                "  `exist` boolean,\n" +
                "  PRIMARY KEY (`id`) \n" +
                "\n" +
                ")ENGINE = InnoDB DEFAULT CHARSET = utf";
        return this.sql;
    }


//    获取用户所有信息
    public String SearchInformation(Account user){
        if(user.power==1){
            this.sql = "SELECT * FROM userId;";
        } else {
            this.sql = "SELECT * FROM userId WHERE userId.`account` = '"+user.account+"'; ";
        }

        return this.sql;
    }

//    插入用户操作   #权限问题以后 admin=1 user=2
    public String InsertData(Account user){
        this.sql="INSERT INTO userId (account, name, password, subTime, power,exist)\n" +
                "values\n" +
                "  ('"+user.account+"','"+user.name+"','"+user.password+"',now(),2, true);";
        return this.sql;
    }

//    public String InsertData(Account user){
//        this.sql = "INSERT INTO userId (account, name, password, subTime, power,exist)\n" +
//                "values\n" +
//                "  ('"+user.account+"','"+user.name+"','"+user.password+"',now(),2, true);";
//        return this.sql;
//    }

//    更改密码操作  #用户密码更改
    public String UpdatPassword(String password){


        this.sql = "123";
        return this.sql;
    }







}
