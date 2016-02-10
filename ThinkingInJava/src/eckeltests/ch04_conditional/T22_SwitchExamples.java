/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch04_conditional;

import static net.mindview.util.Print.print;

/**
 *
 * @author D2E
 */
public class T22_SwitchExamples {
    
    public static void switchWithBreaks(){
        for (int i = 0; i < 11; i++) {
            print("<------->");
            switch(i){
                case 1:
            print("one");
            break;
                case 2:
            print("two");
            break;
                case 3:
            print("three");
            break;
                case 4:
            print("four");
            break;
                case 5:
            print("five");
            break;
                case 6:
            print("six");
            break;
                case 7:
            print("seven");
            break;
                case 8:
            print("eight");
            break;
                case 9:
            print("nine");
            break;
                default:
            print("zero or ten");
            break;}
            
        }
}
    public static void switchWithNoBreaks(){
        for (int i = 0; i < 11; i++) {
            print("<------->");
            switch(i){
                case 1:
            print("one");
            
                case 2:
            print("two");
            
                case 3:
            print("three");
            
                case 4:
            print("four");
            
                case 5:
            print("five");
            
                case 6:
            print("six");
            
                case 7:
            print("seven");
            
                case 8:
            print("eight");
            
                case 9:
            print("nine");
            
                default:
            print("zero or ten");
            }
            
        }
}
    public static void main(String[] args) {
        switchWithBreaks();
        print("========================");
        switchWithNoBreaks();
    }
    
}
