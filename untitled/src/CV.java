import javax.swing.*;
import java.awt.*;

public class CV {
    private JFrame frame;

    public CV() {
        // Frame setup
        frame = new JFrame("Angie Vande - CV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setLayout(new BorderLayout());

        // Header section with name and title
        JPanel headerPanel = new JPanel(new GridLayout(2, 1));
        JLabel nameLabel = new JLabel("Angie Vande", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel titleLabel = new JLabel("Java Software Developer", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        headerPanel.add(nameLabel);
        headerPanel.add(titleLabel);
        frame.add(headerPanel, BorderLayout.NORTH);

        // Left side panel for contact details, education, and skills
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel contactLabel = new JLabel("<html><b>Contact Details</b><br>Email: angievande@gmail.com<br>Phone: (579) 312 7912<br>Location: North Shea, Connecticut</html>");
        leftPanel.add(contactLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Adding space

        JLabel educationLabel = new JLabel("<html><b>Education</b><br>B.S. in Computer Science<br>Stanford University<br>2017 - 2021</html>");
        leftPanel.add(educationLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Adding space

        JLabel skillsLabel = new JLabel("<html><b>Skills</b><br>Object-Oriented - Expert<br>Java SE - Expert<br>Algorithms - Expert<br>Databases - Expert<br>Multithreading - Expert<br>Java EE - Expert</html>");
        leftPanel.add(skillsLabel);

        frame.add(leftPanel, BorderLayout.WEST);

        // Main section for summary and work experience
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel summaryLabel = new JLabel("<html><b>Summary</b><br>Experienced Java Software Developer with 5+ years of developing, testing, and deploying software applications. Skilled in developing custom solutions to meet customer needs.</html>");
        mainPanel.add(summaryLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Adding space

        JLabel workExpLabel = new JLabel("<html><b>Work Experience</b><br><br><b>Java Software Developer</b>, Gottlieb, Blanda and Collins<br>March 2023 - Present<br>• Developed Java applications for leading software companies, increasing sales.<br>• Designed and implemented Java-based web apps for large retailers.<br><br><b>Java Software Developer</b>, Huel, Goldner and Roberts<br>May 2021 - February 2023<br>• Collaborated on Java-based mobile apps for large financial institutions.<br>• Wrote custom Java code for large manufacturing companies.</html>");
        mainPanel.add(workExpLabel);

        frame.add(mainPanel, BorderLayout.CENTER);

        // Setting the frame visibility
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CV::new);
    }
}
