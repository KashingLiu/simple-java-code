import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Mydialog extends JOptionPane {

}
public class Jdialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField name;
    private JPasswordField password;

    public Jdialog() {
//        JOptionPane optionPane = new JOptionPane();
//        JOptionPane.showInputDialog("hello");
        name = new JTextField();
        password = new JPasswordField();

        setContentPane(contentPane);
//        add(name, BorderLayout.NORTH);
//        add(password, BorderLayout.SOUTH);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
//        getRootPane().add(name);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

//         call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

//         call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Jdialog dialog = new Jdialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
