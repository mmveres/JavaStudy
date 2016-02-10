/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch05_init_and_close;

import static net.mindview.util.Print.print;

/**
 *
 * @author D2E
 */

class T19_Test{

    static void  printStringSet(String... args){
        for (String arg : args) {
            print(arg);
            
        }
        
    }
    
    public static void main(String... args) {
        for (String arg : args) {
            print(arg);}
    }
}

public class T19_StringVarLengthArg {
    static String[] array={"one","two", "three", "four"};
    
    public static void main(String[] args) {
        T19_Test.printStringSet(array);
        T19_Test.printStringSet("a","b","c","d");
        T19_Test.main(array);
        T19_Test.main("a","b","c","d");
        
    }
}
