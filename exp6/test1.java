package exp6;

/*
    编写一个个人通信录程序，具有如下功能：
	定义一个通信录类，包括姓名、地址、邮政编码、电话、手机、Email等成员变量；
	将通信录类的对象存储在文件中。
	设计一个用户界面，在该界面中可以实现通信录增加、修改、删除和查询的功能。
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import static exp6.Show.all;
import static exp6.Show.listModel;

class Address implements Serializable {
    String name, address, postcode, Telephone, Phone, Email;
    String getString() {
        return "姓名："+name+" 地址："+address+" 邮编："+postcode+" 固话："+Telephone+" 手机："+Phone+" 邮箱："+Email;
    }
}

class Show {
    public static ArrayList<Address> all = new ArrayList<>(20);
    public static DefaultListModel<String> listModel = new DefaultListModel<>();
    //初始化窗口
    public static void first() {
        Address first;
        try {
            File file = new File("Address.txt");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            while (file.canRead()) {
                first = (Address)in.readObject();
                all.add(first);
                listModel.addElement(first.getString());
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }
    public static void main() {
        JFrame frame = new JFrame("通讯录");
        Container cp = frame.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        JList list = new JList<>(listModel);
        JScrollPane list_sp = new JScrollPane(list,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        first();

        panel.add(Box.createVerticalStrut(8));
        panel.add(list_sp);
        panel.add(Box.createVerticalStrut(8));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));

        JButton add = new JButton("添加");
        JButton change = new JButton("编辑");
        JButton save = new JButton("保存");

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add.main();
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save(frame);
            }
        });

        panel1.add(add);
        panel1.add(change);
        panel1.add(save);

        frame.add(Box.createHorizontalStrut(8));
        frame.add(panel);
        frame.add(panel1);
        frame.setMinimumSize(new Dimension(400,600));
        frame.setMaximumSize(new Dimension(400,600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void save(JFrame frame) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Address.txt"));
            for (Address i : all) {
                out.writeObject(i);
            }
            out.close();
            JOptionPane.showMessageDialog(frame,"保存成功","保存",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame,"保存失败","保存",1);
        }
    }
}

class Change {
    public static void main() {
        JFrame frame = new JFrame("修改");
    }
}

class Add {
    public static void main() {
        JFrame frame = new JFrame("添加联系人");
        Container cp = frame.getContentPane();
        cp.setLayout(new BoxLayout(cp,BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("姓名：");
        JLabel label2 = new JLabel("地址：");
        JLabel label3 = new JLabel("邮编：");
        JLabel label4 = new JLabel("固话：");
        JLabel label5 = new JLabel("手机：");
        JLabel label6 = new JLabel("邮箱：");

        JTextField tf1 = new JTextField(12);
        JTextField tf2 = new JTextField(12);
        JTextField tf3 = new JTextField(12);
        JTextField tf4 = new JTextField(12);
        JTextField tf5 = new JTextField(12);
        JTextField tf6 = new JTextField(12);

        JButton button1 = new JButton("完成");
        JButton button2 = new JButton("取消");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Address a = new Address();
                a.name = tf1.getText();
                a.address = tf2.getText();
                a.postcode = tf3.getText();
                a.Telephone = tf4.getText();
                a.Phone = tf5.getText();
                a.Email = tf6.getText();
                all.add(a);
                listModel.addElement("姓名："+a.name+" 地址："+a.address+" 邮编："+a.postcode+" 固话："+a.Telephone+" 手机："+a.Phone+" 邮箱："+a.Email);
                frame.setVisible(false);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();

        panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
        panel3.setLayout(new BoxLayout(panel3,BoxLayout.X_AXIS));
        panel4.setLayout(new BoxLayout(panel4,BoxLayout.X_AXIS));
        panel5.setLayout(new BoxLayout(panel5,BoxLayout.X_AXIS));
        panel6.setLayout(new BoxLayout(panel6,BoxLayout.X_AXIS));
        panel7.setLayout(new BoxLayout(panel7,BoxLayout.X_AXIS));

        panel1.add(Box.createHorizontalStrut(20));
        panel2.add(Box.createHorizontalStrut(20));
        panel3.add(Box.createHorizontalStrut(20));
        panel4.add(Box.createHorizontalStrut(20));
        panel5.add(Box.createHorizontalStrut(20));
        panel6.add(Box.createHorizontalStrut(20));

        panel1.add(label1);
        panel2.add(label2);
        panel3.add(label3);
        panel4.add(label4);
        panel5.add(label5);
        panel6.add(label6);

        panel1.add(tf1);
        panel2.add(tf2);
        panel3.add(tf3);
        panel4.add(tf4);
        panel5.add(tf5);
        panel6.add(tf6);

        panel1.add(Box.createHorizontalStrut(20));
        panel2.add(Box.createHorizontalStrut(20));
        panel3.add(Box.createHorizontalStrut(20));
        panel4.add(Box.createHorizontalStrut(20));
        panel5.add(Box.createHorizontalStrut(20));
        panel6.add(Box.createHorizontalStrut(20));

        panel7.add(button1);
        panel7.add(button2);

        frame.add(Box.createVerticalStrut(20));
        frame.add(panel1);
        frame.add(Box.createVerticalStrut(10));
        frame.add(panel2);
        frame.add(Box.createVerticalStrut(10));
        frame.add(panel3);
        frame.add(Box.createVerticalStrut(10));
        frame.add(panel4);
        frame.add(Box.createVerticalStrut(10));
        frame.add(panel5);
        frame.add(Box.createVerticalStrut(10));
        frame.add(panel6);
        frame.add(Box.createVerticalStrut(10));
        frame.add(panel7);
        frame.add(Box.createVerticalStrut(20));

        frame.setMinimumSize(new Dimension(250,350));
        frame.setMaximumSize(new Dimension(250,350));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

public class test1 {

    public static void main(String[] args) {
        Show.main();
//        Add.main();
    }
}