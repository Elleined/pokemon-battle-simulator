package pokemongame.battlegui.battleguilogic;

import lombok.Value;
import pokemongame.attack.PokemonMove;
import pokemongame.attack.PokemonMoveHelper;
import pokemongame.battlefield.BattleCalculator;
import pokemongame.battlegui.BattleGUI;
import pokemongame.pokemon.Pokemon;
import pokemongame.trainer.Trainer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Value
public class SinglePlayerLogic {
    private static SinglePlayerLogic instance;
    int isSinglePlayer = JOptionPane.YES_OPTION; // means single player is on
    FightPanelLogic fightPanelLogic = FightPanelLogic.getInstance();

    private SinglePlayerLogic() {
        BattleGUI battleGUI = BattleGUI.getInstance();

        battleGUI.getMovePanel().getMoveInfoPanel1().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                fightPanelLogic.setPokemonMove(fightPanelLogic.getPokemon().useMove(fightPanelLogic.getMoveNameList().get(0)));
                singlePlayerLogic();
            }
        });
        battleGUI.getMovePanel().getMoveInfoPanel2().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                fightPanelLogic.setPokemonMove(fightPanelLogic.getPokemon().useMove(fightPanelLogic.getMoveNameList().get(1)));
                singlePlayerLogic();
            }
        });
        battleGUI.getMovePanel().getMoveInfoPanel3().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                fightPanelLogic.setPokemonMove(fightPanelLogic.getPokemon().useMove(fightPanelLogic.getMoveNameList().get(2)));
                singlePlayerLogic();
            }
        });
        battleGUI.getMovePanel().getMoveInfoPanel4().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                fightPanelLogic.setPokemonMove(fightPanelLogic.getPokemon().useMove(fightPanelLogic.getMoveNameList().get(3)));
                singlePlayerLogic();
            }
        });
    }

    private void singlePlayerLogic() {
        TopPanelLogic topPanelLogic = TopPanelLogic.getInstance();

        BattleCalculator battleCalculator = new BattleCalculator();

        Trainer player = topPanelLogic.getPlayer();
        Trainer enemy = topPanelLogic.getEnemy();
        BattleLogic.decideWinner(player, enemy);

        Pokemon playerPokemon = topPanelLogic.getPlayerPokemon();
        topPanelLogic.setPlayerPokemon(playerPokemon);
        Pokemon enemyPokemon = topPanelLogic.getEnemyPokemon();
        topPanelLogic.setEnemyPokemon(enemyPokemon);

        if (BattleLogic.checkHP(enemyPokemon) || BattleLogic.isAllMoveRunOutOfPP(enemyPokemon.getPokemonMove()))  {
            enemySwitching();
            return;
        }
        if (BattleLogic.checkHP(playerPokemon)) {
            playerSwitching();
            return;
        }
        if (BattleLogic.isRunOutOfUsableMoves(playerPokemon)) return;

        PokemonMove enemyMove = PokemonMoveHelper.pickRandomMoveFor(enemyPokemon);
        PokemonMove yourMove = fightPanelLogic.getPokemonMove();

        if (BattleLogic.checkPP(enemyMove)) PokemonMoveHelper.pickRandomMoveFor(enemyPokemon);
        if (BattleLogic.checkPP(yourMove)) return;
        battleCalculator.calculateAttackDamage(enemyPokemon, yourMove);
        battleCalculator.calculateAttackDamage(playerPokemon, enemyMove);
        topPanelLogic.setPlayerPokemon(playerPokemon);
        topPanelLogic.setEnemyPokemon(enemyPokemon);
        fightPanelLogic.displayMoveList();

        // Debugging purposes
        System.out.println("You used " + yourMove.getMoveName());
        System.out.println(yourMove);
        System.out.println("Enemy used " + enemyMove.getMoveName());
        System.out.println(enemyMove);
        System.out.println("------");
        System.out.println("Player " + playerPokemon);
        System.out.println("Enemy " + enemyPokemon);
    }

    private void enemySwitching() {
        TopPanelLogic topPanelLogic = TopPanelLogic.getInstance();

        Pokemon enemySwitchPokemon = topPanelLogic.getEnemy().pokemonList().stream()
                .filter(pokemon -> pokemon.getHitPoints() > 0)
                .findAny().orElseThrow();
        if (BattleLogic.isAllMoveRunOutOfPP(enemySwitchPokemon.getPokemonMove())) {
            enemySwitching();
            return;
        }
        topPanelLogic.setEnemyPokemon(enemySwitchPokemon);
    }

    private void playerSwitching() {
        TopPanelLogic topPanelLogic = TopPanelLogic.getInstance();

        Pokemon playerSwitchPokemon = topPanelLogic.getPlayer().pokemonList().stream()
                .filter(pokemon -> pokemon.getHitPoints() > 0)
                .findAny().orElseThrow();
        topPanelLogic.setPlayerPokemon(playerSwitchPokemon);
        fightPanelLogic.setPokemon(playerSwitchPokemon);
    }

    public static SinglePlayerLogic getInstance() {
        if (instance == null) instance = new SinglePlayerLogic();
        return instance;
    }
}
