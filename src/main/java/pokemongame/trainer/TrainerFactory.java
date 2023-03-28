package pokemongame.trainer;
import org.jetbrains.annotations.NotNull;
import pokemongame.pokemon.Gender;
import pokemongame.pokemon.pokemonfactory.PokemonTeamFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface TrainerFactory {

    static @NotNull Trainer createTrainer(String name, Gender gender) {
        return new Trainer(name, gender, PokemonTeamFactory.generatePokemonTeam());
    }

    static List<Trainer> generateTwoBattleTrainer() {
        List<Trainer> trainerList = TrainerFactory.generateTrainerList();
        Collections.shuffle(trainerList);
        return trainerList.stream()
                .limit(2)
                .toList();
    }

    private static @NotNull List<Trainer> generateTrainerList() {
        return Arrays.asList(
                TrainerFactory.createTrainer("Ash", Gender.MALE),
                TrainerFactory.createTrainer("Iris", Gender.FEMALE),
                TrainerFactory.createTrainer("Giovanni", Gender.MALE),
                TrainerFactory.createTrainer("Steven", Gender.MALE),
                TrainerFactory.createTrainer("Cynthia", Gender.FEMALE),
                TrainerFactory.createTrainer("Whitney", Gender.FEMALE),
                TrainerFactory.createTrainer("Wally", Gender.MALE),
                TrainerFactory.createTrainer("Lance", Gender.MALE),
                TrainerFactory.createTrainer("Drake", Gender.MALE),
                TrainerFactory.createTrainer("Blue", Gender.MALE),
                TrainerFactory.createTrainer("Brock", Gender.MALE),
                TrainerFactory.createTrainer("Brendan", Gender.MALE),
                TrainerFactory.createTrainer("May", Gender.FEMALE),
                TrainerFactory.createTrainer("You(The Protagonist)", Gender.MALE)
        );
    }
}
