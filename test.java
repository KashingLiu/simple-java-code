//程序8-8：
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CardLayoutDemo
{
    public static void main (String args[])
    {
        CardLayoutDemo card = new CardLayoutDemo();
        card.test3();
    }

    private static void go()
    {
        JPanel p1,p2,p3,p4,p5;
        JButton l1,l2,l3,l4,l5;
        JFrame frame = new JFrame ("Card Test");
        CardLayout myCard = new CardLayout();
        JPanel one = new JPanel(new BorderLayout());
        JPanel two = new JPanel(myCard);

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();


        l1 = new JButton("This is the first JButton");
        p1.setBackground(Color.yellow);
        l2 = new JButton("This is the second JButton");
        p2.setBackground(Color.green);
        l3 = new JButton("This is the third JButton");
        p3.setBackground(Color.magenta);
        l4 = new JButton("This is the fourth JButton");
        p4.setBackground(Color.white);
        l5 = new JButton("This is the fifth JButton");
        p5.setBackground(Color.cyan);


        one.add(l1,BorderLayout.NORTH);
        one.add(l2,BorderLayout.SOUTH);
        one.add(l3,BorderLayout.EAST);
        one.add(l4,BorderLayout.WEST);
        one.add(l5,BorderLayout.CENTER);



        //将每个JPanel作为一张卡片加入frame的内容窗格
        two.add(p1, "First");
        two.add(p2, "Second");
        two.add(p3, "Third");
        two.add(p4, "Fourth");
        two.add(p5, "Fifth");

        l1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCard.show(two,"First");
            }
        });
        l2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCard.show(two,"Second");
            }
        });
        l3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCard.show(two,"Third");
            }
        });
        l4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCard.show(two,"Fourth");
            }
        });
        l5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCard.show(two,"Fifth");
            }
        });
        //显示第一张卡片
        frame.add(one,BorderLayout.NORTH);
        frame.add(two,BorderLayout.SOUTH);
        frame.setMinimumSize(new Dimension(900,600));
        myCard.show(two, "First");
//        frame.setSize(300, 200);
        frame.show();
    }

    private static void test2() {
        JFrame frame = new JFrame("button");
        ImageIcon imageIcon = new ImageIcon("/Users/kashingliu/Desktop/gray.png");

//        JLabel a = new JLabel(imageIcon);
        JButton button = new JButton(imageIcon);
        button.setBorderPainted(false);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                button.setIcon(new ImageIcon("/Users/kashingliu/Desktop/black.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setIcon(new ImageIcon("/Users/kashingliu/Desktop/white.png"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button,BorderLayout.CENTER);

//        panel.add(button);
//        frame.add(button,BorderLayout.NORTH);
//        .add(a,BorderLayout.CENTER);
        frame.add(panel);

        frame.setMinimumSize(new Dimension(500,500));
//        frame.pack();
        frame.setVisible(true);
    }

    JFrame frame = new JFrame();
    ImageIcon im1 = new ImageIcon("/Users/kashingliu/Downloads/tsg/date1.png");
    ImageIcon im2 = new ImageIcon("/Users/kashingliu/Downloads/tsg/tsg1.png");
    JRadioButton button1 = new JRadioButton(im1);
    JRadioButton button2 = new JRadioButton(im2);
    JRadioButton button3 = new JRadioButton("test");
    ButtonGroup group = new ButtonGroup();
    JTextField tf = new JTextField(12);

    private void test3() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        button1.setBorderPainted(false);
        button2.setBorderPainted(false);
        button3.setBorderPainted(false);


        button1.setBounds(0,0,50,50);
        button2.setBounds(60,0,50,50);
        button3.setBounds(100,100,40,40);


        group.add(button1);
        group.add(button2);
        group.add(button3);


        tf.setBounds(120,50,80,20);
        ItemListener il = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (button1.isSelected()) {
                    button2.setIcon(im2);
                }
                else if (button2.isSelected()) {
                    button1.setIcon(im1);
                }
            }
        };
        MouseListener ml = new MouseListener() {
            JRadioButton rb = new JRadioButton();

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                rb = (JRadioButton)e.getSource();
                if (rb == button1) {
                    button1.setIcon(new ImageIcon("/Users/kashingliu/Downloads/tsg/date2.png"));
                }
                else if (rb == button2) {
                    ImageIcon im = new ImageIcon("/Users/kashingliu/Downloads/tsg/tsg2.png");
                    button2.setIcon(im);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                rb = (JRadioButton)e.getSource();
                if (rb == button1) {
                    button1.setIcon(new ImageIcon("/Users/kashingliu/Downloads/tsg/date3.png"));
                }
                else if (rb == button2) {
                    ImageIcon im = new ImageIcon("/Users/kashingliu/Downloads/tsg/tsg3.png");
                    button2.setIcon(im);
                }
            }


            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };


        button1.addMouseListener(ml);
        button2.addMouseListener(ml);
        button1.addItemListener(il);
        button2.addItemListener(il);


//        Calculator cal = new Calculator();

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(tf);
        Container cp = frame.getContentPane();
        cp.add(panel,BorderLayout.CENTER);
        frame.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
