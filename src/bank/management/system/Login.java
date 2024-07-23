
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login() {
        
        setTitle("AUTOMATED TELLER MACHINE Login");
        
        setLayout(null);
        setSize(800,480);
        setVisible(true);
        setLocationRelativeTo(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(150, 20, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        add(text);
        text.setBounds(320, 50, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 40));
        
        JLabel card = new JLabel("Card No:");
        add(card);
        card.setBounds(150, 170, 180, 30);
        card.setFont(new Font("Raleway", Font.BOLD, 30));
        
        cardTextField = new JTextField();
        add(cardTextField);
        cardTextField.setBounds(340, 170, 300, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 20));
        cardTextField.setBackground(Color.lightGray);
        
        JLabel pin = new JLabel("PIN:");
        add(pin);
        pin.setBounds(150, 230, 150, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 30));
        
        pinTextField = new JPasswordField();
        add(pinTextField);
        pinTextField.setBounds(340, 230, 300, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 25));
        pinTextField.setBackground(Color.lightGray);
        
        clear = new JButton("CLEAR");
        clear.setBounds(260, 320, 100, 30);
        clear.setBackground(Color.darkGray);
        clear.setForeground(Color.white);
        clear.setFont(new Font("Raleway", Font.BOLD, 14));
        clear.addActionListener(this);
        add(clear);
        
        login = new JButton("LOG IN");
        login.setBounds(430, 320, 100, 30);
        login.setBackground(Color.darkGray);
        login.setForeground(Color.white);
        login.setFont(new Font("Raleway", Font.BOLD, 14));
        login.addActionListener(this);
        add(login);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(260, 370, 270, 30);
        signup.setBackground(Color.darkGray);
        signup.setForeground(Color.white);
        signup.setFont(new Font("Raleway", Font.BOLD, 14));
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.GRAY);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() ==  clear){
            cardTextField.setText(null);
            pinTextField.setText(null);
        }
        else if (ae.getSource() == login){
            Conn c = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "Select * from loginbalance where cardno = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN.");
//                    cardTextField.setText(null);
                    pinTextField.setText(null);
                }
            }catch(Exception e){
                
            }
        }
        else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Login();
    }
}
