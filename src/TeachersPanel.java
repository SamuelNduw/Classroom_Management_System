import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeachersPanel extends JPanel implements ActionListener {
    DBConnection db;
    ArrayList<TeacherItem> teachers;
    TeachersPanel(){
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
        JLabel subjectName = new JLabel("Subject"); // Subject Name heading
        subjectName.setBounds(522, 0, 216, 50);
        subjectName.setFont(new Font("Dialog", Font.BOLD, 25));
        subjectName.setForeground(Color.white);
        headingsPanel.add(subjectName);

        // Records Panel
        JPanel recordsPanel = new JPanel();
        recordsPanel.setBounds(100, 100, 750, 645);
        recordsPanel.setLayout(new GridLayout(15, 1, 0, 5));
        recordsPanel.setBackground(Color.decode("#787878"));
        this.add(recordsPanel);

        // Records Labels
        db = new DBConnection();
        teachers = db.retrieveTeacher();
        for(TeacherItem teacher : teachers){
            recordsPanel.add(new TeachersRowPanel(teacher.getFirstName(), teacher.getLastName(), teacher.getSubject()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
