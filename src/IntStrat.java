import Authorization.Auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class IntStrat extends JFrame implements ActionListener {
    int count;
    IntStratItem strategy;
    IntStrat(Auth auth){
        this.setSize(500, 700);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("ADD INTERVENTION STATEGIES");
        this.setResizable(false);
        this.setLayout(null);

        // Main Panel
        JPanel main = new JPanel();
        main.setBounds(0, 0, 500, 500);
        main.setBackground(Color.decode("#787878"));
        main.setLayout(null);
        this.add(main);

        // Label
        JLabel setInt = new JLabel("SET 10 INTERVENTION STRATEGIES");
        setInt.setBounds(50, 50, 400, 50);
        setInt.setForeground(Color.white);
        setInt.setFont(new Font("Dialog", Font.BOLD, 20));
        this.add(setInt);

        // initialization of array list
        int teacherID = auth.getTeacherID();
        ArrayList<IntStratItem> strategies = new ArrayList<IntStratItem>();
        count = 0;


        // Textfield
        PlaceholderTextField inputStrat = new PlaceholderTextField("STRATEGY");
        inputStrat.setBounds(200, 150, 100, 30);
        this.add(inputStrat);

        // Strategies Panel
        JPanel stratsPanel = new JPanel();
        stratsPanel.setBounds(50, 240, 400, 390);
        stratsPanel.setLayout(new GridLayout(10, 1, 0, 10));
        this.add(stratsPanel);

        // ADD BUTTON
        JButton addButton = new JButton("ADD");
        addButton.setBounds(130, 200, 70, 30);
        addButton.setBackground(Color.decode("#02CE8F"));
        addButton.setFont(new Font("Dialog", Font.BOLD, 18));
        addButton.addActionListener(e ->{
            if(e.getSource() == addButton){
                if(inputStrat.equals("STRATEGY") || inputStrat.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Text field is empty, please type a strategy and add!", "Error Adding Strategy", JOptionPane.ERROR_MESSAGE);
                }else{
                    if(strategies.size() == 10){
                        JOptionPane.showMessageDialog(null, "You have set 10 strategies, that is the limit.", "Error Adding Strategy", JOptionPane.ERROR_MESSAGE);
                    }else {
                        strategy = new IntStratItem(teacherID, inputStrat.getText());
                        int stratsSize = strategies.size();
                        strategies.add(strategy);
                        stratsPanel.removeAll();
                        for(IntStratItem i : strategies){
                            stratsPanel.add(new StratPanel(i.getStratDescription()));
                        }
                        addButton.setText("ADD(" + stratsSize + ")");
                        stratsPanel.revalidate();
                        stratsPanel.repaint();
                        count++;
                        if(count == 10){
                            addButton.setBackground(Color.red);
                            addButton.setForeground(Color.white);
                        }
                    }
                }


            }
        });
        this.add(addButton);

        // SUBMIT BUTTON
        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(215, 650, 70, 30);
        submitButton.setBackground(Color.decode("#02CE8F"));
        submitButton.setFont(new Font("Dialog", Font.BOLD, 18));
        submitButton.addActionListener(e ->{
            if(e.getSource() == submitButton){
                DBConnection db = new DBConnection();
                for(IntStratItem j : strategies){
                    db.insertStrategy(auth.getTeacherID(), j.getStratDescription());
                }
            }
        });
        this.add(submitButton);


        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
