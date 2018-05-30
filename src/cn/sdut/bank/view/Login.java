package cn.sdut.bank.view;


import cn.sdut.bank.tools.CurrentUser;
import cn.sdut.bank.service.AboutUser;
import cn.sdut.bank.tools.Account;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.String;
import java.sql.SQLException;

import javax.swing.*;

/**
 * 登录界面
 * 文本框和标签一组
 * 按钮一组
 * 最后加入组件中
 */

//    界面内容样式
public class Login extends JFrame implements ActionListener {

    JButton jb1, jb2, jb3;  //按钮
    JPanel jp1, jp2, jp3, jp4;        //面板
    JTextField jtf;   //文本框
    JLabel jlb1, jlb2, jlb3; //标签
    JPasswordField jpf; //密码框

    public Login() {

        // TODO Auto-generated constructor stub
        jb1 = new JButton("登录");
        jb2 = new JButton("重置");
        jb3 = new JButton("注册");
        //设置按钮监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();

        jlb1 = new JLabel("用户名");  //添加标签
        jlb2 = new JLabel("  密  码");

        jtf = new JTextField(15);   //创建文本框和密码框
        jpf = new JPasswordField(15);

        //加入面板中
        jp1.add(jlb1);
        jp1.add(jtf);

        jp2.add(jlb2);
        jp2.add(jpf);

        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);

        //将JPane加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        //设置布局
        this.setTitle("用户登录");
        this.setLayout(new GridLayout(3, 1));
        this.setSize(300, 200);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);   //设置不可拉伸大小

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand() == "登录") {
            try {
                login();
            } catch (HeadlessException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (e.getActionCommand() == "重置") {
            clear();
        } else if (e.getActionCommand() == "注册") {
            new Register();
            dispose();
        }

    }

    //清空账号和密码框
    private void clear() {
        // TODO Auto-generated method stub
        jtf.setText("");    //设置为空
        jpf.setText("");

    }


    //验证登录信息，并做处理
    public void login() throws HeadlessException, IOException, SQLException {
        //判断账户名和密码是否包含中文
        String account = jtf.getText();
        String password = String.valueOf(jpf.getPassword());
//        System.out.println(password);
        if(jtf.getText().isEmpty()&& 0 == jpf.getPassword().length)
        {
            JOptionPane.showMessageDialog(null, "账号密码为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        else if (jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "账号为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        else if (0 == jpf.getPassword().length)
        {
            JOptionPane.showMessageDialog(null, "密码为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);

        }
        else{
            //是否添加用户不存在内容
            boolean ret = AboutUser.isExist(new Account(account,password));
            if(!ret){
                JOptionPane.showMessageDialog(null, "用户不存在请重新输入！","消息提示",JOptionPane.ERROR_MESSAGE);
                clear();  //调用清除函数

            }else {
                Account user = AboutUser.getAccount(new Account(account,password));
                System.out.println(password);
                System.out.println(user.password);
                if(user.password.equals(password)) {
                    JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
                    new  CurrentUser(user);
                    new Menu();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误请重新输入！","消息提示",JOptionPane.ERROR_MESSAGE);
                }

            }
        }

    }


}