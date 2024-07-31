import javax.swing.*;
import java.awt.*;

public class TeachersRowPanel extends JPanel {
    TeachersRowPanel(String fName, String lName, String subject){
        this.setPreferredSize(new Dimension(750, 50));
        this.setLayout(null);
        this.setBackground(Color.decode("#575757"));
        this.add(new firstNameLabel(fName));
        this.add(new lastNameLabel(lName));
        this.add(new subjectLabel(subject));
    }
    public class firstNameLabel extends JLabel{
        firstNameLabel(String fName){
            this.setText(fName);
            this.setBounds(20, 0, 216, 40);
            this.setFont(new Font("Dialog", Font.PLAIN, 18));
            this.setForeground(Color.WHITE);
        }
    }
    public class lastNameLabel extends JLabel{
        lastNameLabel(String lName){
            this.setText(lName);
            this.setBounds(266, 0, 216, 40);
            this.setFont(new Font("Dialog", Font.PLAIN, 18));
            this.setForeground(Color.WHITE);
        }
    }
    public class subjectLabel extends JLabel{
        subjectLabel(String subject){
            this.setText(subject);
            this.setBounds(522, 0, 216, 40);
            this.setFont(new Font("Dialog", Font.PLAIN, 18));
            this.setForeground(Color.WHITE);
        }
    }
}
