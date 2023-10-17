import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInUpFrame extends JFrame implements ActionListener {
    private String placeholderFirstName = "First Name";
    JButton join;
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
        JPanel signInUpPanel = new JPanel();
        signInUpPanel.setBounds(350, 0, 450, 600);
        signInUpPanel.setBackground(Color.decode("#787878"));
        signInUpPanel.setLayout(null);

        // sign in or sign up Label
        JLabel sign = new JLabel("SIGN IN or SIGN UP");
        sign.setBounds(75, 60, 300, 50);
        sign.setFont(new Font("Dialog", Font.BOLD, 30));
        sign.setForeground(Color.WHITE);
        signInUpPanel.add(sign);

        // Form input fields
        PlaceholderTextField first_name = new PlaceholderTextField("First Name");
        first_name.setBounds(65, 180, 310, 30);
        PlaceholderTextField last_name = new PlaceholderTextField("Last Name");
        last_name.setBounds(65, 230, 310, 30);
        PlaceholderTextField email = new PlaceholderTextField("Email");
        email.setBounds(65, 280, 310, 30);
        PlaceholderTextField subject = new PlaceholderTextField("Subject");
        subject.setBounds(65, 330, 310, 30);
        signInUpPanel.add(first_name);
        signInUpPanel.add(last_name);
        signInUpPanel.add(email);
        signInUpPanel.add(subject);

        // Form Join button
        join = new JButton("JOIN");
        join.setBounds(125, 400, 200, 35);
        join.setFont(new Font("SansSerif", Font.BOLD, 18));
        join.setBackground(Color.decode("#02CE8F"));
        join.setForeground(Color.WHITE);
        join.addActionListener(this);
        signInUpPanel.add(join);

        // button to take initial focus, so that textfield placeholders can show
        JButton focusInitialButton = new JButton();
        focusInitialButton.setBounds(450, 0, 0, 0);
        focusInitialButton.requestFocusInWindow();
        signInUpPanel.add(focusInitialButton);



        this.add(mottoPanel);
        this.add(signInUpPanel);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == join){
            this.dispose();
            new MainFrame();
        }
    }
}
