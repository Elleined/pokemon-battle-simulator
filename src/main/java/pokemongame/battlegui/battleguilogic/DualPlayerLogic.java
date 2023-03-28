package pokemongame.battlegui.battleguilogic;

import lombok.Value;
import pokemongame.battlefield.BattleCalculator;
import pokemongame.battlegui.BattleGUI;
import pokemongame.pokemon.Pokemon;
import pokemongame.trainer.Trainer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Value
public class DualPlayerLogic {
    private static DualPlayerLogic instance;
    int isDualPlayer = JOptionPane.NO_OPTION; // means dual player is on
    FightPanelLogic fightPanelLogic = FightPanelLogic.getInstance();

    private DualPlayerLogic() {
        BattleGUI battleGUI = BattleGUI.getInstance();
        battleGUI.getMovePanel().getMoveInfoPanel1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fightPanelLogic.setPokemonMove(fightPanelLogic.getPokemon().useMove(fightPanelLogic.getMoveNameList().get(0)));
                dualPLayerLogic();
            }
        });
        battleGUI.getMovePanel().getMoveInfoPanel2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fightPanelLogic.setPokemonMove(fightPanelLogic.getPokemon().useMove(fightPanelLogic.getMoveNameList().get(1)));
                dualPLayerLogic();
            }
        });
        battleGUI.getMovePanel().getMoveInfoPanel3().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fightPanelLogic.setPokemonMove(fightPanelLogic.getPokemon().useMove(fightPanelLogic.getMoveNameList().get(2)));
                dualPLayerLogic();
            }
        });
        battleGUI.getMovePanel().getMoveInfoPanel4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fightPanelLogic.setPokemonMove(fightPanelLogic.getPokemon().useMove(fightPanelLogic.getMoveNameList().get(3)));
                dualPLayerLogic();
            }
        });
    }

    private void dualPLayerLogic() {
        TopPanelLogic topPanelLogic = TopPanelLogic.getInstance();
        PokemonPanelLogic pokemonPanelLogic = PokemonPanelLogic.getInstance();

        Trainer player = topPanelLogic.getPlayer();
        Trainer enemy = topPanelLogic.getEnemy();
        BattleLogic.decideWinner(player, enemy);

        Pokemon playerPokemon = topPanelLogic.getPlayerPokemon();
        Pokemon enemyPokemon = topPanelLogic.getEnemyPokemon();
        if (BattleLogic.checkHP(playerPokemon) || BattleLogic.isRunOutOfUsableMoves(playerPokemon)) return;

        BattleCalculator battleCalculator = new BattleCalculator();
        if (BattleLogic.checkPP(fightPanelLogic.getPokemonMove())) return;
        battleCalculator.calculateAttackDamage(enemyPokemon, fightPanelLogic.getPokemonMove());

        topPanelLogic.setPlayer(enemy);
        topPanelLogic.setEnemy(player);
        topPanelLogic.setPlayerPokemon(enemyPokemon);
        topPanelLogic.setEnemyPokemon(playerPokemon);

        fightPanelLogic.setPokemon(topPanelLogic.getPlayerPokemon());
        pokemonPanelLogic.setTrainer(topPanelLogic.getPlayer());
        fightPanelLogic.displayMoveList();

        // Debugging purposes
        System.out.println("You used " + fightPanelLogic.getPokemonMove().getMoveName());
        System.out.println(fightPanelLogic.getPokemonMove());
        System.out.println("------");
        System.out.println("Player " + playerPokemon);
        System.out.println("Enemy " + enemyPokemon);
    }

    public static DualPlayerLogic getInstance() {
        if (instance == null) instance = new DualPlayerLogic();
        return instance;
    }
}
