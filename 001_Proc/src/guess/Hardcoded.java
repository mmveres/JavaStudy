/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess;

/**
 * This is the class where all hardcoded values are kept
 * @author D2E
 */
public class Hardcoded {

    public static final int RAND_MIN = 0;
    public static final int RAND_CURR = 100;
    public static final String EXIT_CHAR = "q";
    public static final String MSG_RANGE = "Pls enter your guess for INTEGER value in range: ";
    public static final String MSG_WELCOME = "Your aim is to guess secret number using min number of tries, while I will guide you."
            + "\nYou may enter (" + EXIT_CHAR + ") anytime to exit the game."
            + "\nGood luck!";

    public static final int RAND_MAX = 10000;
    public static final String MSG_ERROR_INPUT = "Input is not valid!";
    public static final String MSG_OUT_OF_MAX = "Error! You entered a number bigger than upper bound of range!";
    public static final String MSG_OUT_OF_MIN = "Error! You entered a number smaller than lower bound of range!";
    public static final String MSG_SMALLER = "Random number is SMALLER than your input!";
    public static final String MSG_BIGGER = "Random number is BIGGER than your input!";
    public static final String MSG_BINGO = "Bingo!";
    public static final String MSG_NUM_IS = "Secret number is ";
    public static final String MSG_STEPS_TAKEN="Steps taken to finish the game: ";
    public static final String MSG_NUMS_ENTERED="You entered following numbers: ";

}
