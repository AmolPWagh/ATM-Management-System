package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, gnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, otherG, married, unmarried, otherM;
    JDateChooser dateChooser;
    
    SignupOne() {
        
        getContentPane().setBackground(Color.GRAY);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 150, 200, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 15));
        nameTextField.setBounds(300, 150, 400, 30);
        nameTextField.setBackground(Color.lightGray);
        add(nameTextField);
        
        JLabel gname = new JLabel("Guardian's Name:");
        gname.setFont(new Font("Raleway", Font.BOLD, 20));
        gname.setBounds(100, 200, 200, 30);
        add(gname);
        
        gnameTextField = new JTextField();
        gnameTextField.setFont(new Font("Arial", Font.BOLD, 15));
        gnameTextField.setBounds(300, 200, 400, 30);
        gnameTextField.setBackground(Color.lightGray);
        add(gnameTextField);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 250, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 250, 400, 30);
        Component datePicker = dateChooser.getComponent(1);
        datePicker.setBackground(Color.lightGray);
        datePicker.setForeground(Color.black);
        dateChooser.setFont(new Font("Arial", Font.BOLD, 15));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 300, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(340, 300, 80, 30);
        male.setBackground(Color.GRAY);
        male.setFont(new Font("Arial", Font.BOLD, 16));
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(460, 300, 80, 30);
        female.setBackground(Color.GRAY);
        female.setFont(new Font("Arial", Font.BOLD, 16));
        add(female);
        
        otherG = new JRadioButton("Other");
        otherG.setBounds(580, 300, 80, 30);
        otherG.setBackground(Color.GRAY);
        otherG.setFont(new Font("Arial", Font.BOLD, 16));
        add(otherG);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(otherG);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 350, 200, 30);
        add(email); 
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 16));
        emailTextField.setBounds(300, 350, 400, 30);
        emailTextField.setBackground(Color.lightGray);
        add(emailTextField);
        
        JLabel maritalstatus = new JLabel("Marital Status:");
        maritalstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalstatus.setBounds(100, 400, 200, 30);
        add(maritalstatus);
        
        married = new JRadioButton("Married");
        married.setBounds(320, 400, 120, 30);
        married.setBackground(Color.GRAY);
        married.setFont(new Font("Arial", Font.BOLD, 16));
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 400, 120, 30);
        unmarried.setBackground(Color.GRAY);
        unmarried.setFont(new Font("Arial", Font.BOLD, 16));
        add(unmarried);
        
        otherM = new JRadioButton("Other");
        otherM.setBounds(580, 400, 120, 30);
        otherM.setBackground(Color.GRAY);
        otherM.setFont(new Font("Arial", Font.BOLD, 16));
        add(otherM);
        
        ButtonGroup statusgroup = new ButtonGroup();
        statusgroup.add(married);
        statusgroup.add(unmarried);
        statusgroup.add(otherM);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 450, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial", Font.BOLD, 15));
        addressTextField.setBounds(300, 450, 400, 30);
        addressTextField.setBackground(Color.lightGray);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 500, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial", Font.BOLD, 15));
        cityTextField.setBounds(300, 500, 400, 30);
        cityTextField.setBackground(Color.lightGray);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 550, 200, 30);
        add(state); 
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Arial", Font.BOLD, 15));
        stateTextField.setBackground(Color.lightGray);
        stateTextField.setBounds(300, 550, 400, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 600, 200, 30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Arial", Font.BOLD, 15));
        pincodeTextField.setBounds(300, 600, 400, 30);
        pincodeTextField.setBackground(Color.lightGray);
        add(pincodeTextField);
        
        next = new JButton("Goto Next Page");
        next.setBackground(Color.darkGray);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(550, 680, 150, 30);
        next.addActionListener(this);
        add(next);
        
                
        setLayout(null);
        setSize(850, 800);
        setLocationRelativeTo(null);
        setVisible(true);
          
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;        // to conver any num to str just add "" to it
        String name = nameTextField.getText();
        String gname = gnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }
        else if (female.isSelected()){
            gender = "Female";
        }
        else if (otherG.isSelected()){
            gender = "Other";
        }
        String email = emailTextField.getText();
        String maritalstatus = null;
        if (married.isSelected()){
            maritalstatus = "Married";
        }
        else if (unmarried.isSelected()){
            maritalstatus = "Unmarried";
        }
        else if (otherM.isSelected()){
            maritalstatus = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        
        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required.");
            }
            else if (gname.equals("")){
                JOptionPane.showMessageDialog(null , "Guardian's Name is Required.");
            }
            else if (dob.equals("")){
                JOptionPane.showMessageDialog(null , "Date of Birth is Required.");
            }
            else if (gender==null){
                JOptionPane.showMessageDialog(null , "Select your Gender.");
            }
            else if (!isValidEmail(email)){
                JOptionPane.showMessageDialog(null , "Enter valid Email Address.");
            }
            else if (maritalstatus==null){
                JOptionPane.showMessageDialog(null , "Select Marital status.");
            }
            else if (address.equals("")){
                JOptionPane.showMessageDialog(null , "Address is Required.");
            }
            else if (city.equals("")){
                JOptionPane.showMessageDialog(null , "City is Required.");
            }
            else if (state.equals("")){
                JOptionPane.showMessageDialog(null , "State is Required.");
            }
            else if (!isValidPincode(pincode)){
                JOptionPane.showMessageDialog(null , "Enter valid Pin Code.");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signupone values('"+formno+"', '"+name+"', '"+gname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+maritalstatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
    
    private boolean isValidPincode(String pincode) {
        return pincode.length() == 6;
    }
    
    public static void main(String args[]){
        new SignupOne();
    }
}
