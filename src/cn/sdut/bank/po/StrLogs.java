package cn.sdut.bank.po;

import cn.sdut.bank.tools.Account;
import cn.sdut.bank.tools.CurrentUser;

public class StrLogs {
    private String sql;
    //建表格
    public String BulidTable(){
        this.sql = "CREATE TABLE IF NOT EXISTS `logs`(\n" +
                "  `num` INT UNSIGNED AUTO_INCREMENT,\n" +
                "  `userId` varchar(15), \n" +
                "  `type` VARCHAR(15) ,  \n" +
                "  `from` VARCHAR(15),\n" +
                "  `to` varchar(15),\n" +
                "  `time` DATE,\n" +
                "  `money` INT UNSIGNED,\n" +
                "  PRIMARY KEY (`num`)\n" +
                ")ENGINE = InnoDB DEFAULT CHARSET = utf8;\n";
        return this.sql;
    }

    public String SearchInformation(){
        if(CurrentUser.getPower()==1){
            this.sql = "SELECT * FROM logs;";
        } else {
            this.sql = "WHERE `"+CurrentUser.getAccount()+"` = 'test2' or `to` = '"+CurrentUser.getAccount()+"'; ";
        }
        return this.sql;
    }

//    public String InsertData(Account user){
//        this.sql = "INSERT INTO userId (account, name, password, subTime, power,exist)\n" +
//                "values\n" +
//                "  ('"+user.account+"','"+user.name+"','"+user.password+"',now(),2, true);";
//        return this.sql;
//        #日志插入
//        INSERT INTO logs(`userId`,`type`)
//        values
//                ('test1','注册');
//        INSERT INTO logs(`userId`,`type`)
//        values
//                ('test1','注销');
//        INSERT INTO logs(`userId`,`type`,`money`)
//        values
//                ('test1','存款',5);
//        INSERT INTO logs(`userId`,`type`,`money`)
//        values
//                ('test2','提款',5);
//        INSERT INTO logs(`time`,`userId`,`type`,`money`,`from`,`to`)    #两条分别表示不同的人  转帐和被转帐
//        values
//                (now(),'test1','转帐',5,'test1','test2');
//    }

}


