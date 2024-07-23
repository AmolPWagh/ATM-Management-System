
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(960, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 800);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction:");
        text.setBounds(185, 170, 345, 30);
        text.setFont(new Font("System", Font.BOLD, 22));
        text.setForeground(Color.cyan);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(169, 303, 186, 34);
        deposit.setFont(new Font("System", Font.BOLD, 14));
        deposit.setBackground(Color.darkGray);
        deposit.setForeground(Color.cyan);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(362, 303, 186, 34);
        withdrawl.setFont(new Font("System", Font.BOLD, 15));
        withdrawl.setBackground(Color.darkGray);
        withdrawl.setForeground(Color.cyan);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(169, 344, 186, 34);
        fastcash.setFont(new Font("System", Font.BOLD, 15));
        fastcash.setBackground(Color.darkGray);
        fastcash.setForeground(Color.cyan);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(362, 344, 186, 34);
        ministatement.setFont(new Font("System", Font.BOLD, 15));
        ministatement.setBackground(Color.darkGray);
        ministatement.setForeground(Color.cyan);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("PIN Change");
        pinchange.setBounds(169, 385, 186, 34);
        pinchange.setFont(new Font("System", Font.BOLD, 15));
        pinchange.setBackground(Color.darkGray);
        pinchange.setForeground(Color.cyan);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(362, 385, 186, 34);
        balanceenquiry.setFont(new Font("System", Font.BOLD, 15));
        balanceenquiry.setBackground(Color.darkGray);
        balanceenquiry.setForeground(Color.cyan);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(362, 426, 186, 34);
        exit.setFont(new Font("System", Font.BOLD, 15));
        exit.setBackground(Color.darkGray);
        exit.setForeground(Color.cyan);
        exit.addActionListener(this);
        image.add(exit);
        
//        uk = new JButton("");
//        uk.setBounds(169, 426, 186, 34);
//        uk.setFont(new Font("System", Font.BOLD, 15));
//        uk.setBackground(Color.darkGray);
//        uk.setForeground(Color.cyan);
//        uk.addActionListener(this);
//        image.add(uk);
        
        setSize(960, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        }
        else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceInquiry(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == ministatement){
            new MiniStmt(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transactions("");
    }
    
}
