import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


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
        JFrame frame = new JFrame("test2");
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
    private static void test3() {
        JFrame frame = new JFrame("test3");
        frame.getContentPane().setBackground(Color.lightGray);
        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        JButton button = new JButton("button");
        panel.add(button);
        panel.setLayout(new GridLayout());
        frame.add(panel,BorderLayout.CENTER);
        frame.setMinimumSize(new Dimension(120,100));
        frame.setSize(300,200);
        frame.setVisible(true);
    }

//    private static void test4() {
//        //创建框架、两个文本框、两个布局管理器
//        JFrame frame = new JFrame("test4");
//        JTextField printUp = new JTextField(4);
//        JTextField printDown = new JTextField(4);
//        JPanel num_and_button = new JPanel(new GridLayout(5,5));
//        JPanel print = new JPanel(new BorderLayout());
//
//        //顶上有两个文本框，下面有很多个按钮
//        printUp.setPreferredSize(new Dimension(1,34));
//        printDown.setPreferredSize(new Dimension(1,34));
//        Buttons buttons = new Buttons(num_and_button,printUp,printDown);
//        buttons.setListener();
//
//
//        //布局管理器的操作
//        print.add(printUp,BorderLayout.NORTH);
//        print.add(printDown, BorderLayout.SOUTH);
//
//        //框架的操作
//        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//        frame.add(print, BorderLayout.NORTH);
//        frame.add(num_and_button);
//        frame.setMinimumSize(new Dimension(400,300));
//        frame.setMaximumSize(new Dimension(400,300));
//        frame.setVisible(true);
//    }

//    private ActionListener al = new ActionListener(){
//        @Override
//        public void actionPerformed(ActionEvent e) {}
//        public void actionPerformed(ActionEvent e, JTextField jTextField, Buttons button) {
//            jTextField.setText(jTextField.getText()+ button.buttons.get(0).getText());
//        }
//    };

    public static void test5() {
        JFrame frame = new JFrame("test");
        JButton b = new JButton("Press me");

        frame.getContentPane().add(b, FlowLayout.CENTER);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.setMinimumSize(new Dimension(300,200));
                Dimension a = new Dimension(300,200);
                a.width = a.width + 50;
                frame.setSize(a);
                frame.getContentPane().add(new JButton("button"),FlowLayout.LEFT);
                frame.setVisible(true);
            }
        });
//        frame.pack();
        frame.setMinimumSize(new Dimension(300,200));
        frame.setVisible(true);
    }

    static void test6() {
        JFrame frame;
        JTextField tf;
        frame = new JFrame("Two listeners example");
        Container contentPane = frame.getContentPane();
        contentPane.add(new Label ("Click and drag the mouse"), BorderLayout.NORTH);
        tf = new JTextField(30);
        contentPane.add(tf,BorderLayout.SOUTH);

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void test7() {
        JFrame frame = new JFrame("test7");
        JPanel panel = new JPanel(new CardLayout());

    }
}

