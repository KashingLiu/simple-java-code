import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kashingliu on 2017/10/14.
 */
public class newww {
    private JPanel mypanel;
    private JButton button1;
    private JButton button2;
    private JPanel cardpanel;
    private JPanel buttonpanel;
    private JPanel mypanel1;
    private JPanel mypanel2;
    void go() {
        CardLayout a = new CardLayout();
        cardpanel.setLayout(a);
        mypanel1.setBackground(Color.ORANGE);
        mypanel2.setBackground(Color.green);

        cardpanel.add(mypanel1,"first");
        cardpanel.add(mypanel2,"second");
        cardpanel.show(true);
        buttonpanel.add(button1);
        buttonpanel.add(button2);

        mypanel.add(buttonpanel);
        mypanel.add(cardpanel);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
