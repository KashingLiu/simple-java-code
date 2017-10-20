package exp2;

import java.util.Scanner;


public class test8 {
    public static void main(String[] args) {
        System.out.print("请输入数字个数：");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.print("请输入数字：");
        int array[] = new int[n];
        for (int i = 0; i< array.length; i++) {
            array[i] = in.nextInt();
        }
        sort(array);
        for (int i=0;i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    private static void sort(int[] arr) {
        int temp = 0;
        for (int j = 0; j< arr.length; j++) {
            for (int i = 0; i< arr.length-j-1; i++) {       //在第一次排序的时候已经把最大的数字排到了队尾，所以下一次排序的时候只需要排减1次
                if (arr[i]>arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
}
