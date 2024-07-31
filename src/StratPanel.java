import javax.swing.*;
import java.awt.*;

public class StratPanel extends JPanel {
    StratPanel(String strat){
        this.setPreferredSize(new Dimension(300, 30));
        JLabel stratLabel = new JLabel(strat);
        stratLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        stratLabel.setForeground(Color.white);
        this.add(stratLabel);
    }
}
