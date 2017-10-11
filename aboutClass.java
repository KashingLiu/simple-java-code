/**
 *
 */
class aboutClass {
    static void aboutclass() {
        Person a = new Person(2);
        a.tell_age();
        Student b = new Student(2,3);
        b.tell_age();
    }
}

class Person {
    private int age;
    void tell_age() {
        System.out.println(age);
    }
    Person(int a) {
        this.age = a;
    }
}

class Student extends Person {
    Student(int b) {
        super(b);
    }
    Student(int b, int c) {
        super(b);
        System.out.println(c);
    }
}