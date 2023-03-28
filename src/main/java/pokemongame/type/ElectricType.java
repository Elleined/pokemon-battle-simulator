package pokemongame.type;
import java.util.Arrays;
import java.util.List;

public interface ElectricType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.FLYING, Type.WATER);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.GRASS, Type.ELECTRIC, Type.DRAGON, Type.GROUND);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.FLYING, Type.STEEL, Type.ELECTRIC);
    }

    @Override
    default List<Type> weakTo() {
        return List.of(Type.GROUND);
    }

    @Override
    default Type getType() {
        return Type.ELECTRIC;
    }
}