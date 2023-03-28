package pokemongame.battlegui;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.util.Objects;

@Value
@EqualsAndHashCode(callSuper = true)
public class PokemonPanel extends JPanel {
    PokemonInfoPanel pokemonInfoPanel1;
    PokemonInfoPanel pokemonInfoPanel2;
    PokemonInfoPanel pokemonInfoPanel3;
    PokemonInfoPanel pokemonInfoPanel4;
    PokemonInfoPanel pokemonInfoPanel5;
    PokemonInfoPanel pokemonInfoPanel6;

    JLabel lblText = new JLabel();
    JButton btnBack = new JButton();

    public PokemonPanel() {
        this.setLayout(null);
        this.setBounds(0, 275, 400, 275);
        this.setBackground(Color.lightGray);

        pokemonInfoPanel1 = new PokemonInfoPanel(10, 20, 170, 50);
        pokemonInfoPanel2 = new PokemonInfoPanel(200, 20, 170, 50);
        pokemonInfoPanel3 = new PokemonInfoPanel(10, 80, 170, 50);
        pokemonInfoPanel4 = new PokemonInfoPanel(200, 80, 170, 50);
        pokemonInfoPanel5 = new PokemonInfoPanel(10, 140, 170, 50);
        pokemonInfoPanel6 = new PokemonInfoPanel(200, 140, 170, 50);

        lblText.setText("Choose a Pokemon.");
        lblText.setBounds(10, 200, 300, 40);
        lblText.setBorder(new BasicBorders.ButtonBorder(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));

        btnBack.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/back.png"))));
        btnBack.setBounds(320, 200, 50, 40);

        // !!!DONT FORGET TO ADD YOUR NEW COMPONENTS!!!
        this.add(pokemonInfoPanel1);
        this.add(pokemonInfoPanel2);
        this.add(pokemonInfoPanel3);
        this.add(pokemonInfoPanel4);
        this.add(pokemonInfoPanel5);
        this.add(pokemonInfoPanel6);
        this.add(lblText);
        this.add(btnBack);
    }
}
