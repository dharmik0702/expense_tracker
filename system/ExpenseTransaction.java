package expence.tracker.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class  ExpenseTransaction extends JFrame {

    private final ArrayList<Expence> expenses;
    private JTextField descriptionField;
    private JTextField amountField;
    private DefaultListModel<String> listModel;
    private JList<String> expenseList;
    private JLabel totalLabel;

    public ExpenseTransaction() {
        expenses = new ArrayList<>();
        listModel = new DefaultListModel<>();
        expenseList = new JList<>(listModel);

        setTitle("Expense Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        createUI();
    }

    private void createUI() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        descriptionField = new JTextField(20);
        amountField = new JTextField(10);
        JButton addButton = new JButton("Add Expense");

        inputPanel.add(new JLabel("Description: "));
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Amount: "));
        inputPanel.add(amountField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(expenseList), BorderLayout.CENTER);

        totalLabel = new JLabel("Total: $0.00");
        add(totalLabel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });
    }

    private void addExpense() {
        String description = descriptionField.getText();
        String amountText = amountField.getText();

        if (!description.isEmpty() && !amountText.isEmpty()) {
            try {
                double amount = Double.parseDouble(amountText);
                expenses.add(new Expence(description, amount));
                updateListAndTotal();
                descriptionField.setText("");
                amountField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Both description and amount are required.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateListAndTotal() {
        listModel.clear();
        double total = 0.0;
        for (Expence expense : expenses) {
            listModel.addElement(expense.toString());
            total += expense.getAmount();
        }
        totalLabel.setText("Total: $" + String.format("%.2f", total));
    }

    
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        ExpenseTransaction app = new ExpenseTransaction();
        app.setLocationRelativeTo(null); // Center the frame
        app.setVisible(true);
    });

    }
}

class Expence {
     String description;
     double amount;

    public Expence(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return description + " - $" + String.format("%.2f", amount);
    }
}
