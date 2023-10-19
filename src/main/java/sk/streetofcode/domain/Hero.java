package sk.streetofcode.domain;

import sk.streetofcode.ability.Ability;
import sk.streetofcode.constant.Constants;

import java.util.HashMap;
import java.util.Map;

public class Hero extends GameCharacter {
    private int heroAvailablePoints;

    public Hero(String name) {
        super(name, new HashMap<>());
        super.abilities = getInitialAbilities();
        this.heroAvailablePoints = Constants.INITIAL_ABILITY_POINTS;
    }

    public Hero(String name, Map<Ability, Integer> abilities, int heroAvailablePoints) {
        super(name, abilities);
        this.heroAvailablePoints = heroAvailablePoints;
    }

    public void updateAbility(Ability ability, int delta) {
        if (ability.equals(Ability.HEALTH)) {
            super.abilities.put(ability, abilities.get(ability) + delta * Constants.HEALTH_OF_ONE_POINT);
        } else {
            super.abilities.put(ability, abilities.get(ability) + delta);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeroAvailablePoints() {
        return heroAvailablePoints;
    }

    public void updateHeroAvailablePoints(int delta) {
        this.heroAvailablePoints += delta;
    }

    public void setAbility(Ability ability, int value) {
        abilities.put(ability, value);
    }

    private Map<Ability, Integer> getInitialAbilities() {
        return new HashMap<>(Map.of(
                Ability.ATTACK, 1,
                Ability.DEFENCE, 1,
                Ability.DEXTERITY, 1,
                Ability.SKILL, 1,
                Ability.LUCK, 1,
                Ability.HEALTH, 50
        ));
    }
}
