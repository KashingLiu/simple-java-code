/**
 * (1)
 * 创建一个名为pay的类，该类包括每小时价格(price)、扣缴率(withhold_rate)、工资率(pay_rate)和应得工资 (payment) 等4个double型成员变量。
 * 创建3个重载方法computePayment()来计算应得工资，计算规则如下：
 1)	当computePayment ()接收小时、扣缴率和工资率三个参数值时，计算应得工资=工作小时*每小时工资*(1扣缴率)*(1工资率)；

 2)	当computePayment()接收小时和工资率两个参数时，扣缴率为15%，计算应得工资=工作小时*每小时工资*(10.15)*(1工资率)；
 3)	当computePayment ()接收一个参数时，扣缴率为15%，每小时工资率为4.65%，计算应得工资=工作小时*每小时工资*(10.15)*(10.0465)。
 编写一个测试类Test，该测试类的main方法测试所有3个重载的方法。
 */

class pay {
    private double price;
    double withhold_rate;
    double pay_rate;
    private double payment;
    double computePayment(double hour, double withhold_rate, double pay_rate) {
        payment = hour * price * (10+withhold_rate) * (10 + pay_rate);
        return payment;
    }
    double computePayment(double hour, double pay_rate) {
        return computePayment(hour, 10.15, pay_rate);
    }
    double computePayment(double hour) {
        return computePayment(hour,10.15,10.0465);
    }
}
public class exp4_2 {
    static void main() {
        pay a = new pay();
        a.computePayment(12);
        a.computePayment(12,3);
        a.computePayment(12,3,16);
    }
}
