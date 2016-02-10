/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess;

import java.util.ArrayList;

/**
 * Class provides standard system output all game states
 * @author D2E
 */
public class Publisher {

    
    public Publisher() {
        
     } 

/**
 * Prints welcome message
 * 
 */  
    void showWelcomeMsg() {
        System.out.println(Hardcoded.MSG_WELCOME);
    }
/**
 * Prints error message
 * 
 */  
    void showErrorMSG() {
        System.out.println(Hardcoded.MSG_ERROR_INPUT);
    }
/**
 * Notifies that input was bigger than MAX bound of range
 * 
 */  
    void showMaxExceeded() {
        System.out.println(Hardcoded.MSG_OUT_OF_MAX);
    }

/**
 * Notifies that input was smaller than MIN bound of range
 * 
 */  
    
    
    void showMinExceeded() {
        System.out.println(Hardcoded.MSG_OUT_OF_MIN);
    }
/**
 * Notifies that input was smaller than secret value
 * 
 */ 

    
    void notifyValueIsSmaller() {
        System.out.println(Hardcoded.MSG_SMALLER);
    }
/**
 * Notifies that input was bigger than secret value
 * 
 */ 

    void notifyValueIsBigger() {
        System.out.println(Hardcoded.MSG_BIGGER);

    }
/**
 * Provides current range value is in
 * 
 */ 

    void showCurrentRange(int rangeMin, int rangeMax) {
        System.out.println(Hardcoded.MSG_RANGE + rangeMin + " " + rangeMax);
    }
/**
 * Congratulates player
 * 
 */ 

    void showBingo() {
        System.out.println(Hardcoded.MSG_BINGO);
    }

/**
 * Shows statistics, integer is needed as argument for randValue, ArrayList<Integer> where history of
 * guesses are kept for inputHistory
 * 
 */    
    
    void showStatistics(int randValue, ArrayList<Integer> inputHistory) {
        System.out.println(Hardcoded.MSG_NUM_IS + randValue);
        System.out.println(Hardcoded.MSG_STEPS_TAKEN + inputHistory.size());
        System.out.println(Hardcoded.MSG_NUMS_ENTERED + inputHistory.toString());
    }
    
}
