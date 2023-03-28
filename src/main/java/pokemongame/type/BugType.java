package pokemongame.type;
import java.util.Arrays;
import java.util.List;

public interface BugType extends GeneralType {
    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.GRASS, Type.PSYCHIC, Type.DARK);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.FIGHTING, Type.FLYING, Type.POISON, Type.GHOST, Type.STEEL, Type.FIRE, Type.FAIRY);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.FIGHTING, Type.GROUND, Type.GRASS);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.FLYING, Type.ROCK, Type.FIRE);
    }

    @Override
    default Type getType() {
        return Type.BUG;
    }
}