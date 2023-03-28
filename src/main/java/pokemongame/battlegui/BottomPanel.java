package pokemongame.battlegui;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.swing.*;
import java.awt.*;

@Value
@EqualsAndHashCode(callSuper = true)
public class BottomPanel extends JPanel {
    PokeBallPanel pokeBallPanel = new PokeBallPanel();
    JButton btnFight = new JButton("Fight");
    JButton btnBag = new JButton("Bag");
    JButton btnRun = new JButton("Run");
    JButton btnPokemon = new JButton("Pokemon");

    BottomPanel() {
        this.setLayout(null);
        this.setBounds(0, 275, 400, 275);
        // Below this you can add components in BottomPanel

        btnFight.setBounds(70, 50, 250, 100);
        btnFight.setBackground(Color.RED);

        btnBag.setBounds(20, 160, 100, 70);
        btnBag.setBackground(Color.ORANGE);

        btnRun.setBounds(140, 180, 100, 60);
        btnRun.setBackground(Color.BLUE);

        btnPokemon.setBounds(260, 160, 100, 70);
        btnPokemon.setBackground(Color.GREEN);

        // !!!DONT FORGET TO ADD YOUR NEW COMPONENTS!!!
        this.add(pokeBallPanel);
        this.add(btnFight);
        this.add(btnBag);
        this.add(btnRun);
        this.add(btnPokemon);
    }
}
