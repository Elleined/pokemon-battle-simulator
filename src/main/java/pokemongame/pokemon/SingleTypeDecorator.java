package pokemongame.pokemon;
import lombok.Getter;
import pokemongame.type.GeneralType;

@Getter
public final class SingleTypeDecorator extends TypeDecorator {
    private final GeneralType pokemonType1;

    public SingleTypeDecorator(Pokemon pokemon, GeneralType pokemonType1) {
        super(pokemon);
        this.pokemonType1 = pokemonType1;
    }

    @Override
    public void displayPokemon() {
        System.out.println(super.toString() + " pokemonType1=" + pokemonType1.getType() + '}');
        this.pokemon.getPokemonMove().forEach(System.out::println);
        System.out.println();
    }

    @Override
    public int getTypeNumber() {
        return 1;
    }
}
