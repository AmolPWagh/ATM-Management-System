
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStmt extends JFrame implements ActionListener{
    
     String pinnumber;
     JButton back;
    
    MiniStmt(String pinnumber) {
        
        this.pinnumber = pinnumber;
        
//        setTitle("Mini Statement");
        getContentPane().setBackground(Color.lightGray);
        
        

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(140, 20, 200, 30);
        bank.setFont(new Font("", Font.BOLD, 20));
        add(bank);
//        bank.setFont(new Font("Raleway", Font.BOLD, 20));

        JLabel card = new JLabel();
        card.setBounds(20, 60, 300, 20);
        add(card);
        
        JLabel trans = new JLabel();
        trans.setBounds(20, 35, 500, 300);
        add(trans);
        
        JLabel bal = new JLabel();
        bal.setBounds(20, 280, 260, 20);
        add(bal);
        
        back = new JButton("Back");
        back.setBounds(270, 275, 100, 30);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from loginbalance where pin = '" + pinnumber + "'");
            if (rs.next()){
                card.setText("Card No: " + rs.getString("cardno").substring(0,4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select date, amount, type from transactions where pin in (select pin from transactions where pin = '" + pinnumber + "') order by id desc limit 5           ");
            int count = 0;
            while (rs.next() && count<5){
                trans.setText(trans.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;" + "Rs. "+rs.getString("amount") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "<br><br>");
                count+=1;
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select balance from loginbalance where pin = 4321");
            int count = 0;
            if (rs.next()){
                bal.setText("Your current account balance is: Rs. " + rs.getString("balance"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        setLayout(null);
        setSize(384,315);
        setLocation(455, 153);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String args[]) {
        new MiniStmt("");
    }
}
