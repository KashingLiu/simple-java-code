package exp3;
import java.util.Random;

public class test1 {
    public static void main(String[] args) {
        int[] a = new int[1000];
        Random random = new Random();
        for (int i=0; i<1000;i++ ) {
            a[i] = random.nextInt(100)+1;
        }
        int[] b = new int[101];         //这里是随机数的取值范围
        for ( int i = 0; i<1000; i++)     //要调查的那个数组，有几个元素
            b[a[i]]++;
        for (int j = 1; j<101; j++) {
            System.out.println("j"+j+"b[j]"+b[j]);
        }
    }
}