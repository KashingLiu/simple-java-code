package exp4;

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
public class test2 {
    static void main() {
        pay a = new pay();
        a.computePayment(12);
        a.computePayment(12,3);
        a.computePayment(12,3,16);
    }
}
