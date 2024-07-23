package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JComboBox Religion, Category, Income, Qualification, Occupation; 
    JTextField  PAN, Aadhar;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    String formno;
    
    SignupTwo(String formno) {
        
        this.formno = formno;
        getContentPane().setBackground(Color.GRAY);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 70, 400, 30);
        add(additionalDetails);
        
        JLabel religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 140, 200, 30);
        add(religionLabel);
        
        String valReligion[] = {"", "Hindu", "Muslim", "Sikh", "Christian", "Other"};
        Religion = new JComboBox(valReligion);
        Religion.setFont(new Font("Arial", Font.BOLD, 15));
        Religion.setBounds(300, 140, 400, 30);
        Religion.setBackground(Color.lightGray);
        add(Religion);
        
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100, 195, 200, 30);
        add(categoryLabel);
        
        String valCategory[] = {"", "General Category (GC)", "Other Backward Class (OBC)", "Scheduled Caste (SC)", "Scheduled Tribe (ST)"};
        Category = new JComboBox(valCategory);
        Category.setFont(new Font("Arial", Font.BOLD, 15));
        Category.setBounds(300, 195, 400, 30);
        Category.setBackground(Color.lightGray);
        add(Category);
        
        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 250, 200, 30);
        add(incomeLabel);
        
        String valIncome[] = {"", "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000", "> 10,00,000"};
        Income = new JComboBox(valIncome);
        Income.setFont(new Font("Arial", Font.BOLD, 15));
        Income.setBounds(300, 250, 400, 30);
        Income.setBackground(Color.lightGray);
        add(Income);
        
        JLabel educationalLabel = new JLabel("Educational");
        educationalLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationalLabel.setBounds(100, 305, 200, 30);
        add(educationalLabel);
        JLabel qualificationLabel = new JLabel("Qualification:");
        qualificationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        qualificationLabel.setBounds(100, 330, 200, 30);
        add(qualificationLabel); 
        
        String valEducation[] = {"", "Non-Graduation", "Graduation", "Post-Graduation", "Doctrate", "Other"};
        Qualification = new JComboBox(valEducation);
        Qualification.setFont(new Font("Arial", Font.BOLD, 15));
        Qualification.setBounds(300, 330, 400, 30);
        Qualification.setBackground(Color.lightGray);
        add(Qualification);
        
        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLabel.setBounds(100, 385, 200, 30);
        add(occupationLabel);
        
        String valOccupation[] = {"", "Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Other"};
        Occupation = new JComboBox(valOccupation);
        Occupation.setFont(new Font("Arial", Font.BOLD, 15));
        Occupation.setBounds(300, 385, 400, 30);
        Occupation.setBackground(Color.lightGray);
        add(Occupation);
        
        JLabel panLabel = new JLabel("PAN Number:");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panLabel.setBounds(100, 440, 200, 30);
        add(panLabel);
        
        PAN = new JTextField();
        PAN.setFont(new Font("Arial", Font.BOLD, 15));
        PAN.setBounds(300, 440, 400, 30);
        PAN.setBackground(Color.lightGray);
        add(PAN);
        
        JLabel aadharLabel = new JLabel("Aadhar Number:");
        aadharLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharLabel.setBounds(100, 495, 200, 30);
        add(aadharLabel);
        
        Aadhar = new JTextField();
        Aadhar.setFont(new Font("Arial", Font.BOLD, 15));
        Aadhar.setBounds(300, 495, 400, 30);
        Aadhar.setBackground(Color.lightGray);
        add(Aadhar);
        
        JLabel seniorLabel = new JLabel("Senior Citizen:");
        seniorLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorLabel.setBounds(100, 550, 200, 30);
        add(seniorLabel);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(390, 550, 70, 30);
        syes.setBackground(Color.GRAY);
        syes.setFont(new Font("Arial", Font.BOLD, 16));
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(540, 550, 70, 30);
        sno.setBackground(Color.GRAY);
        sno.setFont(new Font("Arial", Font.BOLD, 16));
        add(sno);
        
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel existingLabel = new JLabel("Existing Account:");
        existingLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        existingLabel.setBounds(100, 605, 200, 30);
        add(existingLabel);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(390, 605, 70, 30);
        eyes.setBackground(Color.GRAY);
        eyes.setFont(new Font("Arial", Font.BOLD, 16));
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(540, 605, 70, 30);
        eno.setBackground(Color.GRAY);
        eno.setFont(new Font("Arial", Font.BOLD, 16));
        add(eno);
        
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
        
        next = new JButton("Goto Next Page");
        next.setBackground(Color.darkGray);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(550, 675, 150, 30);
        next.addActionListener(this);
        add(next);
        
                
        setLayout(null);
        setSize(850, 800);
        setLocationRelativeTo(null);
        setVisible(true);
          
    }
    
    public void actionPerformed(ActionEvent ae){
        String religion = (String)Religion.getSelectedItem();
        String category = (String)Category.getSelectedItem();
        String income = (String)Income.getSelectedItem();
        String qualification = (String)Qualification.getSelectedItem();
        String occupation = (String)Occupation.getSelectedItem();
        String pan = PAN.getText();
        String aadhar = Aadhar.getText();
        String senior = null;
        if (syes.isSelected()){
            senior = "Yes";
        }
        else if (sno.isSelected()){
            senior = "No";
        }
        String existing =null;
        if (eyes.isSelected()){
            existing = "Yes";
        }
        else if (eno.isSelected()){
            existing = "No";
        }
        
        try {
            if (religion.equals("")){
                JOptionPane.showMessageDialog(null, "Select the religion.");
            }
            else if (category.equals("")){
                JOptionPane.showMessageDialog(null , "Select the category.");
            }
            else if (income.equals("")){
                JOptionPane.showMessageDialog(null , "Select the income.");
            }
            else if (qualification.equals("")){
                JOptionPane.showMessageDialog(null , "Select the educational qualification.");
            }
            else if (occupation.equals("")){
                JOptionPane.showMessageDialog(null , "Select the occupation.");
            }
            else if (pan.length()!=10){
                JOptionPane.showMessageDialog(null , "Enter valid PAN number.");
            }
            else if (aadhar.length()!=12){
                JOptionPane.showMessageDialog(null , "Enter valid Aadhar number.");
            }
            else if (senior==null){
                JOptionPane.showMessageDialog(null , "Senior Citizen field is empty.");
            }
            else if (existing==null){
                JOptionPane.showMessageDialog(null , "Existing Account field is empty.");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+qualification+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+senior+"', '"+existing+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}

