package pokemongame.battlefield;

import pokemongame.attack.PokemonMove;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.DualTypeDecorator;
import pokemongame.pokemon.Pokemon;
import pokemongame.pokemon.SingleTypeDecorator;
import pokemongame.type.GeneralType;
import pokemongame.type.Type;

import java.util.List;

final class StrengthCalculator implements TypeAdvantage {

    @Override
    public void calculate(@NotNull Pokemon target, PokemonMove attackMove) {
        if (target.getTypeNumber() == 1) {
            singleAdvantage(target, attackMove);
        } else {
            dualAdvantage(target, attackMove);
        }
    }

    @Override
    public void dualAdvantage(Pokemon target, @NotNull PokemonMove attackMove) {
        GeneralType type1 = ((DualTypeDecorator) target).getPokemonType1();
        GeneralType type2 = ((DualTypeDecorator) target).getPokemonType2();

        Type attackType = attackMove.getMoveType();

        List<Type> strongList1 = type1.resistantTo();
        List<Type> strongList2 = type2.resistantTo();

        long strongCount1 = count(strongList1, attackType);
        long strongCount2 = count(strongList2, attackType);

        long weaknessCount = strongCount1 + strongCount2;
        System.out.println("Dual Type Strength: " + weaknessCount);
        setMoveDamage(attackMove, weaknessCount);
    }

    @Override
    public void singleAdvantage(Pokemon target, @NotNull PokemonMove attackMove) {
        GeneralType type = ((SingleTypeDecorator) target).getPokemonType1();

        Type attackType = attackMove.getMoveType();

        List<Type> strongList = type.resistantTo();

        long weaknessCount = count(strongList, attackType);
        System.out.println("Single Type Strength: " + weaknessCount);
        setMoveDamage(attackMove, weaknessCount);
    }

    @Override
    public void setMoveDamage(PokemonMove attackMove, long weaknessCount) {
        if (weaknessCount == 1) {
            attackMove.setMoveDamage(Math.round(attackMove.getMoveDamage() * (50.0f / 100.0f)));
        } else if (weaknessCount == 2) {
            attackMove.setMoveDamage(Math.round(attackMove.getMoveDamage() * (25.0F / 100.0f)));
        } else {
            attackMove.setMoveDamage(attackMove.getMoveDamage());
        }
        System.out.println("Strength Move Damage: " + attackMove.getMoveDamage());
    }
}
