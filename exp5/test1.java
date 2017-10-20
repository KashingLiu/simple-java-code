package exp5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

public class test1 {
    public static void main(String[] args) {
        //创建框架、两个文本框、两个布局管理器
        JFrame frame = new JFrame("test4");
        JTextField printUp = new JTextField(4);
        JTextField printDown = new JTextField(4);
        JPanel num_and_button = new JPanel(new GridLayout(5,5));
        JPanel print = new JPanel(new BorderLayout());

        //顶上有两个文本框，下面有很多个按钮
        printUp.setPreferredSize(new Dimension(1,34));
        printDown.setPreferredSize(new Dimension(1,34));
        Buttons buttons = new Buttons(num_and_button,printUp,printDown);
        buttons.setListener();

        //布局管理器的操作
        print.add(printUp,BorderLayout.NORTH);
        print.add(printDown, BorderLayout.SOUTH);

        //框架的操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(print, BorderLayout.NORTH);
        frame.add(num_and_button);
        frame.setMinimumSize(new Dimension(400,300));
        frame.setMaximumSize(new Dimension(400,300));
        frame.setVisible(true);
    }
}

class Buttons {
    static int flag = 0;
    private Vector<JButton> buttons = new Vector<>(23);
    private JPanel inpanel = new JPanel();
    private JTextField printUp_in = new JTextField();
    private JTextField printDown_in = new JTextField();
    private String expression;
    private void getMath() {
        expression = printUp_in.getText();
    }
    private void clear(JTextField tf1,JTextField tf2) {
        tf1.setText("");
        tf2.setText("");
    }
    private void clear(JTextField tf1) {
        tf1.setText("");
    }
    private void to_sin() {
        int firstsin = expression.indexOf("sin");
        double first_sin_out;
        String out[] = expression.split("sin");
        String fine;
        if (!expression.substring(firstsin+3,firstsin+4).equals("(")) {
            Vector<Integer> v = new Vector<>(4);
            String b = expression.substring(firstsin+3, expression.length());
            if (b.contains("+"))
                v.add(b.indexOf("+"));
            if (b.contains("-"))
                v.add(b.indexOf("-"));
            if (b.contains("*"))
                v.add(b.indexOf("*"));
            if (b.contains("/"))
                v.add(b.indexOf("/"));
            Object ob = Collections.min(v);
            String num = b.substring(0,(int)ob);
            first_sin_out = Math.sin(Integer.valueOf(num));
            expression = out[0] + Double.toString(first_sin_out) +out[1];
//            System.out.println(first_sin_out);
        }
    }
    void setListener() {
        Calculator cal = new Calculator();
        buttons.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = "";
                clear(printDown_in,printUp_in);
                cal.clean();
                flag = 0;
            }
        });
        for (JButton i:buttons.subList(2,24)){
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (flag==1) {
                        clear(printDown_in,printUp_in);
                    }
                    flag = 0;
                    printUp_in.setText(printUp_in.getText()+i.getText());
                }
            });
        }
        buttons.get(24).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                getMath();
                cal.clean();
                String a = cal.exec(expression);
                printDown_in.setText(a);
                flag = 1;
                }catch (Throwable throwable) {
                    if (throwable == cal.error()) {
                        clear(printDown_in,printUp_in);
                    }
                }
            }
        });
    }
    Buttons(JPanel outpanel, JTextField printUp_out, JTextField printDown_out) {
        inpanel = outpanel;
        printUp_in = printUp_out;
        printDown_in = printDown_out;
        buttons.add(new JButton("AC"));
        buttons.add(new JButton("<-"));
        buttons.add(new JButton("("));  //2
        buttons.add(new JButton(")"));
        buttons.add(new JButton("/"));
        buttons.add(new JButton("sin"));
        buttons.add(new JButton("7"));
        buttons.add(new JButton("8"));
        buttons.add(new JButton("9"));
        buttons.add(new JButton("*"));
        buttons.add(new JButton("cos"));
        buttons.add(new JButton("4"));
        buttons.add(new JButton("5"));
        buttons.add(new JButton("6"));
        buttons.add(new JButton("-"));
        buttons.add(new JButton("tan"));
        buttons.add(new JButton("1"));
        buttons.add(new JButton("2"));
        buttons.add(new JButton("3"));
        buttons.add(new JButton("+"));
        buttons.add(new JButton(""));
        buttons.add(new JButton("0"));
        buttons.add(new JButton("."));
        buttons.add(new JButton(""));
        buttons.add(new JButton("="));  //24
        for (JButton i : buttons) {
            inpanel.add(i);
        }
    }
}