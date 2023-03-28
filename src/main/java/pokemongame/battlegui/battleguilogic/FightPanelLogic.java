package pokemongame.battlegui.battleguilogic;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import pokemongame.attack.PokemonMove;
import pokemongame.battlegui.BattleGUI;
import pokemongame.pokemon.Pokemon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class FightPanelLogic {
    private static FightPanelLogic instance;
    private static final BattleGUI battleGUI = BattleGUI.getInstance();
    private @Getter Pokemon pokemon;

    @Getter(AccessLevel.PACKAGE) @Setter(AccessLevel.PACKAGE)
    private PokemonMove pokemonMove;

    @Getter(AccessLevel.PRIVATE) @Setter(AccessLevel.NONE)
    private List<PokemonMove> pokemonMoveList;

    private FightPanelLogic() {
        battleGUI.getBottomPanel().getBtnFight().addActionListener(this::displayMoveList);
    }

    List<String> getMoveNameList() {
        return pokemonMoveList.stream()
                .map(PokemonMove::getMoveName)
                .toList();
    }

    void displayMoveList() {
        battleGUI.getMovePanel().getMoveInfoPanel1().setMove(getPokemonMoveList().get(0));
        battleGUI.getMovePanel().getMoveInfoPanel2().setMove(getPokemonMoveList().get(1));
        battleGUI.getMovePanel().getMoveInfoPanel3().setMove(getPokemonMoveList().get(2));
        battleGUI.getMovePanel().getMoveInfoPanel4().setMove(getPokemonMoveList().get(3));
    }

    public void setPokemon(@NonNull Pokemon pokemon) {
        battleGUI.getTopPanel().getLblText().setText("What will " + pokemon.getName() + " do?");
        if (pokemon.getHitPoints() <= 0) {
            JOptionPane.showMessageDialog(battleGUI, pokemon.getName() +  " is fainted! Cannot send in battle!");
            return;
        }
        this.pokemon = pokemon;
        this.pokemonMoveList = pokemon.getPokemonMove();
        displayMoveList();
    }

    private void displayMoveList(ActionEvent e) {
        displayMoveList();
    }

    public static FightPanelLogic getInstance() {
        if (instance == null) instance = new FightPanelLogic();
        return instance;
    }
}
