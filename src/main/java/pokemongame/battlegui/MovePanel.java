package pokemongame.battlegui;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class MovePanel extends JPanel {
    MoveInfoPanel moveInfoPanel1;
    MoveInfoPanel moveInfoPanel2;
    MoveInfoPanel moveInfoPanel3;
    MoveInfoPanel moveInfoPanel4;
    JButton cancel = new JButton("Cancel");

    public MovePanel() {
        this.setLayout(null);
        this.setBounds(0, 275, 400, 275);
        this.setBackground(Color.cyan);

        moveInfoPanel1 = new MoveInfoPanel(10, 20, 170, 70);
        moveInfoPanel2 = new MoveInfoPanel(200, 20, 170, 70);
        moveInfoPanel3 = new MoveInfoPanel(10, 110, 170, 70);
        moveInfoPanel4 = new MoveInfoPanel(200, 110, 170, 70);
        cancel.setBounds(10, 190, 360, 50);
        // !!!DONT FORGET TO ADD YOUR NEW COMPONENTS!!!
        this.add(moveInfoPanel1);
        this.add(moveInfoPanel2);
        this.add(moveInfoPanel3);
        this.add(moveInfoPanel4);
        this.add(cancel);
    }

    public List<MoveInfoPanel> getMoveInfoPanels() {
        return Arrays.asList(moveInfoPanel1, moveInfoPanel2, moveInfoPanel3, moveInfoPanel4);
    }

}
