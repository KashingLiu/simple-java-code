package exp2;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int first_num = in.nextInt();
        System.out.println("请输入第二个数：");
        int second_num = in.nextInt();
        int max = first_num;
        if (first_num < second_num)
        {
            max = second_num;
        }
        System.out.println(max);
    }
}
