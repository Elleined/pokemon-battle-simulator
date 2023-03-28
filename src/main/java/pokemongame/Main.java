package pokemongame;

import pokemongame.battlefield.BattleField;
import pokemongame.battlefield.FieldWeather;
import pokemongame.battlegui.BattleGUI;
import pokemongame.battlegui.battleguilogic.*;
import pokemongame.battlegui.battleguilogic.*;
import pokemongame.trainer.TrainerFactory;

import javax.swing.*;

class Main {
     public static void main(String[] args) {
          // Setting up BattleField
          BattleField battleField = BattleField.getInstance();
          battleField.setName("Dome");
          battleField.setFieldWeather(FieldWeather.FOG);
          battleField.setBattleTrainers(TrainerFactory.generateTwoBattleTrainer());

          // Loading all logic for gui
          new RoutingPanelLogic();
          TopPanelLogic topPanelLogic = TopPanelLogic.getInstance();
          FightPanelLogic fightPanelLogic = FightPanelLogic.getInstance();
          PokemonPanelLogic pokemonPanelLogic = PokemonPanelLogic.getInstance();

          //  Setting static display
          topPanelLogic.setBattleField(battleField);
          pokemonPanelLogic.setTrainer(topPanelLogic.getPlayer());
          fightPanelLogic.setPokemon(topPanelLogic.getPlayerPokemon());

          // Creating GUI
          BattleGUI battleGUI = BattleGUI.getInstance();
          int multiplayer = JOptionPane.showConfirmDialog(battleGUI, "(Yes)Single Player, (No)Multiplayer", "Choose play type", JOptionPane.YES_NO_OPTION);
          battleGUI.getTopPanel().getLblText().setText("What will " + topPanelLogic.getPlayerPokemon().getName() + " do?");

          // Single or Double Player
          if (multiplayer == JOptionPane.NO_OPTION) {
               DualPlayerLogic.getInstance();
          } else {
               SinglePlayerLogic.getInstance();
          }
     }
}
