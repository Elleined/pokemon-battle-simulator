package pokemongame.battlegui;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

import javax.swing.*;
import java.awt.*;

import static javax.swing.plaf.basic.BasicBorders.ButtonBorder;

@Value
@EqualsAndHashCode(callSuper = true)
@Getter
public class TopPanel extends JPanel {
    PokemonInfoPanel enemyPokemonInfo;
    PokemonInfoPanel playerPokemonInfo;
    JLabel lblText = new JLabel();

    public TopPanel() {
        this.setLayout(null);
        this.setBounds(0, 0, 400, 275);
        // Below this you can add components in TopPanel
        playerPokemonInfo = new PokemonInfoPanel(220, 150, 170, 50);
        enemyPokemonInfo = new PokemonInfoPanel(0, 20, 170, 50);

        lblText.setBounds(10, 215, 360, 60);
        lblText.setBorder(new ButtonBorder(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));

        // !!!DONT FORGET TO ADD YOUR NEW COMPONENTS!!!
        this.add(enemyPokemonInfo);
        this.add(playerPokemonInfo);
        this.add(lblText);
    }
}
