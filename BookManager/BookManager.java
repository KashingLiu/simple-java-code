package BookManager;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import static BookManager.BookManager.users;
import static BookManager.NorUser.listModel2;

/**
 * 1)	录入图书信息(Book)，图书的属性包括书名(name)、作者(author)、出版社(press)、刊号(ISBN)、出版日期(pubDate)、页数(pages)等。
 2)	录入用户信息(User)，用户属性包括用户名(account)，密码(password)、用户类型(type)，用户分为管理员和普通用户。
 3)	记录每个用户的借书记录，借书记录(BorrowRecord)包括：用户(user)、借书日期(borrowDate)、图书(book)。
 4)	记录每个用户的还书记录，还书记录(ReturnRecord)包括：用户(user)、还书日期(returnDate)、图书(book)。
 1)	采用图形界面来实现登陆、录入借书记录、录入还书记录等功能。
 录入图书信息、录入用户信息、
 */


class BorrowRecord {
    private String user;
    private String borrowDate;
    Book book;
    public void setBR(String usr, String date, Book bok) {
        user = usr;
        borrowDate = date;
        book = bok;
    }
    String result() {
        return " 用户名："+user+" 借书日期："+borrowDate+book.getBook();
    }
}

class ReturnRecord {
    private String user;
    private String returnDate;
    Book book;
    public void setBR(String usr, String date, Book bok) {
        user = usr;
        returnDate = date;
        book = bok;
    }
    String result() {
        return " 用户名："+user+" 还书日期："+returnDate+book.getBook();
    }
}

class User implements Serializable {
    String account;
    String password;
    int status = 0;
    Vector<BorrowRecord> borrowRecords = new Vector<BorrowRecord>(10);
    Vector<ReturnRecord> returnRecords = new Vector<ReturnRecord>(10);
    String result() {
        if (status == 1) {
            return "用户名："+account+" 权限：管理员";
        }
        else return "用户名："+account+" 权限：普通用户";
    }
}

class Manager {
    public static void setUser() {
        JFrame frame = new JFrame("注册");
        Container cn = frame.getContentPane();
        cn.setLayout(new BoxLayout(cn, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();
        BoxLayout bx1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
        JLabel label1 = new JLabel("用户名：");
        JTextField tf1 = new JTextField(12);
        panel1.add(Box.createRigidArea(new Dimension(9, 1)));
        panel1.add(label1);
        panel1.add(tf1);

        JPanel panel2 = new JPanel();
        BoxLayout bx2 = new BoxLayout(panel2, BoxLayout.X_AXIS);
        JLabel label2 = new JLabel("密码：");
        JTextField tf2 = new JTextField(12);
        panel2.add(Box.createRigidArea(new Dimension(9, 1)));
        panel2.add(label2);
        panel2.add(tf2);

        JButton setOK = new JButton("添加");
        JButton setCancel = new JButton("取消");

        JPanel panel3 = new JPanel();
        BoxLayout bx3 = new BoxLayout(panel3, BoxLayout.X_AXIS);
        panel3.add(setOK);
        panel3.add(setCancel);

        JPanel panel4 = new JPanel();
        BoxLayout bx4 = new BoxLayout(panel4, BoxLayout.X_AXIS);
        JLabel label4 = new JLabel("权限：");
        JTextField tf3 = new JTextField(12);
        panel4.add(Box.createRigidArea(new Dimension(9, 1)));
        panel4.add(label4);
        panel4.add(tf3);

        setOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User a = new User();
                if (tf3.getText().equals(""))
                    a.status = 0;
                else
                    a.status = Integer.valueOf(tf3.getText());
                a.account = tf1.getText();
                a.password = tf2.getText();
                users.add(a);
                listModel2.addElement(a.result());
                BookManager.saveUser(users);
                frame.setVisible(false);
            }
        });

        setCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        frame.add(Box.createVerticalStrut(20));
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel4);
        frame.add(panel3);
        frame.add(Box.createVerticalStrut(150));
        frame.setMinimumSize(new Dimension(300,200));
        frame.setVisible(true);
    }
}

class Book {
    private String name,author,press,ISBN,date,pages;
    Book(String name, String author, String press, String ISBN, String date, String pages) {
        this.name = name;
        this.author = author;
        this.press = press;
        this.ISBN = ISBN;
        this.date = date;
        this.pages = pages;
    }
    String getBook() {
        return "书名："+name+" 作者："+author+" 出版社："+press+" ISBN："+ISBN+" 出版日期："+date+" 页数："+pages;
    }
}

class NorUser {
    //静态方法引用非静态变量
    private static JFrame frame = new JFrame("test");
    private static User user = new User();
    static DefaultListModel<String> listModel = new DefaultListModel<>();
    static DefaultListModel<String> listModel1 = new DefaultListModel<>();
    static DefaultListModel<String> listModel2 = new DefaultListModel<>();
    static JList borrow_ls = new JList<>(listModel);
    static JList return_ls = new JList<>(listModel1);
    static JList user_ls = new JList<>(listModel2);

    public static void setUser(User usr) {
        user = usr;
    }

    static ActionListener add = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddRecord.main(user);
        }
    };
    static ActionListener user_button = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Manager.setUser();
        }
    };
    public static void go() {
        NorUser nu = new NorUser();
        nu.main();
    }
    public void main() {
        Container cp = frame.getContentPane();
        cp.setLayout(new BoxLayout(cp,BoxLayout.Y_AXIS));

        JPanel borrow_pa = new JPanel();
        JPanel return_pa = new JPanel();
        JPanel User_pa = new JPanel();
        borrow_pa.setLayout(new BoxLayout(borrow_pa,BoxLayout.X_AXIS));
        return_pa.setLayout(new BoxLayout(return_pa,BoxLayout.X_AXIS));
        User_pa.setLayout(new BoxLayout(User_pa,BoxLayout.X_AXIS));

        JLabel borrow_label = new JLabel("借书记录：");
        JLabel return_label = new JLabel("还书记录：");
        JLabel user_label = new JLabel("添加用户：");

        JScrollPane borrow_sp = new JScrollPane(borrow_ls,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane return_sp = new JScrollPane(return_ls,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane user_sp = new JScrollPane(user_ls,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton borrow_add = new JButton("添加记录");
        JButton return_add = new JButton("添加记录");
        JButton user_add = new JButton("添加记录");

        //添加记录
        borrow_add.addActionListener(add);
        user_add.addActionListener(user_button);
        //删除记录
        ListSelectionListener lsl = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    return_add.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //设置日期格式
                            System.out.println();// new Date()为获取当前系统时间
                            try {
                                if (!((String)borrow_ls.getSelectedValue()).equals("")) {
                                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                    listModel1.addElement((String)borrow_ls.getSelectedValue()+" 还书日期："+df.format(new Date()));
                                    listModel.removeElement(listModel.getElementAt(borrow_ls.getSelectedIndex()));
                                }
                            } catch (ArrayIndexOutOfBoundsException e1) {
                                System.out.println("");
                            } catch (NullPointerException e2) {
                                System.out.println(" ");
                            }
                        }
                    });
                }
            }
        };
        borrow_ls.addListSelectionListener(lsl);

        borrow_pa.add(Box.createHorizontalStrut(20));
        borrow_pa.add(borrow_label);
        borrow_pa.add(borrow_sp);
        borrow_pa.add(Box.createHorizontalStrut(20));
        borrow_pa.add(borrow_add);
        borrow_pa.add(Box.createHorizontalStrut(20));

        return_pa.add(Box.createHorizontalStrut(20));
        return_pa.add(return_label);
        return_pa.add(return_sp);
        return_pa.add(Box.createHorizontalStrut(20));
        return_pa.add(return_add);
        return_pa.add(Box.createHorizontalStrut(20));

        User_pa.add(Box.createHorizontalStrut(20));
        User_pa.add(user_label);
        User_pa.add(user_sp);
        User_pa.add(Box.createHorizontalStrut(20));
        User_pa.add(user_add);
        User_pa.add(Box.createHorizontalStrut(20));

        if (user.status == 1) {
            frame.add(Box.createVerticalStrut(30));
            frame.add(borrow_pa);
            frame.add(Box.createVerticalStrut(10));
            frame.add(return_pa);
            frame.add(Box.createVerticalStrut(10));
            frame.add(User_pa);
            frame.add(Box.createVerticalStrut(10));
            frame.setMinimumSize(new Dimension(800,600));
        } else if (user.status == 0) {
            frame.add(Box.createVerticalStrut(30));
            frame.add(borrow_pa);
            frame.add(Box.createVerticalStrut(10));
            frame.add(return_pa);
            frame.add(Box.createVerticalStrut(30));
            frame.setMinimumSize(new Dimension(800,430));
        }
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


public class BookManager{
    public static ArrayList<User> users = new ArrayList<>();
    static void saveUser(ArrayList<User> users) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("User.txt"));
            out.writeObject(users);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        User user = new User();
        user.account = "12";
        user.status = 1;
        user.password = "12";
        User user1 = new User();
        user1.account = "11";
        user1.password = "12";
        user1.status = 0;
        users.add(user);
        users.add(user1);
        bookManager.saveUser(users);
        LoginDialog a = new LoginDialog();
    }
}






























//        ArrayList<User> newusers;
//        try {
//            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("User.txt"));
//            newusers = (ArrayList<User>)objectInputStream.readObject();
//            newusers.get(0).print();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.getCause();
//        }


//    private static void readFile() {
//        try {
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream("User.txt"));
//            ArrayList<User> users = (ArrayList<User>)in.readObject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

//    static Book book1 = new Book("中华少年儿童百科全书","ljc","HIT","01","2017","199");
//    static Book book2 = new Book("水浒传","ljc","HIT","02","2017","180");
//    static Book book3 = new Book("西游记","ljc","HIT","03","2017","180");
//    static Book book4 = new Book("摆渡人","ljc","HIT","04","2017","180");
//    static Book book5 = new Book("双城记","ljc","HIT","05","2017","180");
//    static Book book6 = new Book("中国哲学简史","ljc","HIT","06","2017","180");
//    static Book book7 = new Book("影响力","ljc","HIT","06","2017","180");
//    static Book book8 = new Book("一九八四","ljc","HIT","07","2017","180");