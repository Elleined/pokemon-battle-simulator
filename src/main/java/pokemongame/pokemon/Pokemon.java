package pokemongame.pokemon;
import lombok.*;
import pokemongame.attack.PokemonMove;
import pokemongame.attack.PokemonMoveHelper;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "pokemonMove")
@AllArgsConstructor
@Data
public class Pokemon {
    @Getter protected static final int LVL = 100;
    protected String name;
    protected Gender gender;
    protected int hitPoints;
    protected int defence;
    protected int speed;
    protected List<PokemonMove> pokemonMove;

    public int getTypeNumber() {
        return 0;
    }
    public void displayPokemon() {
        System.out.println(this);
    }
    public PokemonMove useMove(String moveName) {
        return PokemonMoveHelper.selectPokemonMove(this, moveName);
    }
}
