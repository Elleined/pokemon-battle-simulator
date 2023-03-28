package pokemongame.pokemon.pokemonfactory;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.DualTypeDecorator;
import pokemongame.pokemon.Gender;
import pokemongame.type.GeneralType;
import pokemongame.type.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface DualTypeFactory {

    static @NotNull DualTypeDecorator createDualTypePokemon(Type pokemonType1,
                                                            Type pokemonType2,
                                                            String name,
                                                            Gender gender) {

        GeneralType selectedType1 = TypeFactory.selectType(pokemonType1).orElseThrow();
        GeneralType selectedType2 = TypeFactory.selectType(pokemonType2).orElseThrow();
        return new DualTypeDecorator(PokemonFactory.createPokemon(name, gender), selectedType1, selectedType2);
    }

    static List<DualTypeDecorator> pickDualTypePokemon() {
        List<DualTypeDecorator> pokemonList = generateDualTypePokemonList();
        Collections.shuffle(pokemonList);
        return pokemonList.stream()
                .limit(3)
                .toList();
    }

    private static @NotNull List<DualTypeDecorator> generateDualTypePokemonList() {
        List<DualTypeDecorator> dualTypePokemonList = Arrays.asList(
                // Water Flying
                createDualTypePokemon(Type.WATER, Type.FLYING, "Gyrados", Gender.MALE),
                createDualTypePokemon(Type.WATER, Type.FLYING, "Mantine", Gender.MALE),
                createDualTypePokemon(Type.WATER, Type.FLYING, "Wingull", Gender.MALE),
                createDualTypePokemon(Type.WATER, Type.FLYING, "Pelliper", Gender.MALE),
                createDualTypePokemon(Type.WATER, Type.FLYING, "Swanna", Gender.MALE),
                // Grass Poison
                createDualTypePokemon(Type.GRASS, Type.POISON, "Venusaur", Gender.MALE),
                createDualTypePokemon(Type.GRASS, Type.POISON, "Oodish", Gender.MALE),
                createDualTypePokemon(Type.GRASS, Type.POISON, "Bellsprout", Gender.MALE),
                createDualTypePokemon(Type.GRASS, Type.POISON, "Roselia", Gender.FEMALE),
                createDualTypePokemon(Type.GRASS, Type.POISON, "Budew", Gender.MALE),
                // Fire Flying
                createDualTypePokemon(Type.FIRE, Type.FLYING, "Ho-oh", Gender.MALE),
                createDualTypePokemon(Type.FIRE, Type.FLYING, "Moltres", Gender.MALE),
                createDualTypePokemon(Type.FIRE, Type.FLYING, "Charizard", Gender.MALE),
                createDualTypePokemon(Type.FIRE, Type.FLYING, "Fletchinder", Gender.MALE),
                createDualTypePokemon(Type.FIRE, Type.FLYING, "Talonflame", Gender.MALE),
                // Dark Fire
                createDualTypePokemon(Type.DARK, Type.FIRE, "Houndour", Gender.MALE),
                createDualTypePokemon(Type.DARK, Type.FIRE, "Incineroar", Gender.MALE),
                createDualTypePokemon(Type.DARK, Type.FIRE, "Chi-yu", Gender.MALE),
                // Psychic Fairy
                createDualTypePokemon(Type.PSYCHIC, Type.FAIRY, "Mr. Mime", Gender.MALE),
                createDualTypePokemon(Type.PSYCHIC, Type.FAIRY, "Ralts", Gender.MALE),
                createDualTypePokemon(Type.PSYCHIC, Type.FAIRY, "Gardevoir", Gender.MALE),
                createDualTypePokemon(Type.PSYCHIC, Type.FAIRY, "Mime Jr.", Gender.MALE),
                createDualTypePokemon(Type.PSYCHIC, Type.FAIRY, "Tapu Lele", Gender.MALE)
        );
        return new ArrayList<>(dualTypePokemonList);
    }
}
