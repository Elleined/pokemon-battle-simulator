package pokemongame.battlegui.battleguilogic;

import pokemongame.attack.PokemonMove;
import pokemongame.battlegui.BattleGUI;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.Pokemon;
import pokemongame.trainer.Trainer;

import javax.swing.*;
import java.util.List;

public interface BattleLogic {

    static boolean checkPP(@NotNull PokemonMove pokemonMove) {
        if (pokemonMove.getMovePowerPoints() == 0) {
            JOptionPane.showMessageDialog(BattleGUI.getInstance(), "Run out of PP! Cant use this move...");
            return true;
        }
        return false;
    }

    static boolean checkHP(@NotNull Pokemon target) {
        if (target.getHitPoints() <= 0) {
            JOptionPane.showMessageDialog(BattleGUI.getInstance(),target.getName() + " is fainted! ");
            return true;
        }
        return false;
    }

    static boolean isAllPokemonFainted(@NotNull List<Pokemon> pokemonList) {
        return pokemonList.stream().allMatch(pokemon -> pokemon.getHitPoints() <= 0);
    }

    static boolean isAllMoveRunOutOfPP(@NotNull List<PokemonMove> pokemonMoves) {
        return pokemonMoves.stream()
                .map(PokemonMove::getMovePowerPoints)
                .allMatch(i -> i.equals(0));
    }

    static void decideWinner(@NotNull Trainer player, @NotNull Trainer enemy) {
        List<PokemonMove> playerPokemonMoves = player.getAllMoves();
        List<PokemonMove> enemyPokemonMoves = enemy.getAllMoves();
        if (isAllPokemonFainted(player.pokemonList()) || isAllMoveRunOutOfPP(playerPokemonMoves)) {
            BattleGUI.getInstance().getEndPanel().getLblMessage().setText("You Lose!!!");
            BattleGUI.getInstance().getEndPanel().getLblInfoMessage().setText("Enemy fainted all your pokemon!");
            RoutingPanelLogic.showEndPanel();
        } else if (isAllPokemonFainted(enemy.pokemonList()) || isAllMoveRunOutOfPP(enemyPokemonMoves)) {
            BattleGUI.getInstance().getEndPanel().getLblMessage().setText("Congratulations You Win!!!");
            BattleGUI.getInstance().getEndPanel().getLblInfoMessage().setText("You fainted all enemy pokemon!");
            RoutingPanelLogic.showEndPanel();
        }
    }

    static boolean isRunOutOfUsableMoves(@NotNull Pokemon pokemon) {
        if (BattleLogic.isAllMoveRunOutOfPP(pokemon.getPokemonMove())) {
            JOptionPane.showMessageDialog(BattleGUI.getInstance(), pokemon.getName() + " is run out of usable move, switch out pokemon");
            return true;
        }
        return false;
    }
}
