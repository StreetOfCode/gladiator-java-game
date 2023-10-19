package sk.streetofcode.ability;

import sk.streetofcode.domain.Hero;
import sk.streetofcode.utility.InputUtils;
import sk.streetofcode.utility.PrintUtils;

public class HeroAbilityManager {
    private final Hero hero;

    public HeroAbilityManager(Hero hero) {
        this.hero = hero;
    }
    public void spendHeroAvailablePoints() {
        int availablePoints = this.hero.getHeroAvailablePoints();

        if (availablePoints == 0) {
            System.out.println("You have no points to spend!");
            return;
        }

        while (availablePoints > 0) {
            System.out.println("You have " + availablePoints + " points to spend.");
            System.out.println("Choose ability to upgrade:");
            System.out.println("0. Explain abilities");
            System.out.println("1. Attack");
            System.out.println("2. Defence");
            System.out.println("3. Dexterity");
            System.out.println("4. Skill");
            System.out.println("5. Luck");
            System.out.println("6. Health");
            final int abilityIndex = InputUtils.readInt();
            Ability ability;
            switch (abilityIndex) {
                case 0 -> {
                    for (Ability a : Ability.values()) {
                        System.out.println(a + ": " + a.getDescription());
                    }
                    System.out.println();
                    continue;
                }
                case 1 -> ability = Ability.ATTACK;
                case 2 -> ability = Ability.DEFENCE;
                case 3 -> ability = Ability.DEXTERITY;
                case 4 -> ability = Ability.SKILL;
                case 5 -> ability = Ability.LUCK;
                case 6 -> ability = Ability.HEALTH;
                default -> {
                    System.out.println("Invalid ability index!");
                    continue;
                }
            }
            this.hero.updateAbility(ability, 1);
            System.out.println("You have upgraded " + ability);
            this.hero.updateHeroAvailablePoints(-1);
            availablePoints--;
            if (availablePoints > 1) {
                PrintUtils.printAbilities(this.hero);
            }
        }

        System.out.println("You have spent all your points. Your abilities are:");
        PrintUtils.printAbilities(this.hero);
    }
}
