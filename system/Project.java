
package expence.tracker.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


    
        
       public class Project extends JFrame implements ActionListener{
        String atype;
        Project(String atype) {
        this.atype = atype;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/resent.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
         JMenu expense = new JMenu("Expense");
         expense.setForeground(Color.blue);
         mb.add(expense);
       
        
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced", Font.BOLD, 18));
        newcustomer.setBackground(Color.pink);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        newcustomer.setMnemonic('p');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        expense.add(newcustomer);
        
         
        JMenuItem addtransaction = new JMenuItem("Add Transaction");
        addtransaction.setFont(new Font("monospaced", Font.BOLD, 18));
        addtransaction.setBackground(Color.pink);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        addtransaction.setIcon(new ImageIcon(image1));
        addtransaction.setMnemonic('D');
        addtransaction.addActionListener(this);
        addtransaction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        expense.add(addtransaction);
        
        
        JMenuItem expencetransection = new JMenuItem("Expense Transection");
        expencetransection.setFont(new Font("monospaced", Font.BOLD, 18));
        expencetransection.setBackground(Color.pink);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        expencetransection.setIcon(new ImageIcon(image2));
        expencetransection.setMnemonic('K');
        expencetransection.addActionListener(this);
        expencetransection.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        expense.add(expencetransection);
        
        
        
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.black);
        
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.BOLD, 18));
        notepad.setBackground(Color.pink);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('N');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        utility.add(notepad);
        
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced", Font.BOLD,18));
        calculator.setBackground(Color.pink);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image10));
        calculator.setMnemonic('C');
        calculator.addActionListener(this);
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        utility.add(calculator);
        
        JMenu mexit = new JMenu("Exit");
        mexit.setForeground(Color.RED);
        
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced", Font.BOLD, 18));
        exit.setBackground(Color.pink);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        exit.setMnemonic('W');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        mexit.add(exit);
        
        if (atype.equals("Admin")) {
            mb.add(expense);
        } 
        
        
        
        
       
        mb.add(utility);
        mb.add(mexit);
        
        setLayout(new FlowLayout());
        setVisible(true);
        
    }
        public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("New Customer")) {
            new NewCustomer();
        } else if (msg.equals("Add Transaction")) {
            AddTransaction et=new AddTransaction();
            et.show();
            dispose();
            
        } else if (msg.equals("Expense Transection")) {
            new ExpenceTransection();
            ExpenceTransection at=new ExpenceTransection();
            at.show();
            dispose();
        }
        else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
            else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        }
    }
 
       
        public static void main(String[]args ) {
        new Project ("");
        }
       }
                

