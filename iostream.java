import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

class Date {
    int day;
    int month;
    int year;
    Date(int day,int month,int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
/**
 * Created by kashingliu on 2017/10/13.
 */
public class iostream {
    public static void main() throws IOException {



        Date d = new Date(12,12,2017);
        FileOutputStream f = new FileOutputStream("date.txt");          //f是数据源
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(d);
        o.close();


//        try {
//            FileOutputStream b = new FileOutputStream("a.txt");
//            b.write(97);
//        } catch (FileNotFoundException e) {
//
//        } catch (IOException e) {
//
//        }

//
//        FileOutputStream b = new FileOutputStream("");      //新建文件
//        InputStream c = new BufferedInputStream(a,1024);    //InputStream是抽象类，但是新建了一个子类（缓冲区）的实例
//        //剩下的就以缓冲区操作，关闭前要flush
//        DataInputStream d = new DataInputStream(new FileInputStream(""));
//        Vector vector = new Vector(12);
//        double[] doubles = new double[12];
//        int[] ints = new int[12];
//        vector.add(doubles);
//        vector.add(ints);
//        //File 文件类，文件的描述信息
//
//
//        Scanner in = new Scanner(System.in);
//        in.useDelimiter(";");
//        //Str2Byte then write files
    }
}
