package pokemongame.type;
import java.util.Arrays;
import java.util.List;

public interface PsychicType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.FIGHTING, Type.POISON);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.STEEL, Type.PSYCHIC, Type.DARK);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.FIGHTING, Type.PSYCHIC);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.BUG, Type.GHOST, Type.DARK);
    }

    @Override
    default Type getType() {
        return Type.PSYCHIC;
    }
}
