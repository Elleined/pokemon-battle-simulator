package pokemongame.battlegui;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.Gender;
import pokemongame.pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Getter
public class PokemonInfoPanel extends JPanel {
    private Pokemon pokemon;
    private final JLabel lblPokemonName = new JLabel();
    private final JLabel lblPokemonLevel = new JLabel();
    private final JLabel lblPokemonGender = new JLabel();
    private final JLabel lblPokemonHealth = new JLabel();

    public PokemonInfoPanel(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setBackground(Color.GREEN);

        // Displaying Pokemon Name
        lblPokemonName.setBounds(5, 0, 100, 30);

        // Displaying Pokemon Level
        lblPokemonLevel.setBounds(120, 0, 100, 30);

        // Displaying Pokemon Gender
        lblPokemonGender.setBounds(105, 0, 70, 30);

        // Displaying PokemonHP
        lblPokemonHealth.setBounds(50, 20, 50, 30);

        // !!!DONT FORGET TO ADD YOUR NEW COMPONENTS!!!
        this.add(lblPokemonName);
        this.add(lblPokemonLevel);
        this.add(lblPokemonGender);
        this.add(lblPokemonHealth);
    }

    public void setPokemon(@NotNull Pokemon pokemon) {
        this.pokemon = pokemon;
        lblPokemonName.setText(pokemon.getName());
        lblPokemonLevel.setText("Lv." + Pokemon.getLVL());

        Icon male = new ImageIcon(Objects.requireNonNull(getClass().getResource("/male.png")));
        Icon female = new ImageIcon(Objects.requireNonNull(getClass().getResource("/female.png")));
        lblPokemonGender.setIcon(pokemon.getGender() == Gender.MALE ? male : female);

        int showHP = Math.max(pokemon.getHitPoints(), 0);
        lblPokemonHealth.setText("HP: " + showHP);
    }
}
