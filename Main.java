import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

//class Department implements Comparable {
//    private int id;
//    Department(int a) {
//        this.id = a;
//    }
//    public int compareTo(Object o) {
//        Department d = (Department) (o);
//        return this.id-d.id;
//    }
//    public String toString() {
//        return this.id+":";
//    }
//}
//abstract class A {
//    int a;
//    void test() { System.out.print("nihao"); }
//
//}
public class Main {

    public static void main(String[] args) {
//        正则表达式测试
        String a = "01*20-90/20";
        String[] b;
        String d;
        b = a.split("\\*|-|\\+|/",2);
        d = a.substring(b[0].length(),a.length());
        d = "01";
//        System.out.println();
        System.out.println(d);
        int e = Integer.parseInt(d);
        System.out.println("e:"+e);
        for (String c: b) {
            System.out.println(c);
        }


//        awt.main();
//        TwoListener.main();
//        int i = 0;
//        String a[] = {"nihao","a","b"};
//        while (i<4) {
//            try{
//                System.out.print(a[i]);
//            }
//            catch (ArrayIndexOutOfBoundsException e) {
//
//            }
//            i++;
//        }
//        awt.main();

//        Collection a = new LinkedList();
//        List it= new LinkedList();
//        for (int i = 0; i< 10; i++) {
//            it.add(i);
//        }
//        System.out.print(it.get(0));
//        A a = new A();
//        System.out.print(a.toString());
//        awt.main();
    }

}


