import Authorization.Auth;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class YourClassPanel extends JPanel {
    DBConnection db;
    ArrayList<StudentItem> students;
    YourClassPanel(Auth auth){
        this.setBounds(0, 0, 950, 800);
        this.setBackground(Color.decode("#787878"));
        this.setLayout(null);

        // Headings Panel
        JPanel headingsPanel = new JPanel();
        headingsPanel.setBounds(100, 30, 750, 60);
        headingsPanel.setBackground(Color.decode("#02CE8F"));
        headingsPanel.setLayout(null);
        this.add(headingsPanel);
        JLabel firstName = new JLabel("First Name"); // First Name heading
        firstName.setBounds(20, 0, 216, 50);
        firstName.setFont(new Font("Dialog", Font.BOLD, 25));
        firstName.setForeground(Color.white);
        headingsPanel.add(firstName);
        JLabel lastName = new JLabel("Last Name"); // Last Name heading
        lastName.setBounds(266, 0, 216, 50);
        lastName.setFont(new Font("Dialog", Font.BOLD, 25));
        lastName.setForeground(Color.white);
        headingsPanel.add(lastName);
        JLabel thresholdValue = new JLabel("Threshold Value"); // Subject Name heading
        thresholdValue.setBounds(522, 0, 216, 50);
        thresholdValue.setFont(new Font("Dialog", Font.BOLD, 25));
        thresholdValue.setForeground(Color.white);
        headingsPanel.add(thresholdValue);

        // Records Panel
        JPanel recordsPanel = new JPanel();
        recordsPanel.setBounds(100, 100, 750, 645);
        recordsPanel.setLayout(new GridLayout(15, 1, 0, 5));
        recordsPanel.setBackground(Color.decode("#787878"));
        this.add(recordsPanel);

        // Records Labels
        db = new DBConnection();
        students = db.retrieveStudents(auth.getTeacherID());
        for(StudentItem student : students){
            recordsPanel.add(new YourClassRowPanel(student.getFirstName(), student.getLastName(), student.getThresholdValue()));
        }
    }
}
