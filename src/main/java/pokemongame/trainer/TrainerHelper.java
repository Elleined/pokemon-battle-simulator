package pokemongame.trainer;

import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.Pokemon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public interface TrainerHelper {

    static Pokemon selectPokemon(@NotNull Trainer trainer, String pokemonName) {
        HashMap<String, Pokemon> map = new HashMap<>();
        List<String> pokemonNames = trainer.pokemonList().stream()
                .map(Pokemon::getName)
                .toList();

        Iterator<String> nameItr = pokemonNames.iterator();
        Iterator<Pokemon> pokemonItr = trainer.pokemonList().iterator();
        while (nameItr.hasNext() && pokemonItr.hasNext()) {
            map.put(nameItr.next(), pokemonItr.next());
        }
        return map.get(pokemonName);
    }
}
