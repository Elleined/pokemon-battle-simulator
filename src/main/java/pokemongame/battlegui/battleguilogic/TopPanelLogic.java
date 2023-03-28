package pokemongame.battlegui.battleguilogic;

import lombok.*;
import pokemongame.battlefield.BattleField;
import pokemongame.battlegui.BattleGUI;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.Pokemon;
import pokemongame.trainer.Trainer;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TopPanelLogic {
    private static TopPanelLogic instance;
    private static final BattleGUI battleGUI = BattleGUI.getInstance();
    private @NonNull BattleField battleField;
    private Trainer enemy;
    private Trainer player;
    private Pokemon enemyPokemon;
    private Pokemon playerPokemon;

    public void setBattleField(@NotNull BattleField battleField) {
        this.battleField = battleField;
        this.enemy = battleField.getBattleTrainers().get(0);
        this.player = battleField.getBattleTrainers().get(1);
        this.enemyPokemon = enemy.pokemonList().get(0);
        this.playerPokemon = player.pokemonList().get(0);
        battleGUI.setTitle(battleField.getName());
        displayPokemonInfo();
    }

    public void setPlayer(@NotNull Trainer player) {
        this.player = player;
        displayPokemonInfo();
    }

    public void setEnemy(@NotNull Trainer enemy) {
        this.enemy = enemy;
        displayPokemonInfo();
    }

    public void setEnemyPokemon(Pokemon enemyPokemon) {
        this.enemyPokemon = enemyPokemon;
        displayPokemonInfo();
    }

    public void setPlayerPokemon(Pokemon playerPokemon) {
        this.playerPokemon = playerPokemon;
        displayPokemonInfo();
    }

    private void displayPokemonInfo() {
        battleGUI.getTopPanel().getEnemyPokemonInfo().setPokemon(getEnemyPokemon());
        battleGUI.getTopPanel().getPlayerPokemonInfo().setPokemon(getPlayerPokemon());
    }

    public static TopPanelLogic getInstance() {
        if (instance == null) instance = new TopPanelLogic();
        return instance;
    }
}
