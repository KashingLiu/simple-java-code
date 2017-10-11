import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class awt {
    static void main() {
//        JFrame frame = new JFrame("test");
//        JButton button = new JButton("press me");
//        Container contentPane = frame.getContentPane();
//        contentPane.setLayout(new BorderLayout());
//        contentPane.add(button, BorderLayout.CENTER);
//        JLabel label = new JLabel("nihao");
//        frame.add(label,12);
//        frame.setContentPane(contentPane);
//        frame.setSize(300,300);
//        frame.setVisible(true);
        test1();
    }
    private static void test1() {
        JFrame frame = new JFrame("test1");
        JButton button = new JButton("press me");
        frame.getContentPane().add(button,BorderLayout.CENTER);
        frame.setMinimumSize(new Dimension(120,100));       //设置frame的最小大小
        frame.pack();
        frame.setVisible(true);
    }
    private static void test2() {
        JFrame frame = new JFrame("test1");
        JButton button = new JButton("button1");
        JButton button1 = new JButton("button2");
        JPanel myPane = new JPanel();
        myPane.setLayout(new BorderLayout());
        myPane.add(button, BorderLayout.SOUTH);
        myPane.add(button1, BorderLayout.NORTH);
        frame.setContentPane(myPane);
        frame.setMinimumSize(new Dimension(120,100));       //设置frame的最小大小
        frame.pack();
        frame.setVisible(true);
    }
}
