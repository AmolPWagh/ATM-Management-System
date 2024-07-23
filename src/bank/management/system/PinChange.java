
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    String pinnumber;
    JPasswordField epin, repin;
    JButton clear, change, back;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(960, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 800);
        add(image);
        
        JLabel text = new JLabel("Change your PIN");
        text.setBounds(185, 170, 345, 30);
        text.setFont(new Font("System", Font.BOLD, 22));
        text.setForeground(Color.cyan);
        image.add(text);
        
        JLabel text2 = new JLabel("Enter New PIN:");
        text2.setBounds(185, 220, 180, 30);
        text2.setFont(new Font("System", Font.BOLD, 20));
        text2.setForeground(Color.cyan);
        image.add(text2);
        
        epin = new JPasswordField("");
        epin.setBounds(375, 220, 155, 30);
        epin.setFont(new Font("System", Font.BOLD, 18));
        epin.setBackground(Color.GRAY);
        epin.setForeground(Color.cyan);
        image.add(epin);
        
        JLabel text3 = new JLabel("Re-enter New PIN:");
        text3.setBounds(185, 260, 180, 30);
        text3.setFont(new Font("System", Font.BOLD, 20));
        text3.setForeground(Color.cyan);
        image.add(text3);
        
        repin = new JPasswordField("");
        repin.setBounds(375, 260, 155, 30);
        repin.setFont(new Font("System", Font.BOLD, 18));
        repin.setBackground(Color.GRAY);
        repin.setForeground(Color.cyan);
        image.add(repin);
        
        clear = new JButton("Clear");
        clear.setBounds(169, 344, 186, 34);;
        clear.setFont(new Font("System", Font.BOLD, 15));
        clear.setBackground(Color.darkGray);
        clear.setForeground(Color.cyan);
        clear.addActionListener(this);
        image.add(clear);
        
        change = new JButton("Change");
        change.setBounds(362, 344, 186, 34);;
        change.setFont(new Font("System", Font.BOLD, 15));
        change.setBackground(Color.darkGray);
        change.setForeground(Color.cyan);
        change.addActionListener(this);
        image.add(change);
        
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
        
        if (ae.getSource() == clear){
            epin.setText(null);
            repin.setText(null);
        }
        else if (ae.getSource() == change){
            String npin = epin.getText();
            String rpin = repin.getText();
            if (npin.length() == 4 && rpin.length() == 4){
                if (!npin.equals(rpin)){
                    
                    JOptionPane.showMessageDialog(null, "Re-entered PIN is not equal to previously entered PIN.");
                    epin.setText(null);
                    repin.setText(null);
                }
                else{
                    
                    try{
                        Conn c = new Conn();
                        String query1 = "update  signupthree set pin ='"+npin+"' where pin = '"+pinnumber+"'";
                        c.s.executeUpdate(query1);
                        String query2 = "update  loginbalance set pin ='"+npin+"' where pin = '"+pinnumber+"'";
                        c.s.executeUpdate(query2);
                        String query3 = "update  transactions set pin ='"+npin+"' where pin = '"+pinnumber+"'";
                        c.s.executeUpdate(query3);
                        JOptionPane.showMessageDialog(null, "PIN updated successfully.");
                        
                        setVisible(false);
                        new Login().setVisible(true);
                        
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter the PIN of 4 digits.");
                epin.setText(null);
                repin.setText(null);
            }
        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        
        new PinChange("");
    }
    
}
