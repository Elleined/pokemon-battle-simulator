package pokemongame.battlegui.battleguilogic;

import pokemongame.battlegui.BattleGUI;

import java.awt.event.ActionEvent;

public class RoutingPanelLogic {
    private static final BattleGUI battleGUI = BattleGUI.getInstance();

    public RoutingPanelLogic() {
        // Show movePanel after clicking fight button
        battleGUI.getBottomPanel().getBtnFight().addActionListener(this::btnFightPressed);

        // Hide movePanel after clicking the cancel button
        battleGUI.getMovePanel().getCancel().addActionListener(this::btnCancelPressed);

        // Show pokemonPanel after clicking Pokémon button
        battleGUI.getBottomPanel().getBtnPokemon().addActionListener(this::btnPokemonPressed);

        // Hide pokemonPanel after clicking back button
        battleGUI.getPokemonPanel().getBtnBack().addActionListener(this::btnBackPressed);

        // Hide moveSummaryPanel after clicking back button
        battleGUI.getMoveSummaryPanel().getBtnBack().addActionListener(this::btnHidePressed);
    }

    private void btnFightPressed(ActionEvent e) {
        battleGUI.getMovePanel().setVisible(true);
        battleGUI.getBottomPanel().setVisible(false);
    }

    private void btnCancelPressed(ActionEvent e) {
        battleGUI.getMovePanel().setVisible(false);
        battleGUI.getBottomPanel().setVisible(true);
    }

    private void btnPokemonPressed(ActionEvent e) {
        battleGUI.getPokemonPanel().setVisible(true);
        battleGUI.getBottomPanel().setVisible(false);
    }

    private void btnBackPressed(ActionEvent e) {
        battleGUI.getPokemonPanel().setVisible(false);
        battleGUI.getBottomPanel().setVisible(true);
    }

    private void btnHidePressed(ActionEvent e) {
        battleGUI.getBottomPanel().setVisible(false);
        battleGUI.getPokemonPanel().setVisible(true);
        battleGUI.getMoveSummaryPanel().setVisible(false);
    }

    public static void showEndPanel() {
        BattleGUI.getInstance().getMoveSummaryPanel().setVisible(false);
        BattleGUI.getInstance().getMovePanel().setVisible(false);
        BattleGUI.getInstance().getTopPanel().setVisible(false);
        BattleGUI.getInstance().getBottomPanel().setVisible(false);
        BattleGUI.getInstance().getPokemonPanel().setVisible(false);
        BattleGUI.getInstance().getEndPanel().setVisible(true);
    }
}
