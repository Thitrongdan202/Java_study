import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * MyFrame
 *
 * @author hasu
 */
public class MyFrame extends JFrame implements ActionListener, WindowListener {

    JButton myButton;
    JButton myButton2;
    JButton myButton3;
    JCheckBox myCheckBox;

    public MyFrame(String title) throws HeadlessException {
        super(title);
        init();
    }

    void init() {
        getContentPane().setLayout(new FlowLayout());
        this.myButton = new JButton("MyButton");
        this.myButton2 = new JButton("MyButton2");
        this.myButton3 = new JButton("MyButton3");
        this.myCheckBox = new JCheckBox("MyCheckBox");
        this.myButton.setSize(100, 50);
        this.myButton2.setSize(100, 50);
        this.myButton3.setSize(100, 50);
        getContentPane().add(this.myButton);
        getContentPane().add(this.myButton2);
        getContentPane().add(this.myButton3);
        getContentPane().add(this.myCheckBox);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        this.myButton.addActionListener(this);
        this.myButton2.addActionListener(this);
        this.myButton3.addActionListener(this);
        this.myCheckBox.addActionListener(this);
        addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String title;
        if (e.getSource() instanceof JButton) {
            title = "confirm ..." + ((JButton) e.getSource()).getText();
        } else {
            title = "confirm ..." + ((JCheckBox) e.getSource()).getText();
        }

        Object objs[] = {"Đóng", "Không đóng"};
        if (JOptionPane.showOptionDialog(
                this,
                "close ?",
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                objs,
                objs[1]
        ) == JOptionPane.YES_OPTION) {

//        if (JOptionPane.showConfirmDialog(this, "close ?", "confirm ...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(this, "No");
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(this, "close ?", "confirm ...closing", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(this, "No");
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
