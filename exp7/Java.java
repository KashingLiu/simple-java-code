package exp7;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



class JProcessBarDemo extends JFrame{
    private JProgressBar processBar;
    private JProgressBar processBar2;

    public JProcessBarDemo(){
        setTitle("Progress");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 100);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置内容面板边框
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        processBar = new JProgressBar();
        processBar.setStringPainted(true);// 设置进度条上的字符串显示，false则不能显示
        processBar.setBackground(Color.GREEN);
        processBar2 = new JProgressBar();
        processBar2.setStringPainted(true);
        processBar2.setBackground(Color.GREEN);

        // 创建线程显示进度
        Thread a = new Thread(){
            public void run(){
                setPriority(10);
                for (int i = 0; i < 101; i++) {
                    try {
                        Thread.sleep(200);  //   让当前线程休眠0.2ms
                    } catch (InterruptedException e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                    processBar.setValue(i);	// 设置进度条数值
                }
                processBar.setString("OK");// 设置提示信息
            }
        };


        Thread b = new Thread() {
            public void run() {
                setPriority(1);
                for (int i = 0; i < 101; i++) {
                    try {
                        Thread.sleep(400);  //   让当前线程休眠0.4ms
                    } catch (InterruptedException e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                    processBar2.setValue(i);	// 设置进度条数值
                }
                processBar2.setString("OK");// 设置提示信息
            }
        };
        a.start();
        b.start();

        contentPane.add(processBar);
        contentPane.add(processBar2);
    }

    public static void main(String[] args){
        JProcessBarDemo House = new JProcessBarDemo();
        House.setVisible(true);
    }
}

