import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kashingliu on 2017/9/14.
 */
class bubble {
    static void bubb() {
        System.out.print("请输入数组个数：");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.print("请输入数字：");
        int array[] = new int[n];
        for (int i = 0; i< array.length; i++) {
            array[i] = in.nextInt();
        }
        sort(array);
        for (int i=0;i < array.length; i++) {         //foreach在数组作为变量传递的时候不大好用
            System.out.println(array[i]);
        }
    }
    private static void sort(int[] arr) {
        int temp = 0;
        for (int j = 0; j< arr.length; j++) {
            for (int i = 0; i< arr.length-j-1; i++) {
                if (arr[i]>arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
}
