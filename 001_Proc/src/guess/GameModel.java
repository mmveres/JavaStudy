/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Game logic is kept here, you need @Publisher and standard @Scanner classes to run the game
 * @author D2E
 */
public class GameModel {

    private Publisher publisher;
    private Scanner scanUserInput;
    private int randomValue;
    private int userInput;
    private ArrayList<Integer> inputHistory;
    private int rangeMin;
    private int rangeMax;
    private boolean exit = false;

    public GameModel(Publisher publisher, Scanner scanUserInput) {
        this.publisher = publisher;
        this.scanUserInput = scanUserInput;
    }

    private void initValues() {
        randomValue = rand(Hardcoded.RAND_MIN, Hardcoded.RAND_CURR);
        rangeMin = Hardcoded.RAND_MIN;
        rangeMax = Hardcoded.RAND_CURR;
        inputHistory = new ArrayList();

    }

    public void startGame() {

        initValues();
        showWelcomeMessages();
        handleInputs();
        if (!exit) {
            showStatistics();
        }

    }

    private void showWelcomeMessages() {
        publisher.showWelcomeMsg();
        //System.out.println(randomValue);

    }

    private int rand(int minRangeValue, int maxRangeValue) {
        int value;
        return value = minRangeValue + (int) (Math.random() * (maxRangeValue - minRangeValue));
    }

    private int rand() {
        int value;
        return value = rand(Hardcoded.RAND_MIN, Hardcoded.RAND_MAX);
    }

    private void handleInputs() {
        do {
            provideRange();
            validateInput();
            
            
        } while (userInput != randomValue && !exit);
    }

    private void validateInput() {
        
        if (scanUserInput.hasNext(Hardcoded.EXIT_CHAR)) {
            exit = true;
        } else if (scanUserInput.hasNextInt()) {
            userInput = scanUserInput.nextInt();
            inputHistory.add(userInput);
            responseToInput();

        } else {
            
            publisher.showErrorMSG();
            scanUserInput.next();
            
            
        }
    }

    private void responseToInput() {
        if (userInput >= rangeMax) {
            publisher.showMaxExceeded();
            
        } else if (userInput <= rangeMin) {
            publisher.showMinExceeded();
            
        } else if (userInput > randomValue) {
            publisher.notifyValueIsSmaller();
            rangeMax = userInput;
            
        } else if(userInput < randomValue){
            publisher.notifyValueIsBigger();
            rangeMin = userInput;        
        }else{
        }
    }

    private void showStatistics() {
        
       
        publisher.showBingo();
        publisher.showStatistics(randomValue,inputHistory);
    }

    private void provideRange() {
        publisher.showCurrentRange(rangeMin, rangeMax);
        
    }
}
