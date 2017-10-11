/**
 * Created by kashingliu on 2017/9/19.
 */
public class yanghui {
    static int fac;
    static int factor(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
    static void main() {
        int n = 3;
        int a[][] = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                a[i][j] = factor(i)/factor(j);
            }
        }
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                System.out.print(a[i][j]);
            }
        }
    }
}
