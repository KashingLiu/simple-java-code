//class pailie {
//    static int cnt = 0;
//    static void per(int[] a, int i) {
//        if (i<0||i>a.length) {
//            return;
//        }
//        if (i == a.length) {
//            for (int m = 0; m< a.length; m++) {
//                cnt++;
//                System.out.print(a[m]+" ");
//                if ( cnt % i==0) {
//                    System.out.print("\b;");
//                }
//                if ((cnt)%(2*i)==0) {
//                    System.out.println();
//                }
//
//            }
//        }
//        else {
//            for (int j = i; j < a.length; j++) {
//                int temp = a[j];
//                a[j] = a[i];
//                a[i] = temp;
//                per(a, i+1);
//                temp = a[j];
//                a[j] = a[i];
//                a[i] = temp;
//            }
//        }
//    }
//}
