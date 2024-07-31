import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Authorization.Auth;
import emailValidator.EmailValidator;

public class AddStudentPanel extends JPanel implements ActionListener {
    PlaceholderTextField first_name;
    PlaceholderTextField last_name;
    PlaceholderTextField email;

    JButton addButton;
    AddStudentPanel(Auth auth){
        this.setBounds(0, 0, 950, 800);
        this.setBackground(Color.decode("#787878"));
        this.setLayout(null);


        // Add Student to your class LABEL
        JLabel topLabel = new JLabel("ADD STUDENT");
        topLabel.setBounds(325, 50, 300, 50);
        topLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        topLabel.setForeground(Color.WHITE);
        this.add(topLabel);

        // Icon
        JLabel studentIconLabel = new JLabel();
        ImageIcon studentIcon = new ImageIcon(getClass().getResource("Images/studentIcon.png"));
        studentIconLabel.setIcon(studentIcon);
        studentIconLabel.setBounds(100, 200, 350, 350);
        this.add(studentIconLabel);

        // Form Input Fields
        first_name = new PlaceholderTextField("First Name");
        first_name.setBounds(550, 275, 310, 40);
        this.add(first_name);
        last_name = new PlaceholderTextField("Last Name");
        last_name.setBounds(550, 325, 310, 40);
        this.add(last_name);
        email = new PlaceholderTextField("Email");
        email.setBounds(550, 375, 310, 40);
        this.add(email);

        // Add Button
        addButton = new JButton("ADD");
        addButton.setBounds(550, 500, 310, 50);
        addButton.setFocusable(false);
        addButton.setBorderPainted(false);
        addButton.setBackground(Color.decode("#02CE8F"));
        addButton.setForeground(Color.white);
        addButton.setFont(new Font("Dialog", Font.BOLD, 20));
        addButton.addActionListener(e -> {
            // ADD button is pressed
            if(e.getSource() == addButton){
                String fName = first_name.getText();
                String lName = last_name.getText();
                String emailVal = email.getText();

                // Check if fields are empty
                if(fName.trim().isEmpty() || lName.trim().isEmpty() || emailVal.trim().isEmpty() || fName.equals("First Name") || lName.equals("Last Name") || emailVal.equals("Email")){
                    JOptionPane.showMessageDialog(null, "You left a text field empty!", "Submission Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    // Check if email is valid
                    if(EmailValidator.isValidEmail(emailVal)){
                        DBConnection db = new DBConnection();
                        db.insertStudent(fName, lName, emailVal, auth.getTeacherID());
                        System.out.println(fName + lName + emailVal + auth.getTeacherID());
                        // Success Message
                        JOptionPane.showMessageDialog(null, "Student successfully registered/added to class.", null, JOptionPane.INFORMATION_MESSAGE);
                        first_name.setText("First Name");
                        last_name.setText("Last Name");
                        email.setText("Email");
                    }else{
                        // Error Message (invalid email)
                        JOptionPane.showMessageDialog(null, "Email is not valid!", "Submission Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        this.add(addButton);

        // button to take initial focus, so that textfield placeholders can show
        JButton focusInitialButton = new JButton();
        focusInitialButton.setBounds(450, 0, 0, 0);
        focusInitialButton.requestFocusInWindow();
        this.add(focusInitialButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
