package pokemongame.type;

import java.util.Arrays;
import java.util.List;

public interface FairyType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.FIGHTING, Type.DRAGON, Type.DARK);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.POISON, Type.STEEL, Type.FIRE);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.FIGHTING, Type.BUG, Type.DARK, Type.DRAGON);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.POISON, Type.STEEL);
    }

    @Override
    default Type getType() {
        return Type.FAIRY;
    }
}
