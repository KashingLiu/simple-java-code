/**
 * Created by kashingliu on 2017/10/12.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// TwoListener类同时实现MouseMotionListener
// 和MouseListener两个接口
class TwoListener implements MouseMotionListener,MouseListener {
    private JFrame frame;
    private JTextField tf;

    public static void main()
    {
        TwoListener two = new TwoListener();
        two.go();
    }

    public void go()
    {
        frame = new JFrame("Two listeners example");
        Container contentPane = frame.getContentPane();
        contentPane.add(new Label ("Click and drag the mouse"), BorderLayout.NORTH);
        tf = new JTextField(30);
        contentPane.add(tf,BorderLayout.SOUTH);

        // 注册监听程序
        frame.addMouseMotionListener(this);
        frame.addMouseListener(this);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    //实现 MouseMotionListener接口中的方法
    public void mouseDragged (MouseEvent e)
    {	String s = "Mouse dragging:  X = "+ e.getX() + "Y = " + e.getY();
        tf.setText(s);
    }

    public void mouseMoved (MouseEvent e) {}

    //实现 MouseListener 接口中的方法
    public void mouseClicked (MouseEvent e) {}

    public void mouseEntered (MouseEvent e)
    {	String s = "The mouse entered";
        tf.setText(s);
    }

    public void mouseExited (MouseEvent e)
    {	String s = "The mouse has left the building";
        tf.setText(s);
    }

    public void mousePressed (MouseEvent e) {}
    public void mouseReleased (MouseEvent e) {}
}

