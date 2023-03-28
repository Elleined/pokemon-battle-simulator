package pokemongame.battlefield;

import lombok.Value;
import pokemongame.attack.PokemonMove;
import pokemongame.battlegui.battleguilogic.GUITextPrinter;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.Pokemon;

import java.util.Random;

@Value
public class BattleCalculator {
    WeaknessCalculator weaknessCalculator = new WeaknessCalculator();
    StrengthCalculator strengthCalculator = new StrengthCalculator();

    public void calculateAttackDamage(@NotNull Pokemon target, @NotNull PokemonMove pokemonMove) {
        int origDamage = pokemonMove.getMoveDamage();
        if (isHit(pokemonMove)) return;
        this.weaknessCalculator.calculate(target, pokemonMove);
        this.strengthCalculator.calculate(target, pokemonMove);
        calculateDamage(target, pokemonMove);
        subtractPowerPoints(pokemonMove);

        String message = pokemonMove.getMoveDamage() <= origDamage ? "It's not very effective..." : "It's super effective...";
        System.out.println(message);
        // setMoveDamage to original damage
        pokemonMove.setMoveDamage(origDamage);
    }

    private void calculateDamage(@NotNull Pokemon target, @NotNull PokemonMove pokemonMove) {
        int damage = pokemonMove.getMoveDamage() - target.getDefence();
        if (damage <= 0) {
            System.out.println("No Damage!");
            return;
        }
        int inflictDamage = target.getHitPoints() - damage;
        target.setHitPoints(inflictDamage);
    }

    private void subtractPowerPoints(@NotNull PokemonMove pokemonMove) {
        int initialPP = pokemonMove.getMovePowerPoints();
        pokemonMove.setMovePowerPoints(initialPP - 1);
    }

    private boolean isHit(@NotNull PokemonMove pokemonMove) {
        int generatedNumber = random(pokemonMove.getMoveAccuracy());
        int fivePercent = Math.round(pokemonMove.getMoveAccuracy() * (5.0f / 100.0f)); // 5% of accuracy
        if (generatedNumber < fivePercent) {
            GUITextPrinter.displayMissedMessage();
            return true;
        }
        return false;
    }

    private int random(int accuracy) {
        return new Random().nextInt(accuracy);
    }
}
