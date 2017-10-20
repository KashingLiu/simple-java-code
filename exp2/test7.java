package exp2;

import java.util.Scanner;

public class test7 {
    public static void meisen() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 2; i < n; i++) {
            int sum = 0;
            for (int j = 1; j < (i/2)+1; j++) {
                if (i%j==0) {
                    sum+=j;
                }
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}
