package cn.sdut.bank.tools;

import cn.sdut.bank.dao.Account;

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

    public String SearchInformation(Account user){
        if(user.power==1){
            this.sql = "SELECT * FROM logs;";
        } else {
            this.sql = "WHERE `"+user.account+"` = 'test2' or `to` = '"+user.account+"'; ";
        }

        return this.sql;
    }

    public String InsertData(Account user){
        this.sql = "INSERT INTO userId (account, name, password, subTime, power,exist)\n" +
                "values\n" +
                "  ('"+user.account+"','"+user.name+"','"+user.password+"',now(),2, true);";
        return this.sql;
    }

}


