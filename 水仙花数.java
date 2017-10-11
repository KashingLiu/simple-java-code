/**
 * Created by kashingliu on 2017/9/14.
 */
public class 水仙花数 {
    public static void shuixianhua() {
        for (int i=100; i< 999; i++) {
            int a = i%10;
            int b = i/100;
            int c = (i-a-(b*100))/10;
            if (a*a*a+b*b*b+c*c*c == i)
            {
                System.out.println(i);
            }
        }
    }
}
