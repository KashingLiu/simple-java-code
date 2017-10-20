import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class TwoStatesButtonDemo2
{
    JFrame frame = new JFrame ("Two States Button Demo 2");
    JRadioButton rb4 = new JRadioButton("JRadioButton 4");
    JRadioButton rb5 = new JRadioButton("JRadioButton 5");
    JRadioButton rb6 = new JRadioButton("JRadioButton 6");

    JTextArea ta = new JTextArea(); //用于显示结果的文本区

    public static void main(String args[])
    {	TwoStatesButtonDemo2 ts = new TwoStatesButtonDemo2();
        ts.go();
    }

    public void go()
    {
        rb4.setBorderPainted(false);
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel pa = new JPanel();
        JPanel pb = new JPanel();


        p4.add(rb4);
        p4.add(rb5);
        p4.add(rb6);


        //创建ButtonGroup按钮组，并在组中添加按钮
        ButtonGroup group2 = new ButtonGroup();
        group2.add(rb4);
        group2.add(rb5);
        group2.add(rb6);

        JScrollPane jp = new JScrollPane(ta);
        p5.setLayout(new BorderLayout());
        p5.add(jp);


        ActionListener al = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JRadioButton rb = (JRadioButton) e.getSource();	//取得事件源
                if (rb == rb4)
                {	ta.append("\n You selected Radio Button 4 "+ rb4.isSelected());
                } else if (rb == rb5)
                {	ta.append("\n You selected Radio Button 5 "+ rb5.isSelected());
                } else
                {	ta.append("\n You selected Radio Button 6 "+ rb6.isSelected());
                }
        }
        };


        rb4.addActionListener(al);
        rb5.addActionListener(al);
        rb6.addActionListener(al);


        pb.setLayout(new GridLayout(0,1));
        pb.add(p4);

        Container cp = frame.getContentPane();
        cp.setLayout(new GridLayout(0,1));
        cp.add(pa);
        cp.add(pb);
        cp.add(p5);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}