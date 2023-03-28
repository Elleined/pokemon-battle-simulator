package pokemongame.pokemon.pokemonfactory;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.pokemonentity.*;
import pokemongame.type.GeneralType;
import pokemongame.type.Type;

import java.util.*;

interface TypeFactory {

    static @NotNull Optional<GeneralType> selectType(Type selectedType) {
        List<GeneralType> generalTypes = generatePokemonTypeList();
        return generalTypes.stream()
                .filter(generalType -> generalType.getType().equals(selectedType))
                .findFirst();
    }

    private static @NotNull List<GeneralType> generatePokemonTypeList() {
        List<GeneralType> generalTypeList = Arrays.asList(
                new FireTypePokemon(),
                new WaterTypePokemon(),
                new GrassTypePokemon(),
                new FlyingTypePokemon(),
                new PoisonTypePokemon(),
                new DarkTypePokemon(),
                new BugTypePokemon(),
                new ElectricTypePokemon(),
                new PsychicTypePokemon(),
                new FairyTypePokemon()
        );
        return new ArrayList<>(generalTypeList);
    }
}
