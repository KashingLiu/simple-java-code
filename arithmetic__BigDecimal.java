/**
 * Created by kashingliu on 2017/9/21.
 */

import java.math.BigDecimal;

class arithmetic__BigDecimal {
    static void main() {
        BigDecimal a = BigDecimal.valueOf(1.2);
        BigDecimal b = BigDecimal.valueOf(2);
        int c = a.add(b).intValue();
        double d = a.add(b).doubleValue();
        double e = a.subtract(b).doubleValue();
        System.out.println(c);
        System.out.println(d);

//      a是一个精确的小数，与b做运算返回类型为BigDecimal类型，用a（实际上是BigDecimal）的一些方法可以计算a与b
//      例如a.add(b)是a+b，然后调用intValue方法可以把这个值转换成int型，转换成double也是同理的
    }
}
