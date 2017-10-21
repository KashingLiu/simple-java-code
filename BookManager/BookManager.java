package BookManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

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
    Vector<BorrowRecord> borrowRecords = new Vector<BorrowRecord>();
    Vector<ReturnRecord> returnRecords = new Vector<ReturnRecord>();
    String[] borrowToStringArr() {
        int a = borrowRecords.size();
        String[] fine = new String[a];
        for (int i = 0;i<a;i++) {
            fine[i] = borrowRecords.get(i).result();
        }
        return fine;
    }
    String[] returnToStringArr() {
        int a = returnRecords.size();
        String[] fine = new String[a];
        for (int i = 0;i<a;i++) {
            fine[i] = returnRecords.get(i).result();
        }
        return fine;
    }
    void print() {
        System.out.print(account+password+status);
    }
}

class Manager extends User {
    int status = 1;
    void addUsers() {
//        ArrayUtils.
    }
}

class Book {
    private String name,author,press,ISBN,date,pages;
//    private Vector<String> book = new Vector<>(7);
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
                                //进行跳转操作
                                NorUser.setUser(i);
                                NorUser.main();
                                //把i和对应的两个数组传递给JPanel
                                frame.setVisible(false);
                                flag = 1;
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(myPanel,"用户名或密码错误","错误",0);//用户名或者密码错误
                                flag = 1;
                                break;
                            }
                        }
                    }
                    if (flag == 0) {
                        JOptionPane.showMessageDialog(myPanel,"无此用户","错误",0);//没有此用户
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e2) {
//                    e2.printStackTrace();
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

class NorUser {
    //静态方法引用非静态变量
    static private User user = new User();
    public static void setUser(User usr) {
        user = usr;
    }
    static Book book1 = new Book("中华少年儿童百科全书","ljc","HIT","01","2017","199");
    static Book book2 = new Book("水浒传","ljc","HIT","02","2017","180");
    static Book book3 = new Book("西游记","ljc","HIT","03","2017","180");
    static Book book4 = new Book("摆渡人","ljc","HIT","04","2017","180");
    static Book book5 = new Book("双城记","ljc","HIT","05","2017","180");
    static Book book6 = new Book("中国哲学简史","ljc","HIT","06","2017","180");
    static Book book7 = new Book("影响力","ljc","HIT","06","2017","180");
    static Book book8 = new Book("一九八四","ljc","HIT","07","2017","180");
    public static void main() {
        JFrame frame = new JFrame("test");
        Container cp = frame.getContentPane();
        cp.setLayout((new BoxLayout(cp,BoxLayout.Y_AXIS)));

        JPanel borrow_pa = new JPanel();
        JPanel return_pa = new JPanel();
        borrow_pa.setLayout(new BoxLayout(borrow_pa,BoxLayout.X_AXIS));
        return_pa.setLayout(new BoxLayout(return_pa,BoxLayout.X_AXIS));

        JLabel borrow_label = new JLabel("借书记录：");
        JLabel return_label = new JLabel("还书记录：");
        user.borrowRecords.add(new BorrowRecord());
        user.borrowRecords.get(0).setBR(user.account,"20171020",book1);
        JList borrow_ls = new JList<>(user.borrowToStringArr());
        JList return_ls = new JList<>(user.returnToStringArr());
        JScrollPane borrow_sp = new JScrollPane(borrow_ls,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane return_sp = new JScrollPane(return_ls,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton borrow_add = new JButton("添加记录");
        JButton return_add = new JButton("添加记录");

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

        frame.add(Box.createVerticalStrut(30));
        frame.add(borrow_pa);
        frame.add(Box.createVerticalStrut(10));
        frame.add(return_pa);
        frame.add(Box.createVerticalStrut(220));
        frame.setMinimumSize(new Dimension(800,600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

public class BookManager{
    private void saveUser(ArrayList<User> users) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("User.txt"));
            out.writeObject(users);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        BookManager bookManager = new BookManager();
        User user = new User();
        user.account = "12";
        user.status = 0;
        user.password = "12";
        User user1 = new User();
        user1.account = "11";
        user1.password = "12";
        user1.status = 0;
        users.add(user);
        users.add(user1);
        bookManager.saveUser(users);
//        LoginDialog a = new LoginDialog();
        NorUser.main();
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