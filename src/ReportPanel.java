import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportPanel extends JPanel implements ActionListener {

    JButton submitButton;
    ReportPanel(){
        this.setBounds(0, 0, 950, 800);
        this.setBackground(Color.decode("#787878"));
        this.setLayout(null);

        // 'FILE AN INCIDENT' LABEL
        JLabel topLabel = new JLabel("FILE AN INCIDENT");
        topLabel.setBounds(275, 50, 400, 50);
        topLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        topLabel.setForeground(Color.WHITE);
        this.add(topLabel);

        // Icon
        JLabel warningIconLabel = new JLabel();
        ImageIcon studentIcon = new ImageIcon(getClass().getResource("Images/warningIconYellow.png"));
        warningIconLabel.setIcon(studentIcon);
        warningIconLabel.setBounds(100, 200, 350, 350);
        this.add(warningIconLabel);

        // Form Input Fields
        PlaceholderTextField first_name = new PlaceholderTextField("First Name");
        first_name.setBounds(550, 275, 310, 40);
        this.add(first_name);
        PlaceholderTextField last_name = new PlaceholderTextField("Last Name");
        last_name.setBounds(550, 325, 310, 40);
        this.add(last_name);
        String[] items = {"Noise", "Fighting", "Eating", "Distracting", "Disrespect"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(550, 375, 310, 40);
        comboBox.setFont(new Font("Dialog", Font.BOLD, 18));
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(Color.decode("#8E8E8E"));
        this.add(comboBox);

        // Submit Button
        submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(this);
        submitButton.setBounds(550, 500, 310, 50);
        submitButton.setFocusable(false);
        submitButton.setBorderPainted(false);
        submitButton.setBackground(Color.decode("#E9D502"));
        submitButton.setForeground(Color.white);
        submitButton.setFont(new Font("Dialog", Font.BOLD, 20));
        this.add(submitButton);

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

