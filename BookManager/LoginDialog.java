package BookManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

class LoginDialog {
    private JFrame frame = new JFrame("登录");
    private JTextField user = new JTextField();
    private JPasswordField pwd = new JPasswordField();
    private JButton button = new JButton("登录");
    private JButton cancel = new JButton("取消");
    private JPanel myPanel = new JPanel();
    private String username;
    private String password;

    LoginDialog() {
        JLabel a = new JLabel("用户名：");
        JLabel b = new JLabel("密码：");
        myPanel.setLayout(null);
        a.setBounds(43,21,88,17);
        user.setBounds(92,15,150,28);
        b.setBounds(43,48,88,17);
        pwd.setBounds(92,42,150,28);
        button.setBounds(60,78,88,25);
        cancel.setBounds(150,78,88,25);
        myPanel.add(a);
        myPanel.add(user);
        myPanel.add(b);
        myPanel.add(pwd);
        myPanel.add(button);
        myPanel.add(cancel);
        setOK();
        setCancel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(myPanel);
        frame.setMinimumSize(new Dimension(286,135));
        frame.setVisible(true);
    }

    private void setOK() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = user.getText();
                password = String.valueOf(pwd.getPassword());
                ArrayList<User> users;
                try {
                    FileInputStream fileInputStream = new FileInputStream("User.txt");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    users = (ArrayList<User>)objectInputStream.readObject();
                    int flag = 0;
                    for (User i: users) {
                        if (i.account.equals(username)) {
                            if (i.password.equals(password)) {
                                    NorUser.setUser(i);
                                    NorUser.go();
                                frame.setVisible(false);
                                flag = 1;
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(myPanel,"用户名或密码输入错误","错误",0);
                                flag = 1;
                                break;
                            }
                        }
                    }
                    if (flag == 0) {
                        JOptionPane.showMessageDialog(myPanel,"用户名不存在","错误",0);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e2) {
                } catch (IndexOutOfBoundsException e3) {
                }
            }
        });
    }
    private void setCancel() {
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}