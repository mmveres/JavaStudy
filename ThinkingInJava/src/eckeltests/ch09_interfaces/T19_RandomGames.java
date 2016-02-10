/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch09_interfaces;

/**
 *
 * @author d2e
 */
interface Game {

    void getResult();
}

interface GameFactory {

    Game getGame();
}

class CubeGame implements Game {

    private static int id = 1;
    private int currId;

    public CubeGame() {
        currId = id++;
        System.out.println("Cube game #" + currId + " created");

    }

    @Override
    public void getResult() {
        System.out.println("Cube game #" + currId + ". Current result: " + ((int) (Math.random() * 6 + 1)));
    }
}

class CoinGame implements Game {

    private static int id = 1;
    private int currId;

    public CoinGame() {
        currId = id++;
        System.out.println("Coin game #" + currId + " created");
    }

    @Override
    public void getResult() {
        if (Math.random() * 2 > 1.0) {
            System.out.println("Coin game #" + currId + ". Current result: avers");
        } else {
            System.out.println("Coin game #" + currId + ". Current result: reverse");
        }

    }
}

class RandomGame implements GameFactory {

    @Override
    public Game getGame() {
        if (Math.random() * 2 > 1.0) {
            return new CoinGame();
        } else {
            return new CubeGame();
        }
    }
}

 class T19_RandomGames {

    public static void main(String[] args) {
        RandomGame rg = new RandomGame();
        Game[] games = new Game[4];
        for (int i = 0; i < games.length; i++) {
            games[i] = rg.getGame();

        }
        for (int j = 0; j < 5; j++) {

            for (int i = 0; i < games.length; i++) {
                System.out.println("index " + i);
                games[i].getResult();

            }
            System.out.println("========NEXT CYCLE===============");
        }

    }
}
