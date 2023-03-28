package pokemongame.type;

import java.util.Arrays;
import java.util.List;

public interface FireType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.BUG, Type.STEEL, Type.GRASS, Type.ICE);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.ROCK, Type.FIRE, Type.WATER, Type.DRAGON);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.BUG, Type.STEEL, Type.FIRE, Type.GRASS, Type.ICE, Type.FAIRY);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.GROUND, Type.ROCK, Type.WATER);
    }

    @Override
    default Type getType() {
        return Type.FIRE;
    }
}
