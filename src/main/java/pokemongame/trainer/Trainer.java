package pokemongame.trainer;

import pokemongame.attack.PokemonMove;
import pokemongame.pokemon.Gender;
import pokemongame.pokemon.Pokemon;

import java.util.Collection;
import java.util.List;

public record Trainer(String name,
                      Gender gender,
                      List<Pokemon> pokemonList) {

    public void catchPokemon(Pokemon pokemon) {
        pokemonList().add(pokemon);
    }

    public Pokemon selectPokemon(String pokemonName) {
        return TrainerHelper.selectPokemon(this, pokemonName);
    }

    public void displayTrainer() {
        System.out.println(this);
        pokemonList().forEach(Pokemon::displayPokemon);
    }

    public List<PokemonMove> getAllMoves() {
        return pokemonList.stream()
                .map(Pokemon::getPokemonMove)
                .flatMap(Collection::stream)
                .toList();
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
