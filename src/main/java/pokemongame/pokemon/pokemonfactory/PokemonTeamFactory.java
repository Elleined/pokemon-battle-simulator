package pokemongame.pokemon.pokemonfactory;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.DualTypeDecorator;
import pokemongame.pokemon.Pokemon;
import pokemongame.pokemon.SingleTypeDecorator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface PokemonTeamFactory {

    static @NotNull List<Pokemon> generatePokemonTeam() {
        List<SingleTypeDecorator> singleList = SingleTypeFactory.pickSingleTypePokemon();
        List<DualTypeDecorator> dualList = DualTypeFactory.pickDualTypePokemon();
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.addAll(singleList);
        pokemonList.addAll(dualList);
        Collections.shuffle(pokemonList);
        return pokemonList;
    }
}
