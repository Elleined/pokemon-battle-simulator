package pokemongame.type;
import java.util.Arrays;
import java.util.List;

public interface DarkType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.GHOST, Type.PSYCHIC);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.FIGHTING, Type.DARK, Type.FAIRY);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.GHOST, Type.DARK, Type.PSYCHIC);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.FIGHTING, Type.BUG, Type.FAIRY);
    }

    @Override
    default Type getType() {
        return Type.DARK;
    }
}
