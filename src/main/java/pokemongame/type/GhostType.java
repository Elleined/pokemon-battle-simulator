package pokemongame.type;
import java.util.Arrays;
import java.util.List;

public interface GhostType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.GHOST, Type.PSYCHIC);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return List.of(Type.NORMAL);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.POISON, Type.BUG, Type.NORMAL,Type.FIGHTING);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.GHOST, Type.DARK);
    }

    @Override
    default Type getType() {
        return Type.GHOST;
    }
}
