package pokemongame.battlefield;

import pokemongame.attack.PokemonMove;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.Pokemon;
import pokemongame.type.Type;

import java.util.List;
interface TypeAdvantage {
    void calculate(@NotNull Pokemon target, PokemonMove attackMove);
    void dualAdvantage(Pokemon target, @NotNull PokemonMove attackMove);

    void singleAdvantage(Pokemon target, @NotNull PokemonMove attackMove);

    void setMoveDamage(PokemonMove attackMove, long weaknessCount);

    default long count(@NotNull List<Type> typeList, @NotNull Type matcher) {
        return typeList.stream()
                .filter(matcher::equals)
                .count();
    }
}
