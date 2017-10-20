package ThreadTest;

/**
 * Created by kashingliu on 2017/10/17.
 */
public class simpletest1 {
    static ThreadClass1 firstThread;
    static ThreadClass2 secondThread;
    static void main() {
        firstThread = new ThreadClass1();
        secondThread = new ThreadClass2();
        firstThread.start();
        secondThread.start();
    }
}

class ThreadClass1 extends Thread {
    public void run() {
        for (int i = 0; i< 5; i++) {
            System.out.println("No.1 sentence");
            try{
                sleep(100);
            } catch (InterruptedException e)
            {}
        }
    }
}

class ThreadClass2 extends Thread {
    public void run() {
        for (int j = 0; j < 5; j++) {
            System.out.println("No.2 sentence");
            try {
                sleep(100);
            } catch (InterruptedException e)
            {}
        }
    }
}
