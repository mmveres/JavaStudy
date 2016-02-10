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
enum Currency{
    RUBLE,
    ESCUDO,
    TENGE,
    EURO,
    DINAR,
    PESO
    
}

class Selector {
    
    public static void listAll(){
        for (Currency c : Currency.values()) {
            print(c + ", ordinal " + c.ordinal());
            
        }
}
}

public class T21_EnumCurrency {
    public static void main(String[] args) {
        Selector.listAll();
    }
}
