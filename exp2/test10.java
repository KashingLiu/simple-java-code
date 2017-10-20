package exp2;

import java.util.Scanner;

public class test10 {
    private static int cnt = 0;
    private static void per(int[] a, int i) {
        if (i == a.length) {
            for (int m = 0; m< a.length; m++) {
                cnt++;
                System.out.print(a[m]+" ");
                if ( cnt % i==0) {
                    System.out.print("\b;");
                }
                if ((cnt)%(2*i)==0) {
                    System.out.println();
                }
            }
        } else {
            for (int j = i; j < a.length; j++) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                per(a, i+1);
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i+1;
        }
        per(a,0);
    }
}
