import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentPanel extends JPanel implements ActionListener {

    JButton addButton;
    AddStudentPanel(){
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
        PlaceholderTextField first_name = new PlaceholderTextField("First Name");
        first_name.setBounds(550, 275, 310, 40);
        this.add(first_name);
        PlaceholderTextField last_name = new PlaceholderTextField("Last Name");
        last_name.setBounds(550, 325, 310, 40);
        this.add(last_name);
        PlaceholderTextField email = new PlaceholderTextField("Email");
        email.setBounds(550, 375, 310, 40);
        this.add(email);

        // Add Button
        addButton = new JButton("ADD");
        addButton.addActionListener(this);
        addButton.setBounds(550, 500, 310, 50);
        addButton.setFocusable(false);
        addButton.setBorderPainted(false);
        addButton.setBackground(Color.decode("#02CE8F"));
        addButton.setForeground(Color.white);
        addButton.setFont(new Font("Dialog", Font.BOLD, 20));
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
