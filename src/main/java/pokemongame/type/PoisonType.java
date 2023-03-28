package pokemongame.type;

import java.util.Arrays;
import java.util.List;

public interface PoisonType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.GRASS, Type.FAIRY);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.POISON, Type.ROCK, Type.GROUND, Type.GHOST, Type.STEEL);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.FIGHTING, Type.POISON, Type.GRASS, Type.FAIRY);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.GROUND, Type.PSYCHIC);
    }

    @Override
    default Type getType() {
        return Type.POISON;
    }
}
