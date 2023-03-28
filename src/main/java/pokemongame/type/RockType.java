package pokemongame.type;
import java.util.Arrays;
import java.util.List;

public interface RockType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.FLYING, Type.BUG, Type.FIRE, Type.ICE);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.FIGHTING, Type.GROUND, Type.STEEL);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.NORMAL, Type.FLYING, Type.POISON, Type.FIRE);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.FIGHTING, Type.GROUND, Type.STEEL, Type.WATER, Type.GRASS);
    }

    @Override
    default Type getType() {
        return Type.ROCK;
    }
}
