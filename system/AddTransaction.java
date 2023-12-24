
package expence.tracker.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTransaction extends JFrame {
    private JLabel catNameLabel;
    private JLabel dateLabel;
    private JLabel availAmountLabel;
    private JTextField transAmountField;
    private JTextField transDetailsField;
    private JButton addTransButton;
    private JButton addMoneyFromSavingsButton;
    private int currentBalance = 0;

    public AddTransaction() {
        setTitle("Add Transaction");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        createUI();

        // Simulate the current balance (you can replace this with your own logic)
        currentBalance = 0;
        availAmountLabel.setText("Available Balance: $" + currentBalance + ".00");
    }

    private void createUI() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        
        
        
        

        catNameLabel = new JLabel(" ");
        dateLabel = new JLabel(" " + getCurrentDate());
        availAmountLabel = new JLabel();
        
        
       

        transAmountField = new JTextField(20);
        transDetailsField = new JTextField(20);
        addTransButton = new JButton("Add Transaction");
        addMoneyFromSavingsButton = new JButton("Add Money from Savings");

        inputPanel.add(catNameLabel);
        inputPanel.add(dateLabel);
        inputPanel.add(availAmountLabel);
        inputPanel.add(new JLabel("Transaction Amount: "));
        inputPanel.add(transAmountField);
        inputPanel.add(new JLabel("Transaction Details: "));
        inputPanel.add(transDetailsField);
        inputPanel.add(addTransButton);
        inputPanel.add(addMoneyFromSavingsButton);

        add(inputPanel, BorderLayout.CENTER);

        addTransButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransaction();
            }
        });

        addMoneyFromSavingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMoneyFromSavings();
            }
        });
    }

    private void addTransaction() {
        // Add your transaction logic here
        // You can access transAmountField and transDetailsField for user input

        // For example, display a message
        JOptionPane.showMessageDialog(this, "Transaction added!");
    }

    private void addMoneyFromSavings() {
        // Add your logic to handle money transfer from savings
        // You can access transAmountField for the amount

        // For example, display a message
        JOptionPane.showMessageDialog(this, "Money added from savings!");
    }

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
          AddTransaction  app = new AddTransaction();
            app.setLocationRelativeTo(null); // Center the frame
            app.setVisible(true);
        });
    }
}
