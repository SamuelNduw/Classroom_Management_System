import Authorization.Auth;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetThr extends JPanel implements ActionListener, ChangeListener {
    JLabel sliderValue;
    JSlider slider;

    SetThr(Auth auth){
        this.setBounds(0, 0, 950, 800);
        this.setLayout(null);
        this.setBackground(Color.decode("#787878"));
        JButton back = new JButton("BACK");
        back.setBounds(20, 20, 100, 50);
        back.setBackground(Color.decode("#373131"));
        back.setForeground(Color.white);
        back.addActionListener(e -> {
            this.removeAll();
            this.add(new SetIntThr(auth));
            this.revalidate();
            this.repaint();
        });
        this.add(back);
        JLabel setThreshold = new JLabel("SET THRESHOLD");
        setThreshold.setBounds(150, 20, 350, 50);
        setThreshold.setFont(new Font("Dialog", Font.BOLD, 40));

        slider = new JSlider(0,100,60);

        slider.setPreferredSize(new Dimension(400,200));
        slider.setBounds(275, 300, 400, 200);
        slider.setBackground(Color.white);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli",Font.PLAIN,15));
        slider.setOrientation(SwingConstants.HORIZONTAL);
        slider.addChangeListener(this);
        this.add(slider);

        sliderValue = new JLabel(String.valueOf(slider.getValue()));
        sliderValue.setBounds(600, 520, 50, 40);
        sliderValue.setForeground(Color.white);
        sliderValue.setFont(new Font("Dialog", Font.BOLD, 25));
        this.add(sliderValue);

        JButton set = new JButton("SET");
        set.setBounds(600, 570, 100, 40);
        set.setForeground(Color.white);
        set.setFont(new Font("Dialog", Font.BOLD, 25));
        set.setBackground(Color.decode("#373131"));
        set.addActionListener(e -> {
            DBConnection db = new DBConnection();
            db.setThreholdLimit(auth.getTeacherID(), slider.getValue());
            JOptionPane.showMessageDialog(null, "Successfully set a Threshold Limit of " + slider.getValue() + ".", null, JOptionPane.INFORMATION_MESSAGE);
        });
        this.add(set);



    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        sliderValue.setText(String.valueOf(slider.getValue()));
    }
}
