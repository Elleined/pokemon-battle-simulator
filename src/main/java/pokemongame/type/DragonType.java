package pokemongame.type;
import java.util.Arrays;
import java.util.List;

public interface DragonType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return List.of(Type.DRAGON);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.STEEL, Type.FAIRY);
    }

    @Override
    default List<Type> resistantTo() {
        return Arrays.asList(Type.FIRE, Type.WATER, Type.GRASS, Type.ELECTRIC);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.ICE, Type.DRAGON, Type.FAIRY);
    }

    @Override
    default Type getType() {
        return Type.DRAGON;
    }
}
