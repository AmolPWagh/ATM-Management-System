
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;


public class FastCash extends JFrame implements ActionListener{
    
    JButton Rs100, Rs500, Rs1000, Rs2000, Rs5000, Rs10000, back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(960, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 800);
        add(image);
        
        JLabel text = new JLabel("Select withdrawl amount:");
        text.setBounds(185, 170, 345, 30);
        text.setFont(new Font("System", Font.BOLD, 22));
        text.setForeground(Color.cyan);
        image.add(text);
        
        Rs100 = new JButton("Rs. 100");
        Rs100.setBounds(169, 303, 186, 34);
        Rs100.setFont(new Font("System", Font.BOLD, 14));
        Rs100.setBackground(Color.darkGray);
        Rs100.setForeground(Color.cyan);
        Rs100.addActionListener(this);
        image.add(Rs100);
        
        Rs500 = new JButton("Rs. 500");
        Rs500.setBounds(362, 303, 186, 34);
        Rs500.setFont(new Font("System", Font.BOLD, 15));
        Rs500.setBackground(Color.darkGray);
        Rs500.setForeground(Color.cyan);
        Rs500.addActionListener(this);
        image.add(Rs500);
        
        Rs1000 = new JButton("Rs. 1000");
        Rs1000.setBounds(169, 344, 186, 34);
        Rs1000.setFont(new Font("System", Font.BOLD, 15));
        Rs1000.setBackground(Color.darkGray);
        Rs1000.setForeground(Color.cyan);
        Rs1000.addActionListener(this);
        image.add(Rs1000);
        
        Rs2000 = new JButton("Rs. 2000");
        Rs2000.setBounds(362, 344, 186, 34);
        Rs2000.setFont(new Font("System", Font.BOLD, 15));
        Rs2000.setBackground(Color.darkGray);
        Rs2000.setForeground(Color.cyan);
        Rs2000.addActionListener(this);
        image.add(Rs2000);
        
        Rs5000 = new JButton("Rs. 5000");
        Rs5000.setBounds(169, 385, 186, 34);
        Rs5000.setFont(new Font("System", Font.BOLD, 15));
        Rs5000.setBackground(Color.darkGray);
        Rs5000.setForeground(Color.cyan);
        Rs5000.addActionListener(this);
        image.add(Rs5000);
        
        Rs10000 = new JButton("Rs. 10000");
        Rs10000.setBounds(362, 385, 186, 34);
        Rs10000.setFont(new Font("System", Font.BOLD, 15));
        Rs10000.setBackground(Color.darkGray);
        Rs10000.setForeground(Color.cyan);
        Rs10000.addActionListener(this);
        image.add(Rs10000);
        
//        uk = new JButton("");
//        uk.setBounds(169, 426, 186, 34);
//        uk.setFont(new Font("System", Font.BOLD, 15));
//        uk.setBackground(Color.darkGray);
//        uk.setForeground(Color.cyan);
//        uk.addActionListener(this);
//        image.add(uk);
        
        back = new JButton("Back");
        back.setBounds(362, 426, 186, 34);
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
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else {
            String amt = ((JButton)ae.getSource()).getText().substring(4);
            
            try{
                Date date = new Date();
                Conn c = new Conn();
                String query1 = "select balance from loginbalance where pin = '"+pinnumber+"'";
                ResultSet rs = c.s.executeQuery(query1);
                if (rs.next()){
                    int balance = rs.getInt("balance");
                    if (balance >= Integer.parseInt(amt)){
                        balance -= Integer.parseInt(amt);
                        String query2 = "update loginbalance set balance = '"+balance+"' where pin = '"+pinnumber+"'";
                        c.s.executeUpdate(query2);
                        
                        String query3 = "insert into transactions (pin, date, type, amount) values('"+pinnumber+"', '"+date+"', 'Fast Cash', '"+amt+"')";
                        c.s.executeUpdate(query3);
                        
                        JOptionPane.showMessageDialog(null, "Rs. "+amt+" Withdrawn Successfully.");
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Insufficient Balance.");
                    }
                }
                
            }catch(Exception e){
               
            }
        }
    }
    
    public static void main(String args[]){
        new FastCash("");
    }
    
}
