package pokemongame.battlegui;

import lombok.Getter;
import pokemongame.attack.PokemonMove;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MoveInfoPanel extends JPanel {
    private @Getter PokemonMove move;
    private final JLabel lblMoveName = new JLabel();
    private final JLabel lblMoveType = new JLabel();
    private final JLabel lblMovePP = new JLabel();

    public MoveInfoPanel(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);

        lblMoveName.setBounds(50, 5, 150, 30);

        lblMoveType.setBounds(20, 35, 100, 30);

        lblMovePP.setBounds(100, 35, 150, 30);

        // !!!DONT FORGET TO ADD YOUR NEW COMPONENTS!!!
        this.add(lblMoveName);
        this.add(lblMoveType);
        this.add(lblMovePP);
    }

    public void setMove(@NotNull PokemonMove move) {
        this.move = move;

        lblMoveName.setText(move.getMoveName());
        lblMoveType.setText(move.getMoveType().name());
        lblMovePP.setText("PP " + move.getMovePowerPoints() + '/' + move.getMovePowerPoints());
    }

}
