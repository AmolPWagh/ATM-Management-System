
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton back, withdraw;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(960, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 800);
        add(image);
        
        JLabel text1 = new JLabel("Enter the amount you want to ");
        text1.setBounds(185, 170, 335, 30);
        text1.setFont(new Font("System", Font.BOLD, 22));
        text1.setForeground(Color.cyan);
        image.add(text1);
        JLabel text2 = new JLabel("withdraw( in Rs ):");
        text2.setBounds(185, 200, 335, 30);
        text2.setFont(new Font("System", Font.BOLD, 22));
        text2.setForeground(Color.cyan);
        image.add(text2);
        
        amount = new JTextField("");
        amount.setBounds(210, 245, 295, 30);
        amount.setFont(new Font("System", Font.BOLD, 18));
        amount.setBackground(Color.GRAY);
        amount.setForeground(Color.cyan);
        image.add(amount);
        
        back = new JButton("Back");
        back.setBounds(169, 385, 186, 34);
        back.setFont(new Font("System", Font.BOLD, 15));
        back.setBackground(Color.darkGray);
        back.setForeground(Color.cyan);
        back.addActionListener(this);
        image.add(back);
        
        withdraw = new JButton("Withdraw Amount");
        withdraw.setBounds(362, 385, 186, 34);
        withdraw.setFont(new Font("System", Font.BOLD, 15));
        withdraw.setBackground(Color.darkGray);
        withdraw.setForeground(Color.cyan);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        setSize(960, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == withdraw){
            String amt = amount.getText();
            Date date = new Date();
            if (amt.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount to be withdraw.");
            }
            else{
                try{
                    Conn c = new Conn();
                    String query1 = "select balance from loginbalance where pin = '"+pinnumber+"'";
                    ResultSet rs = c.s.executeQuery(query1);
                    if (rs.next()){
                        int balance = rs.getInt("balance");
                        if ( Integer.parseInt(amt)<=10000){
                            if (balance>=Integer.parseInt(amt)){
                                balance -= Integer.parseInt(amt);
                                String query2 = "update loginbalance set balance = '"+balance+"'";
                                c.s.executeUpdate(query2);
                            
                                String query3 = "insert into transactions (pin, date, type, amount) values ('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amt+"')";
                                c.s.executeUpdate(query3);
                                JOptionPane.showMessageDialog(null, "Rs. "+amt+" Withdrawn Successfully.");
                            
                                setVisible(false);
                                new Transactions(pinnumber).setVisible(true);
                            
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Insufficient Balance.");
                                amount.setText(null);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Cannot withdraw above Rs. 10,000.");
                            amount.setText(null);
                        }
                    }
                    
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }
        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Withdrawl("");
    }
    
}
