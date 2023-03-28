package pokemongame.attack;
import org.jetbrains.annotations.NotNull;
import pokemongame.type.Type;
import java.util.*;

public interface PokemonMoveFactory {

    static List<PokemonMove> generateMoveSet() {
        List<PokemonMove> generatedPokemonMoves = generatePokemonMoveList();
        Collections.shuffle(generatedPokemonMoves);
        return generatedPokemonMoves.stream()
                .limit(4)
                .toList();
    }

    private static @NotNull List<PokemonMove> generatePokemonMoveList() {
        List<PokemonMove> pokemonMoveList =  Arrays.asList(
                // WaterTypeMove
                new PokemonMove("Hydro Pump",Type.WATER, 5, 110, 80),
                new PokemonMove("Hydro Cannon",Type.WATER, 5, 150, 90),
                new PokemonMove("Bubble Beam", Type.WATER, 20, 65, 100),
                new PokemonMove("Muddy Water",Type.WATER, 10, 90, 85),
                new PokemonMove("Aqua Tail",Type.WATER, 10, 90, 90),
                new PokemonMove("Water Gun", Type.WATER, 25, 40, 100),
                new PokemonMove("Water Pulse", Type.WATER, 20, 60, 100),
                new PokemonMove("Water Spout", Type.WATER ,5, 150, 100),
                new PokemonMove("Sparkling Aria", Type.WATER,10, 90, 100),
                new PokemonMove("Razor Shell",Type.WATER, 10, 75, 95),
                new PokemonMove("Splishy Splash", Type.WATER,15, 90, 100),
                new PokemonMove("Water Pledge", Type.WATER, 10, 80, 100),
                new PokemonMove("Origin Pulse", Type.WATER,10, 110, 85),
                new PokemonMove("Scald", Type.WATER,15, 80, 100),
                new PokemonMove("Crab Hammer", Type.WATER,10, 100, 90),
                // FireTypeMove
                new PokemonMove("Blast Burn", Type.FIRE, 5, 150, 90),
                new PokemonMove("Blaze Kick", Type.FIRE, 10, 85, 90),
                new PokemonMove("Ember", Type.FIRE,25, 40, 100),
                new PokemonMove("Flame Wheel", Type.FIRE,25, 60, 100),
                new PokemonMove("Fiery Dance", Type.FIRE,10, 80, 100),
                new PokemonMove("Fire Punch", Type.FIRE,15, 75, 100),
                new PokemonMove("Overheat", Type.FIRE, 5, 130, 90),
                new PokemonMove("Incarnate", Type.FIRE,15, 60, 100),
                new PokemonMove("Flamethrower", Type.FIRE,15, 90, 100),
                new PokemonMove("Flare Blitz", Type.FIRE,15, 120, 100),
                new PokemonMove("Magma Storm", Type.FIRE, 5, 100, 75),
                new PokemonMove("Shell Trap", Type.FIRE,5, 150, 100),
                new PokemonMove("Heat Wave", Type.FIRE, 10, 95, 90),
                new PokemonMove("Mystical Fire", Type.FIRE,10, 75, 100),
                new PokemonMove("Burn Up", Type.FIRE,5, 130, 100),
                // GrassTypeMove
                new PokemonMove("Leaf Blade", Type.GRASS,15, 90, 100),
                new PokemonMove("Razor Leaf",Type.GRASS, 25, 55, 95),
                new PokemonMove("Vine Whip",Type.GRASS, 25, 45, 95),
                new PokemonMove("Energy Ball", Type.GRASS,10, 90, 100),
                new PokemonMove("Grass Pledge", Type.GRASS,10, 80, 100),
                new PokemonMove("Leaf Storm",Type.GRASS, 5, 130, 90),
                new PokemonMove("Petal Blizzard", Type.GRASS,15, 90, 100),
                new PokemonMove("Needle Arm", Type.GRASS,15, 60, 100),
                new PokemonMove("Sappy Seed", Type.GRASS,15, 90, 100),
                new PokemonMove("Seed Bomb", Type.GRASS,15, 80, 100),
                new PokemonMove("Giga Drain", Type.GRASS,10, 75, 100),
                new PokemonMove("Wood Hammer", Type.GRASS,15, 120, 100),
                new PokemonMove("Trap Kick", Type.GRASS,15, 70, 100),
                new PokemonMove("Solar Blade", Type.GRASS,10, 125, 100),
                new PokemonMove("Solar Beam", Type.GRASS,10, 120, 100),
                // Electric
                new PokemonMove("Aura Wheel", Type.ELECTRIC,10, 110, 100),
                new PokemonMove("Bolt Strike",Type.ELECTRIC, 5, 130, 85),
                new PokemonMove("Discharge",Type.ELECTRIC, 15, 80, 100),
                new PokemonMove("Double Shock", Type.ELECTRIC,5, 120, 100),
                new PokemonMove("Electro Drift", Type.ELECTRIC,5, 100, 100),
                new PokemonMove("Electro Web",Type.ELECTRIC, 15, 55, 95),
                new PokemonMove("Rising Voltage", Type.ELECTRIC,20, 70, 100),
                new PokemonMove("Plasma Fists", Type.ELECTRIC,15, 100, 100),
                new PokemonMove("Spark", Type.ELECTRIC,20, 65, 100),
                new PokemonMove("Thunder", Type.ELECTRIC,10, 110, 70),
                new PokemonMove("Thunder Cage", Type.ELECTRIC,15, 80, 90),
                new PokemonMove("Thunder Punch", Type.ELECTRIC,15, 75, 100),
                new PokemonMove("Thunderbolt", Type.ELECTRIC,15, 90, 100),
                new PokemonMove("Volt Tackle", Type.ELECTRIC,15, 120, 100),
                new PokemonMove("Wild Charge", Type.ELECTRIC,15, 90, 100),
                // Dark
                new PokemonMove("Wicked Torque", Type.DARK,10, 80, 100),
                new PokemonMove("Thief",Type.DARK, 25, 60, 100),
                new PokemonMove("Throat Chop",Type.DARK, 15, 80, 100),
                new PokemonMove("Sucker Punch", Type.DARK,5, 70, 100),
                new PokemonMove("Snarl", Type.DARK,15, 55, 95),
                new PokemonMove("Pursuit",Type.DARK, 20, 40, 100),
                new PokemonMove("Payback", Type.DARK,10, 50, 100),
                new PokemonMove("Night Slash", Type.DARK,15, 70, 100),
                new PokemonMove("Night Daze", Type.DARK,10, 85, 95),
                new PokemonMove("Lash Out", Type.DARK,5, 75, 100),
                new PokemonMove("Jaw Lock", Type.DARK,10, 80, 100),
                new PokemonMove("Foul Play", Type.DARK,15, 75, 100),
                new PokemonMove("Fiery Wrath", Type.DARK,10, 90, 100),
                new PokemonMove("False Surrender", Type.DARK,10, 80, 100),
                new PokemonMove("Dark Pulse", Type.DARK,10, 80, 100),
                // Psychic
                new PokemonMove("Dream Eater", Type.PSYCHIC,15, 100, 100),
                new PokemonMove("Extrasensory",Type.PSYCHIC, 20, 80, 100),
                new PokemonMove("Future Sight",Type.PSYCHIC, 10, 120, 100),
                new PokemonMove("Glitzy Glow", Type.PSYCHIC,15, 90, 100),
                new PokemonMove("Heart Stamp", Type.PSYCHIC,25, 60, 100),
                new PokemonMove("Luster Purge",Type.PSYCHIC, 5, 70, 100),
                new PokemonMove("Mist Ball", Type.PSYCHIC,5, 70, 100),
                new PokemonMove("Photon Geyser", Type.PSYCHIC,5, 100, 100),
                new PokemonMove("Prismatic Laser", Type.PSYCHIC,10, 160, 100),
                new PokemonMove("Psybeam", Type.PSYCHIC,20, 65, 100),
                new PokemonMove("Psychic", Type.PSYCHIC, 10, 90, 100),
                new PokemonMove("Psychic Fangs", Type.PSYCHIC,10, 85, 100),
                new PokemonMove("Psycho Boost", Type.PSYCHIC,5, 140, 90),
                new PokemonMove("Psycho Cut", Type.PSYCHIC,20, 70, 100),
                new PokemonMove("Psystrike", Type.PSYCHIC,10, 100, 100)
        );
        return new ArrayList<>(pokemonMoveList);
    }
}
