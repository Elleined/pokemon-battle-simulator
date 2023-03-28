package pokemongame.attack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pokemongame.type.Type;

@AllArgsConstructor
@Getter
@ToString
public class PokemonMove {
    private String moveName;
    private Type moveType;
    private @Setter int movePowerPoints;
    private @Setter int moveDamage;
    private @Setter int moveAccuracy;
}
