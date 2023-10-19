package sk.streetofcode.domain;

public class LoadedGame {
    private final Hero hero;
    private final int currentLevel;

    public LoadedGame(Hero hero, int currentLevel) {
        this.hero = hero;
        this.currentLevel = currentLevel;
    }

    public Hero getHero() {
        return hero;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }
}


