package pokemongame.battlegui;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.swing.*;
import java.awt.*;

@Value
@EqualsAndHashCode(callSuper = true)
public class EndPanel extends JPanel {
    JLabel lblMessage = new JLabel();
    JLabel lblInfoMessage = new JLabel();

    public EndPanel() {
        this.setLayout(null);
        this.setBounds(0, 0, 400, 550);
        this.setBackground(Color.BLUE);

        lblMessage.setBounds(30, 225, 380, 50);
        lblMessage.setFont(new Font("Cambria", Font.BOLD, 25));

        lblInfoMessage.setBounds(30, 150, 380, 50);
        lblInfoMessage.setFont(new Font("Cambria", Font.BOLD, 20));

        // !!!DONT FORGET TO ADD YOUR NEW COMPONENTS!!!
        this.add(lblMessage);
        this.add(lblInfoMessage);
    }
}
