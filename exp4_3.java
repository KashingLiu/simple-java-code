/*
电话品牌：TCL
电话号码：5687506
通话时间：130.0分钟
费率：    0.2元/分钟
花费总计：36.0元
 */
class Telephone {
    protected String brand;
    protected long number;
    protected double dialedTime;
    protected double rate;
    Telephone(String brand,long number,double dialedTime,double rate) {
        this.brand = brand;
        this.number = number;
        this.dialedTime = dialedTime;
        this.rate = rate;
    }
    double callCost() {
        return rate * dialedTime;
    }
    void display() {
        System.out.println("电话品牌："+brand);
        System.out.println("电话号码："+number);
        System.out.println("通话时间："+dialedTime);
        System.out.println("费率："+rate);
        System.out.println("花费总计："+this.callCost());
    }
}

class MobilePhone extends Telephone {
    private String network;
    private double receivedTime;
    MobilePhone(String brand,long number,double dialedTime,double rate,String network,double receivedTime) {
        super(brand,number,dialedTime,rate);
        this.network = network;
        this.receivedTime = receivedTime;
    }
    @Override
    double callCost() {
        return super.callCost();
    }
    //重写的时候如果没有“真正”的重写，则输入的一部分数据按照父类的方法计算，但是另外一部分数据被忽略

    @Override
    void display() {
        System.out.println("电话品牌："+brand);
        System.out.println("电话号码："+number);
        System.out.println("网络："+network);
        System.out.println("主叫时间："+dialedTime);
        System.out.println("被叫时间："+receivedTime);
        System.out.println("费率："+rate);
        System.out.println("花费总计："+(dialedTime+0.5*receivedTime)*rate);
    }
}

public class exp4_3 {
    static void main() {
        Telephone telephone = new Telephone("TCL",123,130.0,0.2);
        telephone.display();
        MobilePhone mobilePhone = new MobilePhone("SAMSUNG",1234,80,0.4,"4G",120);
        mobilePhone.display();
        System.out.println(mobilePhone.callCost());
    }
}
