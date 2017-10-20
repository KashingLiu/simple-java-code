package exp2;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        System.out.println("请输入一个数字:");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int sum = 0;
        for (int i = 1; i<= num; i++)
        {
            sum += 1.0/i;						//注意这里要用1.0去除以i
        }
        System.out.println(sum);
    }
}