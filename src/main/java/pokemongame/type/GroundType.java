package pokemongame.type;

import java.util.Arrays;
import java.util.List;

public interface GroundType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.POISON, Type.ROCK, Type.STEEL, Type.FIRE, Type.ELECTRIC);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.BUG, Type.GRASS, Type.FLYING);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.POISON, Type.ROCK, Type.ELECTRIC);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.WATER, Type.GRASS, Type.ICE);
    }

    @Override
    default Type getType() {
        return Type.GROUND;
    }
}
