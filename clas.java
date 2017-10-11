import java.util.Scanner;

/**
 *
 */


//斐波那契数列写不好了
//int[] arr = new int[20];
//        arr[0] = 0;
////        int sum = 0;
//        for (int i = 0; i<19; i++)
//        {
//        arr[i+1] = i+arr[i]-1;
//        }
//        for (int j:arr) {
//        System.out.println(j);
//        }

class clas {
    private static int swap(int i ,int j) {
        i = i+j;
        j = i-j;
        i = i-j;
        return i;
    }
    static void main() {

        for (int j = 1; j< 10; j++) {
            for (int i = 0; i< j; i++) {
                System.out.print("*");
            }
            System.out.println();
        }


//        Object i[];
//        i = new clas[2];
//        int a[];
//        int[] b = new int[20];

//        int a[] = new int[20];
//        for (int i = 0; i < a.length; i++)
//            a[i] = (int)Math.random()*10;
//        int a[][] = new int[2][3];    //a[0]有3
//        System.out.println(a[0].length);

        int a[] = new int[4];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        int temp=0;
        for (int j = 0; j<3; j++) {
            temp = a[j];
            a[j] = a[j+1];
            a[j+1] = temp;
            System.out.println("这是一组");
            System.out.println(a[0]);
            System.out.println(a[1]);
            System.out.println(a[2]);
            System.out.println(a[3]);
        }



//        int[] arr = {1,2,3,2,5,2};
//        for (int i:arr) {
//            System.out.println(i);
//        }
//        Scanner in = new Scanner(System.in);
//        int x = in.nextInt();
//        int y = in.nextInt();
//        if (x < 0) {
//
//        }
//        else if (x==0) {
//
//        }
//        else {
//
//        }

//        switch (x+"1") {                    //x、case为int或者char或者计算出二者的一个表达式，注意对应
//            case 1+2:
//                y = 100;
//                break;                      //break一定要加
//            case 2: y = 10;
//
//        }
//        int day = 0;
//        if ((y%4==0 && y%100!=0)||y%400==0) {
//            y = 100;
//        }
//        else {
//            y = 101;
//        }
//        switch ()
    }
}