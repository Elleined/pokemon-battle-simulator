package pokemongame.battlegui;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Value
@EqualsAndHashCode(callSuper = true)
public class PokeBallPanel extends JPanel {
    JLabel ball1 = new JLabel();
    JLabel ball2 = new JLabel();
    JLabel ball3 = new JLabel();
    JLabel ball4 = new JLabel();
    JLabel ball5 = new JLabel();
    JLabel ball6 = new JLabel();

    public PokeBallPanel() {
        this.setLayout(null);
        this.setBounds(10, 0, 125, 30);
        Icon pokeball = new ImageIcon(Objects.requireNonNull(getClass().getResource("/pokeball.png")));

        ballPocket().forEach(ball -> ball.setIcon(pokeball));
        ball1.setBounds(5, 10, 20, 20);
        ball2.setBounds(25, 10, 20, 20);
        ball3.setBounds(45, 10, 20, 20);
        ball4.setBounds(65, 10, 20, 20);
        ball5.setBounds(85, 10, 20, 20);
        ball6.setBounds(105, 10, 20, 20);

        // !!!DONT FORGET TO ADD YOUR NEW COMPONENTS!!!
        ballPocket().forEach(this::add);
    }

    public List<JLabel> ballPocket() {
        return Arrays.asList(ball1, ball2, ball3, ball4, ball5, ball6);
    }
}
