package pokemongame.battlegui.battleguilogic;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;
import pokemongame.battlegui.BattleGUI;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.Pokemon;
import pokemongame.trainer.Trainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

@Data
public class PokemonPanelLogic {
    private static PokemonPanelLogic instance;
    private static final BattleGUI battleGUI = BattleGUI.getInstance();
    private @NonNull Trainer trainer;
    private @Setter(AccessLevel.NONE) List<Pokemon> pokemonList;

    private PokemonPanelLogic() {
        battleGUI.getBottomPanel().getBtnPokemon().addActionListener(this::displayPokemonList);
        battleGUI.getMoveSummaryPanel().getBtnSelect().addActionListener(this::btnSelectPressed);

        // logic of pokemonList
        battleGUI.getPokemonPanel().getPokemonInfoPanel1().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showMoveSummary();
                battleGUI.getMoveSummaryPanel().getSummary(pokemonList.get(0));
            }
        });
        battleGUI.getPokemonPanel().getPokemonInfoPanel2().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showMoveSummary();
                battleGUI.getMoveSummaryPanel().getSummary(pokemonList.get(1));
            }
        });
        battleGUI.getPokemonPanel().getPokemonInfoPanel3().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showMoveSummary();
                battleGUI.getMoveSummaryPanel().getSummary(pokemonList.get(2));
            }
        });
        battleGUI.getPokemonPanel().getPokemonInfoPanel4().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showMoveSummary();
                battleGUI.getMoveSummaryPanel().getSummary(pokemonList.get(3));
            }
        });
        battleGUI.getPokemonPanel().getPokemonInfoPanel5().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showMoveSummary();
                battleGUI.getMoveSummaryPanel().getSummary(pokemonList.get(4));
            }
        });
        battleGUI.getPokemonPanel().getPokemonInfoPanel6().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showMoveSummary();
                battleGUI.getMoveSummaryPanel().getSummary(pokemonList.get(5));
            }
        });
    }

    public void setTrainer(@NotNull Trainer trainer) {
        this.trainer = trainer;
        this.pokemonList = trainer.pokemonList();
        displayPokemonList();
    }

    private void showMoveSummary() {
        battleGUI.getBottomPanel().setVisible(false);
        battleGUI.getPokemonPanel().setVisible(false);
        battleGUI.getMoveSummaryPanel().setVisible(true);
    }

    private void displayPokemonList() {
        battleGUI.getPokemonPanel().getPokemonInfoPanel1().setPokemon(getPokemonList().get(0));
        battleGUI.getPokemonPanel().getPokemonInfoPanel2().setPokemon(getPokemonList().get(1));
        battleGUI.getPokemonPanel().getPokemonInfoPanel3().setPokemon(getPokemonList().get(2));
        battleGUI.getPokemonPanel().getPokemonInfoPanel4().setPokemon(getPokemonList().get(3));
        battleGUI.getPokemonPanel().getPokemonInfoPanel5().setPokemon(getPokemonList().get(4));
        battleGUI.getPokemonPanel().getPokemonInfoPanel6().setPokemon(getPokemonList().get(5));
    }

    private void displayPokemonList(ActionEvent e) {
        displayPokemonList();
    }

    private void btnSelectPressed(ActionEvent e) {
        Pokemon pokemon = battleGUI.getMoveSummaryPanel().getPokemon();
        if (pokemon.getHitPoints() <= 0) {
            JOptionPane.showMessageDialog(battleGUI, pokemon.getName() +  " is fainted! Cannot send in battle!");
            return;
        }
        TopPanelLogic topPanelLogic = TopPanelLogic.getInstance();
        FightPanelLogic fightPanelLogic = FightPanelLogic.getInstance();

        topPanelLogic.setPlayerPokemon(pokemon);
        fightPanelLogic.setPokemon(topPanelLogic.getPlayerPokemon());
        battleGUI.getTopPanel().getPlayerPokemonInfo().setPokemon(pokemon);
        battleGUI.getTopPanel().getLblText().setText("Go! " + pokemon.getName().toUpperCase() + "!");

        battleGUI.getMoveSummaryPanel().setVisible(false);
        battleGUI.getPokemonPanel().setVisible(false);
        battleGUI.getBottomPanel().setVisible(true);
    }

    public static PokemonPanelLogic getInstance() {
        if (instance == null) instance = new PokemonPanelLogic();
        return instance;
    }
}
