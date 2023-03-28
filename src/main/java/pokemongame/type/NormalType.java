package pokemongame.type;
import java.util.Arrays;
import java.util.List;

public interface NormalType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return null;
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.ROCK, Type.STEEL, Type.GHOST);
    }

    @Override
    default List<Type> resistantTo() {
        return List.of(Type.GHOST);
    }

    @Override
    default List<Type> weakTo() {
        return List.of(Type.FIGHTING);
    }

    @Override
    default Type getType() {
        return Type.NORMAL;
    }
}
