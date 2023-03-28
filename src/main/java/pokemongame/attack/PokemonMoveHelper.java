package pokemongame.attack;

import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.Pokemon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public interface PokemonMoveHelper {

    static PokemonMove selectPokemonMove(@NotNull Pokemon pokemon, String moveName) {
        HashMap<String, PokemonMove> map = new HashMap<>();
        List<PokemonMove> pokemonMoves = pokemon.getPokemonMove();
        List<String> pokemonMoveName = pokemonMoves.stream()
                .map(PokemonMove::getMoveName)
                .toList();

        Iterator<String> moveNameItr = pokemonMoveName.iterator();
        Iterator<PokemonMove> pokemonMoveItr = pokemonMoves.iterator();
        while (moveNameItr.hasNext() && pokemonMoveItr.hasNext()) {
            map.put(moveNameItr.next(), pokemonMoveItr.next());
        }
        return map.get(moveName);
    }

    static PokemonMove pickRandomMoveFor(@NotNull Pokemon pokemon) {
        int rand = new Random().nextInt(4);
        List<PokemonMove> pokemonMoves = pokemon.getPokemonMove();
        boolean pickedMoveHasNoPP = pokemonMoves.get(rand).getMovePowerPoints() == 0;
        if (pickedMoveHasNoPP) {
            return pickRandomMoveFor(pokemon);
        }
        return pokemonMoves.get(rand);
    }
}
