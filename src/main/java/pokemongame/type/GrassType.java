package pokemongame.type;
import java.util.Arrays;
import java.util.List;

public interface GrassType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.GROUND, Type.ROCK, Type.WATER);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.FLYING, Type.POISON, Type.BUG, Type.STEEL, Type.FIRE, Type.GRASS, Type.DRAGON);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.GROUND, Type.WATER, Type.GRASS, Type.ELECTRIC);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.FLYING, Type.POISON, Type.BUG, Type.FIRE, Type.ICE);
    }

    @Override
    default Type getType() {
        return Type.GRASS;
    }
}
