package pokemongame.battlegui;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.swing.*;

@Value
@EqualsAndHashCode(callSuper = true)
public class BattleGUI extends JFrame {
    static BattleGUI battleGUI;
    TopPanel topPanel = new TopPanel();
    BottomPanel bottomPanel = new BottomPanel();
    MovePanel movePanel = new MovePanel();
    PokemonPanel pokemonPanel = new PokemonPanel();
    MoveSummaryPanel moveSummaryPanel = new MoveSummaryPanel();
    EndPanel endPanel = new EndPanel();

    private BattleGUI() {
        movePanel.setVisible(false);
        pokemonPanel.setVisible(false);
        moveSummaryPanel.setVisible(false);
        endPanel.setVisible(false);

        // !!!DONT FORGET TO ADD YOUR NEW COMPONENTS!!!
        this.add(topPanel);
        this.add(bottomPanel);
        this.add(movePanel);
        this.add(pokemonPanel);
        this.add(moveSummaryPanel);
        this.add(endPanel);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(400, 550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static BattleGUI getInstance() {
        if (battleGUI == null) battleGUI = new BattleGUI();
        return battleGUI;
    }
}
