package exp2;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        System.out.println("请输入一个数字：");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int sum = 1;
        for (int i = 1; i<= num; i++)
        {
            sum *= i;
        }
        System.out.println(sum);
    }
}
