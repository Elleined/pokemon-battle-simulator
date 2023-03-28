package pokemongame.battlefield;

import lombok.*;
import pokemongame.trainer.Trainer;

import java.util.List;

@ToString(exclude = "battleTrainers")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public final class BattleField {
    private static BattleField instance;
    private String name;
    private FieldWeather fieldWeather;
    private List<Trainer> battleTrainers;

    void displayBattleField() {
        System.out.println(this);
        battleTrainers.forEach(Trainer::displayTrainer);
    }

    public static BattleField getInstance() {
        if (instance == null) instance = new BattleField();
        return instance;
    }
}
