import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Authorization.Auth;
import SHA512.*;
import emailValidator.EmailValidator;

public class SignUpPanel extends JPanel implements ActionListener {
    PlaceholderTextField first_name, last_name, email, subject, newPassword, confirmPassword;
    JButton join;
    SignUpPanel(){
        this.setBounds(0, 0, 450, 600);
        this.setBackground(Color.decode("#787878"));
        this.setLayout(null);

        // sign in or sign up Label
        JLabel sign = new JLabel("SIGN UP");
        sign.setBounds(75, 60, 300, 50);
        sign.setFont(new Font("Dialog", Font.BOLD, 30));
        sign.setForeground(Color.WHITE);
        this.add(sign);

        // Form input fields
        first_name = new PlaceholderTextField("FIRST NAME");
        first_name.setBounds(65, 150, 310, 30);
        last_name = new PlaceholderTextField("LAST NAME");
        last_name.setBounds(65, 200, 310, 30);
        email = new PlaceholderTextField("EMAIL");
        email.setBounds(65, 250, 310, 30);
        subject = new PlaceholderTextField("SUBJECT");
        subject.setBounds(65, 300, 310, 30);
        newPassword = new PlaceholderTextField("NEW PASSWORD");
        newPassword.setBounds(65, 360, 310, 30);
        confirmPassword = new PlaceholderTextField("CONFIRM PASSWORD");
        confirmPassword.setBounds(65, 410, 310, 30);
        this.add(first_name);
        this.add(last_name);
        this.add(email);
        this.add(subject);
        this.add(newPassword);
        this.add(confirmPassword);

        // Form Join button
        join = new JButton("JOIN");
        join.setBounds(125, 460, 200, 35);
        join.setFont(new Font("SansSerif", Font.BOLD, 18));
        join.setBackground(Color.decode("#02CE8F"));
        join.setForeground(Color.WHITE);
        join.addActionListener(this);
        this.add(join);

        // button to take initial focus, so that textfield placeholders can show
        JButton focusInitialButton = new JButton();
        focusInitialButton.setBounds(450, 0, 0, 0);
        focusInitialButton.requestFocusInWindow();
        this.add(focusInitialButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // JOIN BUTTON IS PRESSED
        if(e.getSource() == join){
            String fName = first_name.getText();
            String lName = last_name.getText();
            String emailVal = email.getText();
            String subjectVal = subject.getText();
            String nPassword = newPassword.getText(),
                    cPassword = confirmPassword.getText();
            String[] hashAndSalt;
            String hashedPassword;
            String salt;

            // Check if fields are empty
            if(fName.trim().isEmpty() || lName.trim().isEmpty() || emailVal.trim().isEmpty() || subjectVal.trim().isEmpty() || nPassword.trim().isEmpty() || cPassword.trim().isEmpty() || fName.equals("FIRST NAME") || lName.equals("LAST NAME") || emailVal.equals("EMAIL") || subjectVal.equals("SUBJECT") || nPassword.equals("NEW PASSWORD") || cPassword.equals("CONFIRM PASSWORD")){
                JOptionPane.showMessageDialog(null, "You left a text field empty!", "Submission Error", JOptionPane.ERROR_MESSAGE);
            }else if(!nPassword.equals(cPassword)){
                JOptionPane.showMessageDialog(null, "The new password and confirm password are not the same, please insert the same values in both text fields!", "SUBMISSION FAILED", JOptionPane.ERROR_MESSAGE);
            }else{
                // Check if email is valid
                if(EmailValidator.isValidEmail(emailVal)){
                    DBConnection db = new DBConnection();
                    db.signUpTeacher(fName, lName, emailVal, subjectVal, nPassword);
                    Auth auth = db.getTeacherData(emailVal, nPassword);
                    // Success Message
                    JOptionPane.showMessageDialog(null, "You have successfully signed up.", null, JOptionPane.INFORMATION_MESSAGE);
                    first_name.setText("FIRST NAME");
                    last_name.setText("LAST NAME");
                    email.setText("EMAIL");
                    subject.setText("SUBJECT");
                    newPassword.setText("NEW PASSWORD");
                    confirmPassword.setText("CONFIRM PASSWORD");
                    // Dispose Window
                    Window[] windows = Window.getWindows();
                    for(Window window : windows){
                        window.dispose();
                    }
                    // Open Main Window
                    Boolean isNotConfig = db.isNotConfigured();
                    new MainFrame(auth, isNotConfig);
                    if(!isNotConfig){
                        new IntStrat(auth);
                    }
                }else{
                    // Error Message (invalid email)
                    JOptionPane.showMessageDialog(null, "Email is not valid!", "Submission Error", JOptionPane.ERROR_MESSAGE);
                }
            };
        }


    }
}
