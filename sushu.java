import java.util.Scanner;
import java.util.Vector;

import static java.lang.Math.sqrt;

class sushu {
    static void ss() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 2; i < n; i++) {
            label1:for (int j = 2; j < sqrt(n); j++) {
                if (i%j == 0) {
                    continue label1;
                }
                System.out.println(i);
            }

        }
    }
}

//class test {
//     static void neww() {
//         for ( int i = 2; i <= 100; ++i ) {
//            int j;
//            for ( j = 2; j < i; j++ ){
//                if ( i % j == 0 ) break;
//            System.out.print( i + " " );}
//        }
//    }
//}
