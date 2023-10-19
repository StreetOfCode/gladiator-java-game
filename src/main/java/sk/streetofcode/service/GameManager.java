package sk.streetofcode.service;

import sk.streetofcode.ability.HeroAbilityManager;
import sk.streetofcode.constant.Constants;
import sk.streetofcode.domain.Enemy;
import sk.streetofcode.domain.Hero;
import sk.streetofcode.domain.LoadedGame;
import sk.streetofcode.utility.EnemyGenerator;
import sk.streetofcode.utility.InputUtils;
import sk.streetofcode.utility.PrintUtils;

import java.util.Map;

public class GameManager {
    private final HeroAbilityManager heroAbilityManager;

    private final Map<Integer, Enemy> enemiesByLevel;
    private Hero hero;
    private final FileService fileService;
    private final BattleService battleService;
    private int currentLevel;

    public GameManager() {
        this.hero = new Hero("");
        this.fileService = new FileService();
        this.battleService = new BattleService();
        this.heroAbilityManager = new HeroAbilityManager(this.hero);
        this.currentLevel = Constants.INITIAL_LEVEL;
        this.enemiesByLevel = EnemyGenerator.createEnemies();
    }

    public void startGame() {
        this.initGame();

        while (this.currentLevel <= this.enemiesByLevel.size()) {
            final Enemy enemy = this.enemiesByLevel.get(this.currentLevel);
            System.out.println("0. Fight " + enemy.getName() + " (level " + this.currentLevel + ")");
            System.out.println("1. Upgrade abilities (" + this.hero.getHeroAvailablePoints() + " points left)");
            System.out.println("2. Save game");
            System.out.println("3. Exit game");

            final int choice = InputUtils.readInt();
            switch (choice) {
                case 0 -> {
                    if (battleService.isHeroReadyToBattle(this.hero, enemy)) {
                        // TODO battle
                        this.currentLevel++;
                    }
                }
                case 1 -> this.upgradeAbilities();
                case 2 -> fileService.saveGame(this.hero, this.currentLevel);
                case 3 -> {
                    System.out.println("Are you sure?");
                    System.out.println("0. No");
                    System.out.println("1. Yes");
                    final int exitChoice = InputUtils.readInt();
                    if (exitChoice == 1) {
                        System.out.println("Bye!");
                        return;
                    }
                    System.out.println("Continuing game...");
                    PrintUtils.printDivider();
                }
                default -> System.out.println("Invalid choice!");
            }
        }

        System.out.println("You have won the game! Congratulations!");
    }

    private void initGame() {
        System.out.println("Welcome to the Gladiatus game!");
        System.out.println("0. Start new game");
        System.out.println("1. Load game");

        final int choice = InputUtils.readInt();
        switch (choice) {
            case 0 -> System.out.println("Let's go then.");
            case 1 -> {
                final LoadedGame loadGame = fileService.loadGame();
                if (loadGame != null) {
                    this.hero = loadGame.getHero();
                    this.currentLevel = loadGame.getCurrentLevel();
                    return;
                }
            }
            default -> System.out.println("Invalid choice!");
        }

        System.out.println("Enter your name: ");
        final String name = InputUtils.readString();
        this.hero.setName(name);
        System.out.println("Hello " + hero.getName() + "! Let's start the game!");
        PrintUtils.printDivider();
        System.out.println("Your abilities are:");
        PrintUtils.printAbilities(hero);
        PrintUtils.printDivider();
        System.out.println();
        this.heroAbilityManager.spendHeroAvailablePoints();
    }

    private void upgradeAbilities() {
        System.out.println("Your abilities are:");
        PrintUtils.printAbilities(this.hero);

        System.out.println("0. Go back");
        System.out.println("1. Spend points (" + this.hero.getHeroAvailablePoints() + " points left)");
        System.out.println("2. Remove points");

        final int choice = InputUtils.readInt();
        switch (choice) {
            case 0 -> {
            }
            case 1 -> this.heroAbilityManager.spendHeroAvailablePoints();
            case 2 -> this.heroAbilityManager.removeHeroAvailablePoints();
            default -> System.out.println("Invalid choice!");
        }
    }
}
