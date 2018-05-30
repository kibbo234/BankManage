package cn.sdut.bank.tools;

import cn.sdut.bank.dao.Account;

public class StrMoney {
    private String sql;

    public String BuildTable(){
        this.sql="CREATE TABLE IF NOT EXISTS `money`(\n" +
                "  `num` INT UNSIGNED AUTO_INCREMENT,\n" +
                "  `userId` varchar(15),\n" +
                "  `date` DATE,\n" +
                "  `money` DOUBLE,\n" +
                "  PRIMARY KEY (`num`)\n" +
                ")ENGINE = InnoDB DEFAULT CHARSET = utf8;";
        return this.sql;
    }

    public String SearchInformation(Account user){
        if(user.power==1){
            this.sql="SELECT * from money;";
        } else {
            this.sql="SELECT * from money WHERE `userId` = '"+user.account+"';";
        }
        return this.sql;
    }

    public String InsertData(Account user){
        this.sql="INSERT INTO money (`userId`,`date`,`money`)\n" +
                "    VALUES\n" +
                "            ('"+user.account+"', now(), 0);";
        return this.sql;
    }

    public String UpdateData(Account user, int money){
        this.sql="    update money set `money`=`money`+"+money+"  \n" +
                "    WHERE `userId` = '"+user.account+"';";
        return this.sql;
    }

}
