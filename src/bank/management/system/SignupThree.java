
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    SignupThree(String formno){
        
        this.formno = formno;
        
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        JLabel accDetails =new JLabel("Page 3: Account Details");
        accDetails.setBounds(280, 40, 400, 40);
        accDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(accDetails);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(125, 120, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Arial", Font.BOLD, 16));
        r1.setBackground(Color.GRAY);
        r1.setBounds(150, 160, 200, 30);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Arial", Font.BOLD, 16));
        r2.setBackground(Color.GRAY);
        r2.setBounds(450, 160, 200, 30);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Arial", Font.BOLD, 16));
        r3.setBackground(Color.GRAY);
        r3.setBounds(150, 200, 200, 30);
        add(r3);
        
        r4 = new JRadioButton("Recurring Account");
        r4.setFont(new Font("Arial", Font.BOLD, 16));
        r4.setBackground(Color.GRAY);
        r4.setBounds(450, 200, 200, 30);
        add(r4);
        
        ButtonGroup acctype = new ButtonGroup();
        acctype.add(r1);
        acctype.add(r2);
        acctype.add(r3);
        acctype.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(125, 280, 200, 30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-3125");
        number.setFont(new Font("Arial", Font.BOLD, 20));
        number.setBounds(350, 280, 300, 30);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 Digit Card Number Will Look Like This");
        carddetail.setFont(new Font("Arial", Font.BOLD, 12));
        carddetail.setBounds(350, 310, 300, 15);
        add(carddetail);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(125, 360, 200, 30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Arial", Font.BOLD, 20));
        pnumber.setBounds(350, 360, 300, 30);
        add(pnumber);
        
        JLabel pindetail = new JLabel("Your 4 Digit PIN Will Look Like This");
        pindetail.setFont(new Font("Arial", Font.BOLD, 12));
        pindetail.setBounds(350, 390, 300, 15);
        add(pindetail);
        
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(125, 450, 300, 30);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.GRAY);
        c1.setFont(new Font("Arial", Font.BOLD, 16));
        c1.setBounds(150, 490, 300, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.GRAY);
        c2.setFont(new Font("Arial", Font.BOLD, 16));
        c2.setBounds(450, 490, 300, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.GRAY);
        c3.setFont(new Font("Arial", Font.BOLD, 16));
        c3.setBounds(150, 530, 300, 30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.GRAY);
        c4.setFont(new Font("Arial", Font.BOLD, 16));
        c4.setBounds(450, 530, 300, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.GRAY);
        c5.setFont(new Font("Arial", Font.BOLD, 16));
        c5.setBounds(150, 570, 300, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.GRAY);
        c6.setFont(new Font("Arial", Font.BOLD, 16));
        c6.setBounds(450, 570, 300, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.GRAY);
        c7.setFont(new Font("Arial", Font.BOLD, 13));
        c7.setBounds(125, 660, 600, 30);
        add(c7);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.darkGray);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Arial", Font.BOLD, 14));
        cancel.setBounds(250, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.darkGray);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Arial", Font.BOLD, 14));
        submit.setBounds(450, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        setLayout(null);
        setVisible(true);
        setSize(800, 820);
        setLocationRelativeTo(null);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            
            String accountType = null;
            if (r1.isSelected()){
                accountType = "Saving Account";
            }
            else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            else if(r3.isSelected()){
                accountType = "Current Account";
            }
            else if(r3.isSelected()){
                accountType = "Recurring Account";
            }
            
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String services = "";
            if (c1.isSelected()){
                services += "-ATM Card-";
            }
            if (c2.isSelected()){
                services += "-Internet Banking-";
            }
            if (c3.isSelected()){
                services += "-Mobile Banking-";
            }
            if (c4.isSelected()){
                services += "-Email & SMS Alerts-";
            }
            if (c5.isSelected()){
                services += "-Cheque Book-";
            }
            if (c6.isSelected()){
                services += "-E-Statement-";
            }
            
            try{
                
                if (accountType == null){
                    JOptionPane.showMessageDialog(null, "Select the Account Type.");
                }
                else if (services.equals("")){
                    JOptionPane.showMessageDialog(null, "Select the Services you want.");
                }
                else if (c7.isSelected() == false){
                    JOptionPane.showMessageDialog(null, "Declaration is required.");
                } 
                else {
                    Conn c = new Conn();
                    String query1 = "insert into Signupthree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+services+"')";
                    c.s.executeUpdate(query1);
                    
                    String query2= "insert into loginbalance values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"', '0')";
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Registration Successful!!! \n" + " Card Number: " + cardnumber + "\n Pin: " + pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
                
            }catch (Exception e) {
                System.out.println(e);
            }
            
        }
        else if (ae.getSource() == cancel){
            try{
                Conn c = new Conn();
                String query4 = "delete from signupone where formno ='"+formno+"'";
                c.s.executeUpdate(query4);
                
                String query5 = "delete from signuptwo where formno ='"+formno+"'";
                c.s.executeUpdate(query5);
                
                
                
            }catch(Exception e){
                System.out.println(e);
            }
            System.exit(0);
        }
    }
    public static void main(String args[]){
        new SignupThree("");
    }
    
}
