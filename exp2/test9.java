package exp2;

import java.util.Scanner;

//(1)	�ڿ���̨����������n�����1��n֮��������������ڿ���̨�������Щ������Ҫ��ÿ����ʾ5��������
public class test9 {
    public static void main(String args[]) {
        int n;
        int cnt = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            if (isPrimer(i)) {
                cnt++;
                System.out.print(i + "  ");
                if (cnt%5 == 0) {
                    System.out.println();
                }
            }
        }
    }
    private static boolean isPrimer(int number) {
        boolean flag = true;
        if (number == 1) {
            return false;
        }
        else {
            for (int i = 2; i < number; i++) {
                if (number%i==0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}