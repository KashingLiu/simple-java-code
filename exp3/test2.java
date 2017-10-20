package exp3;

import java.util.Scanner;

//(1)	设计一个矩阵乘法程序，输入两个矩阵可以计算出它们的乘积。
public class test2 {
    public static void main(String[] args) {
        int row_fir;
        int col_fir;
        int row_sec;
        int col_sec;

        Scanner in = new Scanner(System.in);
        System.out.print("请输入第一个矩阵的行数：");
        row_fir = in.nextInt();
        System.out.print("请输入第一个矩阵的列数：");
        col_fir = in.nextInt();
        row_sec = col_fir;
        System.out.print("请输入第二个矩阵的列数：");
        col_sec = in.nextInt();

        double first[][] = new double[row_fir][col_fir];
        double second[][] = new double[row_sec][col_sec];
        double result[][] = new double[row_fir][col_sec];
        for (int i = 0; i < row_fir; i++) {
            System.out.println("请输入第一个矩阵第"+i+"行的每个值：");
            for (int j = 0; j < col_fir; j++) {
                first[i][j] = in.nextDouble();
            }
        }

        for (int i = 0; i < row_sec; i++) {
            System.out.println("请输入第二个矩阵第"+i+"行的每个值：");
            for (int j = 0; j < col_sec; j++) {
                second[i][j] = in.nextDouble();
            }
        }

        for (int j = 0; j < row_fir; j++) {
            for (int k = 0; k < col_sec; k++) {
                for (int m = 0; m < row_fir; m++) {
                    result[j][k] += first[j][k] * second[k][j];
                }
            }
        }

        for (int i = 0; i < row_fir; i++) {
            for (int j = 0; j < col_sec; j++) {
                System.out.print(result[i][j]+"  ");
            }
            System.out.println();
        }
    }
}