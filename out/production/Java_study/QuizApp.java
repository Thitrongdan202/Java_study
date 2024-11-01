import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class QuizApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel questionNumberPanel;
    private JLabel[] questionLabels;
    private JRadioButton[][] options;
    private ButtonGroup[] buttonGroups;
    private int currentQuestionIndex = 0;
    private final int totalQuestions = 5;
    private final Map<Integer, Integer> correctAnswers = new HashMap<>();

    public QuizApp() {
        setTitle("Trắc nghiệm");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout chính
        setLayout(new BorderLayout());

        // Tiêu đề
        JLabel titleLabel = new JLabel("Trắc nghiệm", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        add(titleLabel, BorderLayout.NORTH);

        // Panel chính sử dụng CardLayout cho các câu hỏi
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        options = new JRadioButton[totalQuestions][4];
        buttonGroups = new ButtonGroup[totalQuestions];

        // Tạo các card cho câu hỏi ngẫu nhiên
        for (int i = 0; i < totalQuestions; i++) {
            cardPanel.add(createQuestionPanel(i), "Câu hỏi " + (i + 1));
        }

        add(cardPanel, BorderLayout.CENTER);

        // Tạo panel số câu hỏi ở bên phải
        questionNumberPanel = createQuestionNumberPanel();
        add(questionNumberPanel, BorderLayout.EAST);

        // Nút điều hướng ở dưới
        JPanel navigationPanel = new JPanel();
        JButton firstButton = new JButton("<<");
        JButton prevButton = new JButton("<");
        JButton nextButton = new JButton(">");
        JButton lastButton = new JButton(">>");

        // Gắn sự kiện cho các nút điều hướng
        firstButton.addActionListener(e -> showQuestion(0));
        prevButton.addActionListener(e -> showQuestion(Math.max(currentQuestionIndex - 1, 0)));
        nextButton.addActionListener(e -> showQuestion(Math.min(currentQuestionIndex + 1, totalQuestions - 1)));
        lastButton.addActionListener(e -> showQuestion(totalQuestions - 1));

        navigationPanel.add(firstButton);
        navigationPanel.add(prevButton);
        navigationPanel.add(nextButton);
        navigationPanel.add(lastButton);

        // Nút nộp bài
        JButton submitButton = new JButton("Nộp");
        submitButton.addActionListener(e -> showResults());
        navigationPanel.add(submitButton);

        add(navigationPanel, BorderLayout.SOUTH);

        setVisible(true);

        // Khởi tạo đánh dấu câu hỏi đầu tiên
        updateQuestionIndicator(0);
    }

    private JPanel createQuestionPanel(int questionIndex) {
        JPanel questionPanel = new JPanel(new BorderLayout());
        questionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Tạo câu hỏi và đáp án
        Question question = generateMathQuestion();
        JLabel questionLabel = new JLabel("Câu hỏi " + (questionIndex + 1) + ": " + question.getQuestionText());
        questionLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        questionPanel.add(questionLabel, BorderLayout.NORTH);

        // Các lựa chọn cho câu hỏi
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        buttonGroups[questionIndex] = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            options[questionIndex][i] = new JRadioButton(String.valueOf(question.getOptions()[i]));
            options[questionIndex][i].setFont(new Font("Serif", Font.PLAIN, 18));
            buttonGroups[questionIndex].add(options[questionIndex][i]);
            optionsPanel.add(options[questionIndex][i]);

            // Đánh dấu đáp án đúng
            if (question.getOptions()[i] == question.getCorrectAnswer()) {
                options[questionIndex][i].setActionCommand("correct");
            } else {
                options[questionIndex][i].setActionCommand("incorrect");
            }
        }

        questionPanel.add(optionsPanel, BorderLayout.CENTER);

        return questionPanel;
    }

    private JPanel createQuestionNumberPanel() {
        JPanel numberPanel = new JPanel(new GridLayout(5, 1, 5, 5)); // Hiển thị 5 câu
        numberPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        questionLabels = new JLabel[totalQuestions];

        for (int i = 0; i < totalQuestions; i++) {
            JLabel numberLabel = new JLabel(String.valueOf(i + 1), SwingConstants.CENTER);
            numberLabel.setFont(new Font("Serif", Font.PLAIN, 16));
            numberLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            questionLabels[i] = numberLabel;
            numberPanel.add(numberLabel);
        }

        return numberPanel;
    }

    private void showQuestion(int questionIndex) {
        currentQuestionIndex = questionIndex;
        cardLayout.show(cardPanel, "Câu hỏi " + (questionIndex + 1));
        updateQuestionIndicator(questionIndex);
    }

    private void updateQuestionIndicator(int questionIndex) {
        for (int i = 0; i < totalQuestions; i++) {
            if (i == questionIndex) {
                questionLabels[i].setOpaque(true);
                questionLabels[i].setBackground(Color.CYAN); // Đánh dấu câu hỏi hiện tại bằng màu nền
            } else {
                questionLabels[i].setOpaque(false);
                questionLabels[i].setBackground(null);
            }
        }
        questionNumberPanel.repaint();
    }

    private Question generateMathQuestion() {
        Random rand = new Random();
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        int operator = rand.nextInt(3); // 0: +, 1: -, 2: *
        int correctAnswer;
        String questionText;

        switch (operator) {
            case 0 -> {
                correctAnswer = num1 + num2;
                questionText = num1 + " + " + num2 + " = ?";
            }
            case 1 -> {
                correctAnswer = num1 - num2;
                questionText = num1 + " - " + num2 + " = ?";
            }
            case 2 -> {
                correctAnswer = num1 * num2;
                questionText = num1 + " * " + num2 + " = ?";
            }
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        }

        // Tạo các đáp án
        int[] options = new int[4];
        options[0] = correctAnswer;
        for (int i = 1; i < 4; i++) {
            int wrongAnswer;
            do {
                wrongAnswer = correctAnswer + rand.nextInt(10) - 5; // Đáp án sai trong khoảng xung quanh đáp án đúng
            } while (wrongAnswer == correctAnswer || contains(options, wrongAnswer));
            options[i] = wrongAnswer;
        }

        // Xáo trộn đáp án
        shuffleArray(options);

        return new Question(questionText, options, correctAnswer);
    }

    private boolean contains(int[] arr, int value) {
        for (int num : arr) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    private void shuffleArray(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    private void showResults() {
        int score = 0;
        for (int i = 0; i < totalQuestions; i++) {
            if (buttonGroups[i].getSelection() != null &&
                    buttonGroups[i].getSelection().getActionCommand().equals("correct")) {
                score++;
            }
        }
        JOptionPane.showMessageDialog(this, "Bạn trả lời đúng " + score + " trong " + totalQuestions + " câu.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizApp::new);
    }
}

// Lớp hỗ trợ để lưu trữ thông tin câu hỏi
class Question {
    private final String questionText;
    private final int[] options;
    private final int correctAnswer;

    public Question(String questionText, int[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
