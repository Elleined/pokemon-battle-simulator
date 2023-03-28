package pokemongame.type;
import java.util.Arrays;
import java.util.List;

public interface IceType extends GeneralType {

    @Override
    default List<Type> superEffectiveTo() {
        return Arrays.asList(Type.FLYING, Type.GRASS, Type.GROUND, Type.DRAGON);
    }

    @Override
    default List<Type> notVeryEffectiveTo() {
        return Arrays.asList(Type.STEEL, Type.FIRE, Type.WATER, Type.ICE);
    }

    @Override
    default List<Type> resistantTo() {
        return List.of(Type.ICE);
    }

    @Override
    default List<Type> weakTo() {
        return Arrays.asList(Type.FIGHTING, Type.ROCK, Type.STEEL, Type.FIRE);
    }

    @Override
    default Type getType() {
        return Type.ICE;
    }

}
