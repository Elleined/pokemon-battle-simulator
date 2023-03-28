package pokemongame.battlegui;

import lombok.Getter;
import pokemongame.pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MoveSummaryPanel extends JPanel {
    private @Getter Pokemon pokemon;
    private final MovePanel movePanel = new MovePanel();
    private final PokemonInfoPanel pokemonInfoPanel = new PokemonInfoPanel(0, 10, 400, 50);
    private final @Getter JButton btnBack = new JButton();
    private final @Getter JButton btnSelect = new JButton("Select pokemon");

    public MoveSummaryPanel() {
        this.setLayout(null);
        this.setBounds(0, 275, 400, 275);
        this.setBackground(Color.cyan);

        pokemonInfoPanel.getLblPokemonName().setBounds(15, 0, 100, 30);
        pokemonInfoPanel.setBackground(Color.yellow);

        movePanel.setBounds(0, 50, 400, 150);
        movePanel.getMoveInfoPanel1().setBounds(10, 20, 170, 60);
        movePanel.getMoveInfoPanel2().setBounds(200, 20, 170, 60);
        movePanel.getMoveInfoPanel3().setBounds(10, 90, 170, 60);
        movePanel.getMoveInfoPanel4().setBounds(200, 90, 170, 60);

        btnBack.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/back.png"))));
        btnBack.setBounds(320, 210, 50, 30);

        btnSelect.setBounds(10, 210, 300, 30);

        // !!!DONT FORGET TO ADD YOUR NEW COMPONENTS!!!
        this.add(pokemonInfoPanel);
        this.add(movePanel);
        this.add(btnBack);
        this.add(btnSelect);
    }

    public void getSummary(Pokemon pokemon) {
        this.pokemon = pokemon;
        pokemonInfoPanel.setPokemon(pokemon);
        movePanel.getMoveInfoPanel1().setMove(pokemon.getPokemonMove().get(0));
        movePanel.getMoveInfoPanel2().setMove(pokemon.getPokemonMove().get(1));
        movePanel.getMoveInfoPanel3().setMove(pokemon.getPokemonMove().get(2));
        movePanel.getMoveInfoPanel4().setMove(pokemon.getPokemonMove().get(3));
    }
}
