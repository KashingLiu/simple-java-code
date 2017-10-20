package exp2;
import java.util.Scanner;

public class test5 {
    private static int gcd(int a, int b) {
        if (b==0) return a;
        int r = a%b;
        return gcd(b,r);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int first_num = in.nextInt();
        System.out.println("请输入第二个数：");
        int second_num = in.nextInt();
        int gcd = gcd(first_num, second_num);
        System.out.println(gcd);
        int multi = first_num* second_num;
        System.out.println(multi/gcd);
    }
}
