package pokemongame.battlefield;

import pokemongame.attack.PokemonMove;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.DualTypeDecorator;
import pokemongame.pokemon.Pokemon;
import pokemongame.pokemon.SingleTypeDecorator;
import pokemongame.type.GeneralType;
import pokemongame.type.Type;

import java.util.List;


final class WeaknessCalculator implements TypeAdvantage {

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

        List<Type> weakList1 = type1.weakTo();
        List<Type> weakList2 = type2.weakTo();

        long weakCount1 = count(weakList1, attackType);
        long weakCount2 = count(weakList2, attackType);

        long weaknessCount = weakCount1 + weakCount2;
        System.out.println("Dual Type Weakness: " + weaknessCount);
    }
    @Override
    public void singleAdvantage(Pokemon target, @NotNull PokemonMove attackMove) {
        GeneralType type = ((SingleTypeDecorator) target).getPokemonType1();

        Type attackType = attackMove.getMoveType();

        List<Type> weakList = type.weakTo();

        long weaknessCount = weakList.stream()
                .filter(attackType::equals)
                .count();
        System.out.println("Single Type Weakness: " + weaknessCount);
        setMoveDamage(attackMove, weaknessCount);
    }

    @Override
    public void setMoveDamage(PokemonMove attackMove, long weaknessCount) {
        if (weaknessCount == 1) {
            attackMove.setMoveDamage(Math.round(attackMove.getMoveDamage() * (200.0f / 100.0f)));
        } else if (weaknessCount == 2) {
            attackMove.setMoveDamage(Math.round(attackMove.getMoveDamage() * (400.0f / 100.0f)));
        } else {
            attackMove.setMoveDamage(attackMove.getMoveDamage());
        }
        System.out.println("Weakness Move Damage: " + attackMove.getMoveDamage());
    }
}
