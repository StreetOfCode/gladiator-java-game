package sk.streetofcode;

import sk.streetofcode.service.GameManager;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GameManager manager = new GameManager();
        manager.startGame();
    }
}
