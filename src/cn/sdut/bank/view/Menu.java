package cn.sdut.bank.view;


import cn.sdut.bank.dao.AboutUser;
import cn.sdut.bank.dao.Account;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

/**
 * Menu是一个菜单
 */

public class Menu extends JFrame implements ActionListener{

    JButton jb1, jb2, jb3,jb4,jb5,jb6,jb7, jb8;  //创建按钮
    JLabel jlb1, jlb2, jlb3,jlb4;//标签
    public Account user;
    public Menu(Account user)
    {
        this.user = user;
        //所有按钮
        jb1 = new JButton("查询");
        jb2 = new JButton("存款");
        jb3 = new JButton("取款");
        jb4 = new JButton("转账");
        jb5 = new JButton("改密");
        jb6 = new JButton("开户");
        jb7 = new JButton("退卡");
        jb8 = new JButton("挂失");

        //标签内容
        jlb1 = new JLabel("银行管理管理系统");
        jlb1.setFont(new   java.awt.Font("Dialog",   1,   23)); //设置字体类型， 是否加粗，字号
        jlb2 = new JLabel("欢迎您");
        jlb2.setFont(new   java.awt.Font("Dialog",   1,   20));
        jlb3 = new JLabel("请您选择服务");
        jlb3.setFont(new   java.awt.Font("Dialog",   1,   22));
        jlb4 = new JLabel("用户名:"+user.name);
        jlb4.setFont(new   java.awt.Font("Dialog",   1,   22));

        jb1.addActionListener(this);   //事件监听
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);
        jb8.addActionListener(this);

        this.setTitle("银行管理管理系统");  //设置窗体标题
        this.setSize(450, 500);         //设置窗体大小
        this.setLocation(400, 200);     //设置位置
        this.setLayout(null);           //设置布局，不采用布局

        //设置按钮的位置和大小
        jb1.setBounds( 0,50,90,60);
        jb2.setBounds( 0,150,90,60);
        jb3.setBounds( 0,250,90,60);
        jb8.setBounds(0,350,90,60);
        jb4.setBounds( 354,50,90,60);
        jb5.setBounds( 354,150,90,60);
        jb6.setBounds( 354,250,90,60);
        jb7.setBounds(354,350,90,60);

        //设置标签的位置和大小
        jlb1.setBounds(150,120,150,50);
        jlb2.setBounds(190,160,150,50);
        jlb3.setBounds(150,250,150,50);
        jlb4.setBounds(150,350,150,50);


        this.add(jb1);   //加入窗体
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(jb5);
        this.add(jb6);
        this.add(jb7);
        this.add(jb8);
        this.add(jlb1);
        this.add(jlb2);
        this.add(jlb3);
        this.add(jlb4);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  //设置可关闭

        this.setVisible(true);  //设置可见
        this.setResizable(false);   //设置不可拉伸大小
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand()=="查询")
        {
            try{
                new Inquiry("123");
            }catch (IOException a){
                a.printStackTrace();
            }

        }
        else if (e.getActionCommand()=="存款")
        {
            new SaveMoney("123");
        }
        else if (e.getActionCommand()=="取款")
        {
            new DrawMoney("123");
        }
        else if (e.getActionCommand()=="转账")
        {
            new Transfer("123");
        }
        else if (e.getActionCommand()=="改密")
        {
            new Modify("123");
        }
        else if (e.getActionCommand()=="挂失")
        {
            new ReportLose();                 //改到登录界面
        }
        else if (e.getActionCommand()=="退卡")
        {
            System.exit(0);;
        }


    }

}