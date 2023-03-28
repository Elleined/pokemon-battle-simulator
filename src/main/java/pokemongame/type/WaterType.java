package pokemongame.type;

import java.util.Arrays;
import java.util.List;

public interface WaterType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.GROUND, Type.ROCK, Type.FIRE);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.WATER, Type.GRASS, Type.DRAGON);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.STEEL, Type.WATER, Type.FIRE, Type.ICE);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.GRASS, Type.ELECTRIC);
    }

    @Override
    default Type getType() {
        return Type.WATER;
    }
}
