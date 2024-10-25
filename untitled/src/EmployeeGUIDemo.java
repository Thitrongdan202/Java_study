import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeGUIDemo {
    private JFrame frame;
    private JPanel panel;
    private JButton showButton, hideButton, exitButton, openCvButton;

    public EmployeeGUIDemo() {
        // Frame setup
        frame = new JFrame("GUI - Demo 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        // Panel setup
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Employee Details"));
        panel.setBounds(30, 30, 320, 150);
        panel.setLayout(null);

        // Components in panel
        JLabel codeLabel = new JLabel("Code:");
        codeLabel.setBounds(10, 20, 50, 20);
        panel.add(codeLabel);

        JTextField codeField = new JTextField();
        codeField.setBounds(70, 20, 230, 20);
        panel.add(codeField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 50, 50, 20);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(70, 50, 230, 20);
        panel.add(nameField);

        JLabel sexLabel = new JLabel("Sex:");
        sexLabel.setBounds(10, 80, 50, 20);
        panel.add(sexLabel);

        JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setBounds(70, 80, 100, 20);
        JRadioButton femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(180, 80, 100, 20);

        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(maleButton);
        sexGroup.add(femaleButton);

        panel.add(maleButton);
        panel.add(femaleButton);

        JLabel degreeLabel = new JLabel("Degree:");
        degreeLabel.setBounds(10, 110, 50, 20);
        panel.add(degreeLabel);

        String[] degrees = {"Ph. D.", "Master", "Bachelor"};
        JComboBox<String> degreeComboBox = new JComboBox<>(degrees);
        degreeComboBox.setBounds(70, 110, 230, 20);
        panel.add(degreeComboBox);

        frame.add(panel);

        // Show button
        showButton = new JButton("Show");
        showButton.setBounds(150, 200, 80, 25);
        frame.add(showButton);

        // Hide button
        hideButton = new JButton("Hide");
        hideButton.setBounds(150, 200, 80, 25);
        frame.add(hideButton);

        // Exit button
        exitButton = new JButton("Exit");
        exitButton.setBounds(270, 200, 80, 25);
        frame.add(exitButton);

        // Open CV button
        openCvButton = new JButton("Open CV");
        openCvButton.setBounds(30, 200, 100, 25);
        frame.add(openCvButton);

        // Button actions
        hideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                hideButton.setVisible(false);
                showButton.setVisible(true);
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(true);
                hideButton.setVisible(true);
                showButton.setVisible(false);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        openCvButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close EmployeeGUI window
                new CV(); // Open CV window
            }
        });

        // Initial visibility
        showButton.setVisible(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeGUIDemo());
    }
}
