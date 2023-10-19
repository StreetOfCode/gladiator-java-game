package sk.streetofcode.service;

import sk.streetofcode.ability.HeroAbilityManager;
import sk.streetofcode.domain.Hero;
import sk.streetofcode.utility.InputUtils;
import sk.streetofcode.utility.PrintUtils;

public class GameManager {
    private final HeroAbilityManager heroAbilityManager;
    private final Hero hero;

    public GameManager() {
        this.hero = new Hero("");
        this.heroAbilityManager = new HeroAbilityManager(this.hero);
    }

    public void startGame()  {
        System.out.println("Welcome to the Gladiatus game!");
        System.out.println("Enter your name: ");
        final String name = InputUtils.readString();
        final Hero hero = new Hero(name);
        System.out.println("Hello " + hero.getName() + "! Let's start the game!");
        PrintUtils.printDivider();
        System.out.println("Your abilities are:");
        PrintUtils.printAbilities(hero);
        PrintUtils.printDivider();
        System.out.println();
        this.heroAbilityManager.spendHeroAvailablePoints();
    }
}
