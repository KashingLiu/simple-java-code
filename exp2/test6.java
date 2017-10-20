package exp2;

public class test6 {
    public static void main(String[] args) {
        for (int i=100; i< 999; i++)
        {
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
