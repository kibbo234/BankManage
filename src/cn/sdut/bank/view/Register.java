package cn.sdut.bank.view;

import cn.sdut.bank.service.AboutUser;
import cn.sdut.bank.tools.Account;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.*;

/**
 * 此类完成对开户页面的编写， 用户需填写 姓名，身份证号， 账户，密码，开户金额信息
 */
public class Register extends JFrame implements ActionListener {

    JButton jb1, jb2;                                            //按钮 注册 重置
    JLabel jlb1, jlb2, jlb3, jlb4, jlb5;                          //标签  帐号 姓名 密码 密码 注册信息
    JTextField jtf1, jtf2;                                       //文本框  帐号 姓名
    JPasswordField jpf1, jpf2;                                  //密码狂  密码 密码
    JPanel jp1, jp2, jp3, jp4, jp5, jp6;                        //面板

    public Register() {
        // TODO Auto-generated constructor stub
        //按钮
        jb1 = new JButton("注册");
        jb2 = new JButton("重置");
        //设置按钮监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        //标签信息
        jlb1 = new JLabel("帐号");
        jlb2 = new JLabel("姓名");
        jlb3 = new JLabel("密码");
        jlb4 = new JLabel("再次输入密码");
        jlb5 = new JLabel("注册信息");
        //开头字体
        jlb5.setFont(new java.awt.Font("Dialog", 1, 20));   //设置字体类型，加粗，大小为20
        //文本信息
        jtf1 = new JTextField(13);
        jtf2 = new JTextField(13);
        //密码框
        jpf1 = new JPasswordField(15);
        jpf2 = new JPasswordField(15);
        //面板
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();

        //将对应信息加入面板中
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jtf2);

        jp3.add(jlb3);
        jp3.add(jpf1);

        jp4.add(jlb4);
        jp4.add(jpf2);

        jp5.add(jlb5);

        jp6.add(jb1);
        jp6.add(jb2);

        //将JPane加入JFrame中
        this.add(jp5);  //先加入提示语

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp6);

        //设置布局
        this.setTitle("注册信息");
        this.setLayout(new GridLayout(7, 1));
        this.setSize(350, 350);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);   //设置不可拉伸大小

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("注册")) {
            try {
                register();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (e.getActionCommand().equals("重置")) {
            clear();
        }

    }

    //验证注册信息，并做处理
    public void register() throws IOException, SQLException {
        System.out.println(jpf1.getPassword());
        System.out.println(jpf2.getPassword());
        //判断信息是否补全
        if (jtf1.getText().isEmpty() || jtf2.getText().isEmpty() || jpf1.getPassword().length == 0 || jpf2.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "信息有空缺，请补全！", "消息提示", JOptionPane.WARNING_MESSAGE);

            /*
                pw和getPassword()都是char[]型不能用Object的equals方法比较。。。
                用Arrays.equals来比较2个char[]型，即
                Arrays.equals(bun.jpf.getPassword(), pw)
             */

        } else if (Arrays.equals(jpf1.getPassword(),jpf2.getPassword())) {

            String account = jtf1.getText();
            String name = jtf2.getText();
            String password = String.valueOf(jpf1.getPassword());
            Account user = new Account(account, name, password);
            boolean ret = AboutUser.isExist(user);
            if (!ret)   //调用Check的check方法检测用户是否存在， 如果不存在执行
            {
                AboutUser.Register(user);
                JOptionPane.showMessageDialog(null,"注册成功！","提示消息",JOptionPane.WARNING_MESSAGE);
                dispose();  //使窗口消失
                new Login();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"账号已存在，请重新输入！","提示消息",JOptionPane.WARNING_MESSAGE);
                //dispose();
            }

        } else {
            JOptionPane.showMessageDialog(null, "两次密码不一致,请重新输入!", "消息提示", JOptionPane.WARNING_MESSAGE);
            //注册成功， 打包为信息数组传递给UserMessage进行更新操作

        }
    }

    //清空账号和密码框
    private void clear() {
        // TODO Auto-generated method stub
        jtf1.setText("");    //设置为空
        jtf2.setText("");
        jpf1.setText("");
        jpf2.setText("");

    }


}