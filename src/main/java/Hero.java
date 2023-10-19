import java.util.HashMap;
import java.util.Map;

public class Hero {
    private String name;
    private Map<Ability, Integer> abilities;

    private int heroAvailablePoints;

    public Hero(String name) {
        this.name = name;
        this.abilities = getInitialAbilities();
        this.heroAvailablePoints = 7;
    }

    public void updateAbility(Ability ability, int delta) {
        if (ability.equals(Ability.HEALTH)) {
            abilities.put(ability, abilities.get(ability) + delta * 5);
        } else {
            abilities.put(ability, abilities.get(ability) + delta);
        }
    }

    public String getName() {
        return name;
    }

    public int getHeroAvailablePoints() {
        return heroAvailablePoints;
    }

    public void updateHeroAvailablePoints(int delta) {
        this.heroAvailablePoints += delta;
    }

    public Map<Ability, Integer> getAbilities() {
        return abilities;
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
