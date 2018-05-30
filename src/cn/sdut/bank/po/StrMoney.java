package cn.sdut.bank.po;

import cn.sdut.bank.tools.Account;
import cn.sdut.bank.tools.CurrentUser;

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

    public String SearchInformation(){
        if(CurrentUser.getPower() ==1){
            this.sql="SELECT * from money;";
        } else {
            this.sql="SELECT * from money WHERE `userId` = '"+CurrentUser.getAccount()+"';";
        }
        return this.sql;
    }

    public String InsertData(){
        this.sql="INSERT INTO money (`userId`,`date`,`money`)\n" +
                "    VALUES\n" +
                "            ('"+CurrentUser.getAccount()+"', now(), 0);";
        return this.sql;
    }

    public String UpdateAddData( int money){
        this.sql="    update money set `money`=`money`+"+money+"  \n" +
                "    WHERE `userId` = '"+CurrentUser.getAccount()+"';";
        return this.sql;
    }
    public String UpdateCutData( int money){
        this.sql="    update money set `money`=`money`-"+money+"  \n" +
                "    WHERE `userId` = '"+CurrentUser.getAccount()+"';";
        return this.sql;
    }

}
