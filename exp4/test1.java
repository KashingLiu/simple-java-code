package exp4;
import java.util.Scanner;

class Triangle {
    private double sideA,sideB,sideC;        //边
    private double round;                    //周长
    private double acreage;                  //面积
    boolean isTriangle;
    Triangle(double sideA, double sideB,double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        isTriangle = this.sideA+this.sideB>this.sideC && this.sideB+this.sideC>this.sideA && this.sideA+this.sideC>this.sideB;
    }
    void changeSide(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        isTriangle = this.sideA+this.sideB>this.sideC && this.sideB+this.sideC>this.sideA && this.sideA+this.sideC>this.sideB;
    }
    void changeSide() {
        Scanner in = new Scanner(System.in);
        System.out.print("sideA: ");
        sideA = in.nextDouble();
        System.out.print("sideB: ");
        sideB = in.nextDouble();
        System.out.print("sideC: ");
        sideC = in.nextDouble();
    }
    double getSideA() {
        return sideA;
    }
    double getSideB() {
        return sideB;
    }
    double getSideC() {
        return sideC;
    }
    double getRound() {
        return sideA+sideB+sideC;
    }
    double getAcreage() {
        double p = getRound()/2.0;
        return Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
    }
}

class Trapezoid {
    private double upside, downside, height, acreage;
    Trapezoid(double upside, double downside,double height) {
        this.upside = upside;
        this.downside = downside;
        this.height = height;
    }
    double getAcreage() {
        return (upside+downside)*height/2.0;
    }
}

class Circle {
    private double radius, round, acreage;
    Circle(double radius) {
        this.radius = radius;
        round = 2*Math.PI*this.radius;
        acreage = Math.PI*radius*radius;
    }
    double getRound() {
        return round;
    }
    double getAcreage() {
        return acreage;
    }
}

public class test1 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3,4,5);
        System.out.println(triangle.getRound());
        System.out.println(triangle.getAcreage());

        Trapezoid trapezoid = new Trapezoid(3,7,4);
        System.out.println(trapezoid.getAcreage());

        Circle circle = new Circle(3);
        System.out.println(circle.getRound());
        System.out.println(circle.getAcreage());
    }
}




//如果不是三角形就不应该有各个功能，这个怎么办？

//,static变量是 所有创建的类都共享的，如果我用static就区分不出来各个类的static的属性

//    boolean isTriangle() {
////        if (sideA+sideB>sideC) {
////            return true;
////        } else return false;
//        return (sideA+sideB>sideC||sideB+sideC>sideA||sideA+sideC>sideB);
//    }

//  sout

//    void change_side(double sideA) {
//        this.sideA = sideA;
//        isTriangle = sideA+sideB>sideC && sideB+sideC>sideA && sideA+sideC>sideB;
//    }
//    void change_side(double sideB,double sideC) {
//        this.sideB = sideB;
//        this.sideC = sideC;
//        isTriangle = sideA+sideB>sideC && sideB+sideC>sideA && sideA+sideC>sideB;
//    }
//    如果我只想修改其中的某两个参数，还忘了第三个参数该怎么办？
//    void change_side(double sideA,double sideB) {
//        this.sideB = sideB;
//        this.sideC = sideC;
//        isTriangle = sideA+sideB>sideC && sideB+sideC>sideA && sideA+sideC>sideB;
//    }