package exp3;
import java.util.Scanner;
import java.util.Vector;

/*
 * 图书类，成员是一个私有的字符串类型的向量，大小为7
 * 对于Book类的构造方法是储存元素到向量中
 * print方法用来规范化打印某一本书的属性
 * getISSN和getName用来对外提供book的识别号和书名两个属性
 */
class Book {
    private Vector<String> book = new Vector<>(7);
    Book(String name, String author, String press, String ISSN, String date, String page, String summary) {
        book.addElement(name);
        book.addElement(author);
        book.addElement(press);
        book.addElement(ISSN);
        book.addElement(date);
        book.addElement(page);
        book.addElement(summary);
    }
    void print() {
        System.out.print("name: "+book.get(0)+"  ");
        System.out.print("author: "+book.get(1)+"  ");
        System.out.print("press: "+book.get(2)+"  ");
        System.out.print("ISSN: "+book.get(3)+"  ");
        System.out.print("date: "+book.get(4)+"  ");
        System.out.print("page: "+book.get(5)+"  ");
        System.out.print("summary: "+book.get(6));
        System.out.println();
    }
    String getISSN() {
        return book.get(3);
    }
    String getName() {
        return book.get(0);
    }
}

/*
 * 书架类用来存放书籍，成员是一个以Book类元素为对象的向量
 * 函数add用来添加书籍，如果ISSN重复，就算添加失败，否则成功
 * 对add的重载是用户输入书籍信息，也是用ISSN来进行判断
 * get方法是打印书架中的所有书，通过循环调用book的print方法来实现
 */
class Bookshelf {
    private Vector<Book> books = new Vector<>();
    void add(String name, String author, String press, String ISSN, String date, String page, String summary) {
        Book book = new Book(name,author,press,ISSN,date,page,summary);
        int cnt = 0;
        for (Book i:books)
        {
            if ( i.getISSN().equals(ISSN) ) {
                break;
            }
            ++cnt;
        }
        if (cnt==books.size()){
            System.out.println(name+" is added successfully!");
            books.add(book);
        }
        else
            System.out.println("False, "+name+" already exists!");
    }
    void add() {
        String name, author, press, ISSN, date, page, summary;
        Scanner in = new Scanner(System.in);
        System.out.print("name: ");
        name = in.next();
        System.out.print("author: ");
        author = in.next();
        System.out.print("press: ");
        press = in.next();
        System.out.print("ISSN: ");
        ISSN = in.next();
        System.out.print("date: ");
        date = in.next();
        System.out.print("page: ");
        page = in.next();
        System.out.print("summary: ");
        summary = in.next();
        Book book = new Book(name,author,press,ISSN,date,page,summary);
        int cnt = 0;
        for (Book i:books)
        {
            if ( i.getISSN().equals(ISSN) ) {
                break;
            }
            ++cnt;
        }
        if (cnt==books.size()){
            System.out.println(name+" is added successfully!");
            books.add(book);
        }
        else
            System.out.println("False, "+name+" already exists!");
    }
    void get() {
        for (int i = 0; i < books.size(); i++)
        {
            books.get(i).print();
        }
    }
    void search(String book_name) {
        int cnt = 0;
        for (Book i:books) {
            if ( i.getName().substring(0,book_name.length()).equals(book_name)) {
                cnt++;
                System.out.print("Found "+cnt+": ");
                i.print();
            }
        }
        if (cnt == 0) {
            System.out.println("Not Found!");
        }
    }
    void remove(String ISSN) {
        int cnt = 0;
        for (Book i: books) {
            if ( i.getISSN().equals(ISSN) ) {
                books.remove(i);
                System.out.println("Remove successfully!");
                break;
            }
            else cnt++;
        }
        if (cnt == books.size()) {
            System.out.println("This book does not exist!");
        }
    }
}

public class test3 {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.add("中国大百科全书","3","1","2","1","12","1");
        bookshelf.add("中国大百科全书","3","1","2","1","12","1");
        bookshelf.add("中国少年儿童百科全书","3","1","3","1","12","1");
//        bookshelf.add();
        bookshelf.search("中国大");
        bookshelf.get();
    }
}