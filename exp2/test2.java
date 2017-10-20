package exp2;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        System.out.println("请输入一个数字：");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        double sum = 0;
        for (int i = 1; i<= num; i++)
        {
            sum += 1.0/(2*i-1);
        }
        System.out.println(sum);
    }
}
