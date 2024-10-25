package demo251024;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * MyFrame
 *
 * @author hasu
 */
public class MyFrame2 extends JFrame {

    class MyActionListener extends WindowAdapter implements ActionListener {

        @Override
        public void windowClosing(WindowEvent e) {
//            super.windowClosing(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            if (JOptionPane.showConfirmDialog(null, "close ?", "confirm ...closing", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "No");
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object objs[] = {"Đóng", "Không đóng"};
            if (JOptionPane.showOptionDialog(
                    null,
                    "close ?",
                    "confirm ..." + ((JButton) e.getSource()).getText(),
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    objs,
                    objs[1]
            ) == JOptionPane.YES_OPTION) {

//        if (JOptionPane.showConfirmDialog(this, "close ?", "confirm ...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "No");
            }
        }

    }

    JButton myButton;
    JButton myButton2;
    JButton myButton3;

    public MyFrame2(String title) throws HeadlessException {
        super(title);
        init();
    }

    void init() {
        getContentPane().setLayout(new FlowLayout());
        this.myButton = new JButton("MyButton");
        this.myButton2 = new JButton("MyButton2");
        this.myButton3 = new JButton("MyButton3");

        this.myButton.setSize(100, 50);

        this.myButton2.setSize(100, 50);
        this.myButton3.setSize(100, 50);
        getContentPane().add(this.myButton);
        getContentPane().add(this.myButton2);
        getContentPane().add(this.myButton3);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        MyActionListener myListener = new MyActionListener();

        this.myButton.addActionListener(myListener);
        this.myButton2.addActionListener(myListener);
        this.myButton3.addActionListener(myListener);
        addWindowListener(myListener);
    }

}
