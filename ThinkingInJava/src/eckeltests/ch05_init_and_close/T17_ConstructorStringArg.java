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

class ArgString{
String intValue;

    public ArgString(String intValue) {
        this.intValue = intValue;
        print(intValue);
    }


}

public class T17_ConstructorStringArg {
    
    
    public static void main(String[] args) {
        ArgString[] array = new ArgString[4];
        for (int i = 0; i < array.length; i++) {
            array[i]=new ArgString("value of " +i);
            
        }
        
    }
}
