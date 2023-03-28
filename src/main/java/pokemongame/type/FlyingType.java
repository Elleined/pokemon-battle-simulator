package pokemongame.type;
import java.util.Arrays;
import java.util.List;

public interface FlyingType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.FIGHTING, Type.BUG, Type.GRASS);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.ROCK, Type.STEEL, Type.ELECTRIC);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.FIGHTING, Type.BUG, Type.GRASS, Type.GROUND);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.ROCK, Type.ELECTRIC, Type.ICE);
    }

    @Override
    default Type getType() {
        return Type.FLYING;
    }
}
