import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInUpFrame extends JFrame implements ActionListener {
    JPanel signInUpPanel;
    JButton signUp;
    private String placeholderFirstName = "First Name";
    private JButton signIn;

    SignInUpFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800, 600);
        this.setTitle("Classroom Management");
        this.setResizable(false);

        // LEFT PANEL
        JPanel mottoPanel = new JPanel();
        mottoPanel.setBounds(0, 0, 350, 600);
        mottoPanel.setBackground(Color.decode("#02CE8F"));
        mottoPanel.setLayout(null);

        JLabel mottoLabel = new JLabel("Manage your class today");
        mottoLabel.setBounds(45, 60, 300, 40);
        mottoLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
        mottoLabel.setForeground(Color.WHITE);
        mottoPanel.add(mottoLabel);

        JLabel userIconLabel = new JLabel();
        ImageIcon userIcon = new ImageIcon(getClass().getResource("Images/userIcon.png"));
        userIconLabel.setIcon(userIcon);
        userIconLabel.setBounds(63, 185, 225, 225);
        mottoPanel.add(userIconLabel);

        // RIGHT PANEL
        signInUpPanel = new JPanel();
        signInUpPanel.setBounds(350, 0, 450, 600);
        signInUpPanel.setBackground(Color.decode("#787878"));
        signInUpPanel.setLayout(null);

        JLabel topRightLabel = new JLabel("CLASSROOM MANAGEMENT");
        topRightLabel.setBounds(40, 70, 400, 60);
        topRightLabel.setFont(new Font("Dialog", Font.BOLD, 25));
        topRightLabel.setForeground(Color.WHITE);
        signInUpPanel.add(topRightLabel);

        signIn = new JButton("SIGN IN");
        signIn.setBounds(145, 250, 130, 40);
        signIn.setBackground(Color.decode("#FFFFFF"));
        signIn.setFont(new Font("Dialog", Font.BOLD, 18));
        signIn.addActionListener(this);
        signInUpPanel.add(signIn);
        signUp = new JButton("SIGN UP");
        signUp.setBounds(145, 310, 130, 40);
        signUp.setBackground(Color.decode("#02CE8F"));
        signUp.setFont(new Font("Dialog", Font.BOLD, 18));
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        signInUpPanel.add(signUp);


        this.add(mottoPanel);
        this.add(signInUpPanel);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signIn){
            signInUpPanel.removeAll();
            signInUpPanel.add(new SignInPanel());
            signInUpPanel.revalidate();
            signInUpPanel.repaint();
        }
        if(e.getSource() == signUp){
            signInUpPanel.removeAll();
            signInUpPanel.add(new SignUpPanel());
            signInUpPanel.revalidate();
            signInUpPanel.repaint();
        }
    }
}
