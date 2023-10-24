import Authorization.Auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    JButton navDashboardButton;
    JButton navClassButton;
    JButton navIncidentsButton;
    JButton navTeachersButton;
    JButton navIntThrButton;
    JButton addStudentButton;
    JButton reportButton;
    JPanel mainPanel;
    MainFrame(Auth auth, Boolean configured){
        // Frame configurations
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLayout(null);
        this.setTitle("Classroom Management System");
        this.setResizable(false);



        // Navigation Panel
        JPanel navPanel = new JPanel();
        navPanel.setBounds(0, 0, 250, 800);
        navPanel.setBackground(Color.decode("#02CE8F"));
        navPanel.setLayout(null);
        this.add(navPanel);

        // Nav directories Panel
        JPanel navDirPanel = new JPanel();
        navDirPanel.setBounds(0, 100, 250, 350);
        navDirPanel.setBackground(Color.decode("#02CE8F"));
        navDirPanel.setLayout(new GridLayout(5, 1, 0, 10));
        navPanel.add(navDirPanel);

        // Nav directories Contents

        // dashboard
        navDashboardButton = new JButton();
        navDashboardButton.addActionListener(this);
        navDashboardButton.setBorderPainted(false);
        navDashboardButton.setLayout(null);
        navDashboardButton.setPreferredSize(new Dimension(250, 60));
        navDashboardButton.setBackground(Color.decode("#02CE8F"));
        navDirPanel.add(navDashboardButton);
        JLabel dashboardIcon = new JLabel(); // Icon
        dashboardIcon.setIcon(new ImageIcon(getClass().getResource("Images/dashboardIcon.png")));
        dashboardIcon.setBounds(20, 0, 80, 60);
        navDashboardButton.add(dashboardIcon);
        JLabel dashboardText = new JLabel("DASHBOARD"); // Text
        dashboardText.setBounds(100, 0, 150, 60);
        dashboardText.setForeground(Color.white);
        dashboardText.setFont(new Font("Dialog", Font.BOLD, 18));
        navDashboardButton.add(dashboardText);

        // your class
        navClassButton = new JButton();
        navClassButton.addActionListener(e -> {
            if(e.getSource() == navClassButton){
                mainPanel.removeAll();
                mainPanel.add(new YourClassPanel(auth));
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        navClassButton.setBorderPainted(false);
        navClassButton.setLayout(null);
        navClassButton.setPreferredSize(new Dimension(250, 60));
        navClassButton.setBackground(Color.decode("#02CE8F"));
        navDirPanel.add(navClassButton);
        JLabel classIcon = new JLabel(); // Icon
        classIcon.setIcon(new ImageIcon(getClass().getResource("Images/classIcon.png")));
        classIcon.setBounds(20, 0, 80, 60);
        navClassButton.add(classIcon);
        JLabel classText = new JLabel("YOUR CLASS"); // Text
        classText.setBounds(100, 0, 150, 60);
        classText.setForeground(Color.white);
        classText.setFont(new Font("Dialog", Font.BOLD, 18));
        navClassButton.add(classText);
        // incidents
        navIncidentsButton = new JButton();
        navIncidentsButton.addActionListener(this);
        navIncidentsButton.setBorderPainted(false);
        navIncidentsButton.setLayout(null);
        navIncidentsButton.setPreferredSize(new Dimension(250, 60));
        navIncidentsButton.setBackground(Color.decode("#02CE8F"));
        navDirPanel.add(navIncidentsButton);
        JLabel incidentsIcon = new JLabel(); // Icon
        incidentsIcon.setIcon(new ImageIcon(getClass().getResource("Images/incidentsIcon.png")));
        incidentsIcon.setBounds(20, 0, 80, 60);
        navIncidentsButton.add(incidentsIcon);
        JLabel incidentsText = new JLabel("INCIDENTS"); // Text
        incidentsText.setBounds(100, 0, 150, 60);
        incidentsText.setForeground(Color.white);
        incidentsText.setFont(new Font("Dialog", Font.BOLD, 18));
        navIncidentsButton.add(incidentsText);
        // teachers
        navTeachersButton = new JButton();
        navTeachersButton.addActionListener(this);
        navTeachersButton.setBorderPainted(false);
        navTeachersButton.setLayout(null);
        navTeachersButton.setPreferredSize(new Dimension(250, 60));
        navTeachersButton.setBackground(Color.decode("#02CE8F"));
        navDirPanel.add(navTeachersButton);
        JLabel teachersIcon = new JLabel(); // Icon
        teachersIcon.setIcon(new ImageIcon(getClass().getResource("Images/teachersIcon.png")));
        teachersIcon.setBounds(20, 0, 80, 60);
        navTeachersButton.add(teachersIcon);
        JLabel teachersText = new JLabel("TEACHERS"); // Text
        teachersText.setBounds(100, 0, 150, 60);
        teachersText.setForeground(Color.white);
        teachersText.setFont(new Font("Dialog", Font.BOLD, 18));
        navTeachersButton.add(teachersText);
        // intervention, threshold
        navIntThrButton = new JButton();
        navIntThrButton.addActionListener(e -> {
            if(e.getSource() == navIntThrButton){
                mainPanel.removeAll();
                mainPanel.add(new SetIntThr(auth));
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        navIntThrButton.setBorderPainted(false);
        navIntThrButton.setLayout(null);
        navIntThrButton.setPreferredSize(new Dimension(250, 60));
        navIntThrButton.setBackground(Color.decode("#02CE8F"));
        navDirPanel.add(navIntThrButton);
        JLabel intThrIcon = new JLabel(); // Icon
        intThrIcon.setIcon(new ImageIcon(getClass().getResource("Images/thresholdIcon.png")));
        intThrIcon.setBounds(20, 0, 80, 60);
        navIntThrButton.add(intThrIcon);
        JLabel intThrText = new JLabel("INTERVENTION"); // Text
        intThrText.setBounds(100, 0, 150, 30);
        intThrText.setForeground(Color.white);
        intThrText.setFont(new Font("Dialog", Font.BOLD, 15));
        navIntThrButton.add(intThrText);
        JLabel intThrText2 = new JLabel("THRESHOLD"); // Text
        intThrText2.setBounds(100, 30, 150, 30);
        intThrText2.setForeground(Color.white);
        intThrText2.setFont(new Font("Dialog", Font.BOLD, 15));
        navIntThrButton.add(intThrText2);

        // Nav Bottom Buttons Panel
        JPanel addRepPanel = new JPanel();
        addRepPanel.setBounds(25, 550, 200, 110);
        addRepPanel.setLayout(new GridLayout(2, 1, 0, 10));
        addRepPanel.setBackground(Color.decode("#02CE8F"));
        navPanel.add(addRepPanel);

        // Nav Buttom Buttons
        addStudentButton = new JButton("ADD STUDENT");
        addStudentButton.addActionListener(e -> {
            // ADD STUDENT
            if(e.getSource() == addStudentButton){
                mainPanel.removeAll();
                mainPanel.add(new AddStudentPanel(auth));
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        addStudentButton.setFont(new Font("Dialog", Font.BOLD, 20));
        addStudentButton.setForeground(Color.white);
        addStudentButton.setBackground(Color.decode("#373131"));
        addStudentButton.setBorderPainted(false);
        addRepPanel.add(addStudentButton);

        reportButton = new JButton("REPORT");
        reportButton.addActionListener(this);
        reportButton.setFont(new Font("Dialog", Font.BOLD, 20));
        reportButton.setForeground(Color.white);
        reportButton.setBackground(Color.decode("#373131"));
        reportButton.setBorderPainted(false);
        addRepPanel.add(reportButton);

        // RIGHT PANEL (MAIN CONTENT)
        mainPanel = new JPanel();
        mainPanel.setBounds(250, 0, 950, 800);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(null);
        mainPanel.add(new AddStudentPanel(auth));
        this.add(mainPanel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            // TEACHERS
            if(e.getSource() == navTeachersButton){
                mainPanel.removeAll();
                mainPanel.add(new TeachersPanel());
                mainPanel.revalidate();
                mainPanel.repaint();
            }

            // REPORT
            if(e.getSource() == reportButton){
                mainPanel.removeAll();
                mainPanel.add(new ReportPanel());
                mainPanel.revalidate();
                mainPanel.repaint();
            }


    }
}
