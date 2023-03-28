//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package pokemongame.pokemon;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pokemongame.attack.PokemonMove;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
abstract class TypeDecorator extends Pokemon {
    protected Pokemon pokemon;

    public PokemonMove useMove(String moveName) {
        return this.pokemon.useMove(moveName);
    }

    public String getName() {
        return this.pokemon.getName();
    }

    public Gender getGender() {
        return this.pokemon.getGender();
    }

    public int getHitPoints() {
        return this.pokemon.getHitPoints();
    }

    public int getDefence() {
        return this.pokemon.getDefence();
    }

    public int getSpeed() {
        return this.pokemon.getSpeed();
    }

    public List<PokemonMove> getPokemonMove() {
        return this.pokemon.getPokemonMove();
    }

    public void setName(String name) {
        this.pokemon.name = name;
    }

    public void setGender(Gender gender) {
        this.pokemon.gender = gender;
    }

    public void setHitPoints(int hitPoints) {
        this.pokemon.hitPoints = hitPoints;
    }

    public void setDefence(int defence) {
        this.pokemon.defence = defence;
    }

    public void setSpeed(int speed) {
        this.pokemon.speed = speed;
    }

    public void setPokemonMove(List<PokemonMove> pokemonMove) {
        this.pokemon.pokemonMove = pokemonMove;
    }
}
