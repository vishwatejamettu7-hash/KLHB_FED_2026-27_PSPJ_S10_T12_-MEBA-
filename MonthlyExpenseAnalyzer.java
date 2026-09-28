import javax.swing.*;
import java.awt.*;

public class MonthlyExpenseAnalyzer extends JFrame {

    JTextField budgetField, foodField, travelField, shoppingField;
    JTextField entertainmentField, otherField;
    JTextArea resultArea;

    public MonthlyExpenseAnalyzer() {

        setTitle("Monthly Expense & Budget Analyzer");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Monthly Budget:"));
        budgetField = new JTextField();
        panel.add(budgetField);

        panel.add(new JLabel("Food Expense:"));
        foodField = new JTextField();
        panel.add(foodField);

        panel.add(new JLabel("Travel Expense:"));
        travelField = new JTextField();
        panel.add(travelField);

        panel.add(new JLabel("Shopping Expense:"));
        shoppingField = new JTextField();
        panel.add(shoppingField);

        panel.add(new JLabel("Entertainment Expense:"));
        entertainmentField = new JTextField();
        panel.add(entertainmentField);

        panel.add(new JLabel("Other Expenses:"));
        otherField = new JTextField();
        panel.add(otherField);

        JButton analyzeButton = new JButton("Analyze Expenses");
        JButton clearButton = new JButton("Clear");

        panel.add(analyzeButton);
        panel.add(clearButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        analyzeButton.addActionListener(e -> analyzeExpenses());
        clearButton.addActionListener(e -> clearFields());
    }

    private void analyzeExpenses() {

        try {
            double budget = Double.parseDouble(budgetField.getText());
            double food = Double.parseDouble(foodField.getText());
            double travel = Double.parseDouble(travelField.getText());
            double shopping = Double.parseDouble(shoppingField.getText());
            double entertainment = Double.parseDouble(entertainmentField.getText());
            double other = Double.parseDouble(otherField.getText());

            double total = food + travel + shopping + entertainment + other;
            double remaining = budget - total;
            double percentage = (total / budget) * 100;

            String status;

            if (total < budget) {
                status = "Within Budget";
            } else if (total == budget) {
                status = "Budget Fully Used";
            } else {
                status = "Over Budget";
            }

            resultArea.setText(
                    "====================================\n" +
                    "       EXPENSE ANALYSIS\n" +
                    "====================================\n" +
                    String.format("Monthly Budget : ₹%.2f%n", budget) +
                    String.format("Total Expense  : ₹%.2f%n", total) +
                    String.format("Budget Used    : %.2f%%%n", percentage) +
                    String.format("Balance        : ₹%.2f%n", remaining) +
                    "Status         : " + status + "\n" +
                    "===================================="
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void clearFields() {
        budgetField.setText("");
        foodField.setText("");
        travelField.setText("");
        shoppingField.setText("");
        entertainmentField.setText("");
        otherField.setText("");
        resultArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MonthlyExpenseAnalyzer app = new MonthlyExpenseAnalyzer();
            app.setVisible(true);
        });
    }
}