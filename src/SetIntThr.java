import Authorization.Auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetIntThr extends JPanel implements ActionListener {
    SetIntThr(Auth auth){
        this.setBounds(0, 0, 950, 800);
        this.setBackground(Color.decode("#787878"));
        this.setLayout(null);

        JLabel setInt = new JLabel("SET INTERVENTION STRATEGIES");
        setInt.setBounds(225, 50, 700, 50);
        setInt.setFont(new Font("Dialog", Font.BOLD, 40));
        setInt.setForeground(Color.WHITE);
        this.add(setInt);
        JLabel setThr = new JLabel("AND THRESHOLD");
        setThr.setBounds(225, 110, 400, 50);
        setThr.setFont(new Font("Dialog", Font.BOLD, 40));
        setThr.setForeground(Color.WHITE);
        this.add(setThr);

        JButton thrValue = new JButton("THRESHOLD VALUE");
        thrValue.setBounds(175, 320, 450, 40);
        thrValue.setBackground(Color.decode("#373131"));
        thrValue.setForeground(Color.WHITE);
        thrValue.setFont(new Font("Dialog", Font.BOLD, 25));
        thrValue.addActionListener(e -> {
            this.removeAll();
            this.add(new SetThr(auth));
            this.revalidate();
            this.repaint();
        });
        this.add(thrValue);
        JButton intStra = new JButton("INTERVENTION STRATEGIES");
        intStra.setBounds(175, 390, 450, 40);
        intStra.setBackground(Color.decode("#373131"));
        intStra.setForeground(Color.WHITE);
        intStra.setFont(new Font("Dialog", Font.BOLD, 25));
        intStra.addActionListener(e -> {

        });
        this.add(intStra);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
