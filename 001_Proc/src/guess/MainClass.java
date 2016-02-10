/*
 * Java game - try to guess number from provided range
 */
package guess;

import java.util.Scanner;

/**
 * This main class is intended to launch application only
 * @author D2E
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Publisher messageOut = new Publisher();
        Scanner scanUserInput = new Scanner(System.in);
        GameModel gameModel= new GameModel(messageOut, scanUserInput);
        gameModel.startGame();
        
        
        
    }
    
}
