
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceInquiry extends JFrame implements ActionListener{
    
    String pinnumber;
    JButton back;
    
    BalanceInquiry(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(960, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 800);
        add(image);
        
        JLabel text = new JLabel("Available Balance in your bank");
        text.setBounds(185, 170, 345, 30);
        text.setFont(new Font("System", Font.BOLD, 22));
        text.setForeground(Color.cyan);
        image.add(text);
        JLabel text2 = new JLabel("account is :");
        text2.setBounds(185, 200, 335, 30);
        text2.setFont(new Font("System", Font.BOLD, 22));
        text2.setForeground(Color.cyan);
        image.add(text2);
        
        Conn c = new Conn();
        String query = "Select balance from loginbalance where pin = '"+this.pinnumber+"'";
        try{
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()){
                int balance = rs.getInt("balance");
                JLabel balanceLabel = new JLabel("Rs. "+balance);
                balanceLabel.setBounds(330, 200, 200, 30);
                balanceLabel.setFont(new Font("System", Font.BOLD, 22));
                balanceLabel.setForeground(Color.cyan);
                image.add(balanceLabel);
            }
            else{
                JOptionPane.showMessageDialog(null, "Unable to fetch the balance.");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        back = new JButton("Back");
        back.setBounds(362, 385, 186, 34);
        back.setFont(new Font("System", Font.BOLD, 15));
        back.setBackground(Color.darkGray);
        back.setForeground(Color.cyan);
        back.addActionListener(this);
        image.add(back);
        
        setSize(960, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceInquiry("");
    }
    
}
