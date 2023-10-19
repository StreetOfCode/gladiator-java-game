package sk.streetofcode.service;

import sk.streetofcode.domain.Enemy;
import sk.streetofcode.domain.Hero;
import sk.streetofcode.utility.InputUtils;
import sk.streetofcode.utility.PrintUtils;

public class BattleService {

    public BattleService() {
    }

    public boolean isHeroReadyToBattle(Hero hero, Enemy enemy) {
        System.out.println(hero.getName() + " VS " + enemy.getName());
        System.out.println("View your abilities:");
        PrintUtils.printAbilities(hero);
        System.out.println("View enemy abilities:");
        PrintUtils.printAbilities(enemy);

        System.out.println("Are you ready to fight?");
        System.out.println("0. No");
        System.out.println("1. Yes");

        final int choice = InputUtils.readInt();
        switch (choice) {
            case 0 -> {
                System.out.println("You have escaped from the battle!");
                return false;
            }
            case 1 -> {
                System.out.println("Let the battle begin!");
                return true;
            }
            default -> {
                System.out.println("Invalid choice!");
                return false;
            }
        }
    }
}
