package pokemongame.type;
import java.util.List;

public interface GeneralType {
    List<Type> superEffectiveTo();
    List<Type> notVeryEffectiveTo();
    List<Type> resistantTo();
    List<Type> weakTo();

    Type getType();
}
