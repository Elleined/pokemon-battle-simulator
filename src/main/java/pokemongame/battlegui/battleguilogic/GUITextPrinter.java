package pokemongame.battlegui.battleguilogic;

import pokemongame.battlegui.BattleGUI;

import javax.swing.*;

public interface GUITextPrinter {

    static void displayMissedMessage() {
        FightPanelLogic fightPanelLogic = FightPanelLogic.getInstance();
        JOptionPane.showMessageDialog(BattleGUI.getInstance(), "Oooopss..." + fightPanelLogic.getPokemon().getName() + " missed move " + fightPanelLogic.getPokemonMove() .getMoveName() + "!!!");
    }
}
