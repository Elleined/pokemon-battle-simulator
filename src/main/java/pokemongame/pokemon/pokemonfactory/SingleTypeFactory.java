package pokemongame.pokemon.pokemonfactory;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.Gender;
import pokemongame.pokemon.SingleTypeDecorator;
import pokemongame.type.GeneralType;
import pokemongame.type.Type;

import java.util.*;

public interface SingleTypeFactory {

    static @NotNull SingleTypeDecorator createSingleTypePokemon(Type pokemonType,
                                                                String name,
                                                                Gender gender) {

        GeneralType selectedType = TypeFactory.selectType(pokemonType).orElseThrow();
        return new SingleTypeDecorator(PokemonFactory.createPokemon(name, gender), selectedType);
    }


    static List<SingleTypeDecorator> pickSingleTypePokemon() {
        List<SingleTypeDecorator> pokemonList = generateSingleTypePokemonList();
        Collections.shuffle(pokemonList);
        return pokemonList.stream()
                .limit(3)
                .toList();
    }

    private static @NotNull List<SingleTypeDecorator> generateSingleTypePokemonList() {
        List<SingleTypeDecorator> singleTypePokemonList = Arrays.asList(
                // Fire
                createSingleTypePokemon(Type.FIRE, "Charmander", Gender.MALE),
                createSingleTypePokemon(Type.FIRE, "Chimchar", Gender.MALE),
                createSingleTypePokemon(Type.FIRE, "Cyndaquil", Gender.MALE),
                createSingleTypePokemon(Type.FIRE, "Tepig", Gender.MALE),
                createSingleTypePokemon(Type.FIRE, "Torchic", Gender.MALE),
                // Grass
                createSingleTypePokemon(Type.GRASS, "Chikorita", Gender.MALE),
                createSingleTypePokemon(Type.GRASS, "Sunkern", Gender.MALE),
                createSingleTypePokemon(Type.GRASS, "Treecko", Gender.MALE),
                createSingleTypePokemon(Type.GRASS, "Turtwig", Gender.MALE),
                createSingleTypePokemon(Type.GRASS, "Snivy", Gender.MALE),
                // Water
                createSingleTypePokemon(Type.WATER, "Mudkip", Gender.MALE),
                createSingleTypePokemon(Type.WATER, "Oshawott", Gender.MALE),
                createSingleTypePokemon(Type.WATER, "Piplup", Gender.MALE),
                createSingleTypePokemon(Type.WATER, "Squirtle", Gender.MALE),
                createSingleTypePokemon(Type.WATER, "Totodile", Gender.MALE),
                // Electric
                createSingleTypePokemon(Type.ELECTRIC, "Pikachu", Gender.MALE),
                createSingleTypePokemon(Type.ELECTRIC, "Voltorb", Gender.MALE),
                createSingleTypePokemon(Type.ELECTRIC, "Electrabuzz", Gender.MALE),
                createSingleTypePokemon(Type.ELECTRIC, "Mareep", Gender.MALE),
                createSingleTypePokemon(Type.ELECTRIC, "Jolteon", Gender.MALE),
                // Dark
                createSingleTypePokemon(Type.DARK, "Zoroark", Gender.MALE),
                createSingleTypePokemon(Type.DARK, "Purrloin", Gender.MALE),
                createSingleTypePokemon(Type.DARK, "Meowth", Gender.MALE),
                createSingleTypePokemon(Type.DARK, "Umbreon", Gender.MALE),
                createSingleTypePokemon(Type.DARK, "Poochyena", Gender.MALE),
                // Psychic
                createSingleTypePokemon(Type.PSYCHIC, "Abra", Gender.MALE),
                createSingleTypePokemon(Type.PSYCHIC, "Drowzee", Gender.MALE),
                createSingleTypePokemon(Type.PSYCHIC, "Hypno", Gender.MALE),
                createSingleTypePokemon(Type.PSYCHIC, "Wobbufet", Gender.MALE),
                createSingleTypePokemon(Type.PSYCHIC, "Grumpig", Gender.MALE),
                createSingleTypePokemon(Type.PSYCHIC, "Wynaut", Gender.MALE),
                createSingleTypePokemon(Type.PSYCHIC, "Mew", Gender.MALE)
        );
        return new ArrayList<>(singleTypePokemonList);
    }
}
