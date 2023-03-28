package pokemongame.type;
import java.util.Arrays;
import java.util.List;

public interface FightingType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.NORMAL, Type.ROCK, Type.STEEL, Type.ICE, Type.DARK);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.FLYING, Type.POISON, Type.BUG, Type.PSYCHIC, Type.FAIRY, Type.GHOST);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.ROCK, Type.BUG, Type.DARK);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.FLYING, Type.PSYCHIC, Type.FAIRY);
    }

    @Override
    default Type getType() {
        return Type.FIGHTING;
    }
}
