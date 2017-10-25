package BookManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import static BookManager.NorUser.listModel;

class AddRecord {
    public static void main(User user) {
        JFrame frame = new JFrame("添加");
        Container cn = frame.getContentPane();
        cn.setLayout(new BoxLayout(cn, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();
        BoxLayout bx1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
        JLabel username = new JLabel("用户名：");
        JTextField userName = new JTextField(20);
        panel1.add(Box.createRigidArea(new Dimension(9, 1)));
        panel1.add(username);
        panel1.add(userName);

        JPanel panel2 = new JPanel();
        BoxLayout bx2 = new BoxLayout(panel2, BoxLayout.X_AXIS);
        JLabel date = new JLabel("借书日期：");
        JTextField Date = new JTextField(20);
        panel2.add(date);
        panel2.add(Date);

        JPanel panel3 = new JPanel();
        BoxLayout bx3 = new BoxLayout(panel3, BoxLayout.X_AXIS);
        JLabel name = new JLabel("书名：");
        JTextField Name = new JTextField(20);
        panel3.add(Box.createRigidArea(new Dimension(21, 1)));
        panel3.add(name);
        panel3.add(Name);

        JPanel panel4 = new JPanel();
        BoxLayout bx4 = new BoxLayout(panel4, BoxLayout.X_AXIS);
        JLabel author = new JLabel("作者：");
        JTextField Author = new JTextField(20);
        panel4.add(Box.createRigidArea(new Dimension(21, 1)));
        panel4.add(author);
        panel4.add(Author);

        JPanel panel5 = new JPanel();
        BoxLayout bx5 = new BoxLayout(panel5, BoxLayout.X_AXIS);
        JLabel press = new JLabel("出版社：");
        JTextField Press = new JTextField(20);
        panel5.add(Box.createRigidArea(new Dimension(9, 1)));
        panel5.add(press);
        panel5.add(Press);

        JPanel panel6 = new JPanel();
        BoxLayout bx6 = new BoxLayout(panel6, BoxLayout.X_AXIS);
        JLabel ISBN = new JLabel("ISBN：");
        JTextField iSBN = new JTextField(20);
        panel6.add(Box.createRigidArea(new Dimension(21, 1)));
        panel6.add(ISBN);
        panel6.add(iSBN);

        JPanel panel7 = new JPanel();
        BoxLayout bx7 = new BoxLayout(panel7, BoxLayout.X_AXIS);
        JLabel pubdate = new JLabel("出版日期：");
        JTextField PubDate = new JTextField(20);
        panel7.add(pubdate);
        panel7.add(PubDate);

        JPanel panel8 = new JPanel();
        BoxLayout bx8 = new BoxLayout(panel8, BoxLayout.X_AXIS);
        JLabel pages = new JLabel("页数：");
        JTextField Pages = new JTextField(20);
        panel8.add(Box.createRigidArea(new Dimension(21, 1)));
        panel8.add(pages);
        panel8.add(Pages);


        JButton setOK = new JButton("添加");
        JButton setCancel = new JButton("取消");



        setOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                user.borrowRecords.add(new BorrowRecord());
                Book newBook = new Book(Name.getText(), Author.getText(), Press.getText(), iSBN.getText(), PubDate.getText(), Pages.getText());
                user.borrowRecords.get(user.borrowRecords.size() - 1).setBR(userName.getText(), Date.getText(), newBook);
                listModel.addElement("用户名：" + userName.getText() + " 借书日期：" + df.format(new Date()) + "书名：" +
                        Name.getText() + " 作者：" + Author.getText() + " 出版社：" + Press.getText() + " ISBN：" + iSBN.getText() + " 出版日期：" + PubDate.getText() + " 页数：" + Pages.getText());
                frame.setVisible(false);
            }
        });

        setCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        JPanel panel9 = new JPanel();
        BoxLayout bx9 = new BoxLayout(panel9, BoxLayout.X_AXIS);
        panel9.add(setOK);
        panel9.add(setCancel);

        frame.add(Box.createVerticalStrut(25));
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel6);
        frame.add(panel7);
        frame.add(panel8);
        frame.add(panel9);
        frame.add(Box.createVerticalStrut(10));
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setVisible(true);
    }
}