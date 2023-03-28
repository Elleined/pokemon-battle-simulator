package pokemongame.pokemon;

import lombok.Getter;
import pokemongame.type.GeneralType;

@Getter
public final class DualTypeDecorator extends TypeDecorator {
    private final GeneralType pokemonType1;
    private final GeneralType pokemonType2;

    public DualTypeDecorator(Pokemon pokemon, GeneralType pokemonType1, GeneralType pokemonType2) {
        super(pokemon);
        this.pokemonType1 = pokemonType1;
        this.pokemonType2 = pokemonType2;
    }

    @Override
    public void displayPokemon() {
        System.out.println(super.toString() + " pokemonType1=" + pokemonType1.getType() + ", " +
                "pokemonType2=" + pokemonType2.getType() + '}');
        this.pokemon.getPokemonMove().forEach(System.out::println);
        System.out.println();
    }

    @Override
    public int getTypeNumber() {
        return 2;
    }

}
