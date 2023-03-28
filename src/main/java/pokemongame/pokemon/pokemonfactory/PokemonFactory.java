package pokemongame.pokemon.pokemonfactory;

import pokemongame.attack.PokemonMoveFactory;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.Gender;
import pokemongame.pokemon.Pokemon;

import java.util.OptionalInt;
import java.util.Random;

public interface PokemonFactory {

    static @NotNull Pokemon createPokemon(String name, Gender gender) {
        return new Pokemon(name, gender, generateHitPoints(), generateDefence(), generateSpeed(), PokemonMoveFactory.generateMoveSet());
    }

    private static int generateHitPoints() {
        return random(650, 700).orElseThrow();
    }

    private static int generateSpeed() {
        return random(60, 65).orElseThrow();
    }

    private static int generateDefence() {
        return random(20, 30).orElseThrow();
    }

    private static OptionalInt random(int origin, int bound) {
        Random rand = new Random();
        return rand.ints(origin, bound).findFirst();
    }
}
