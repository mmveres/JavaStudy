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
class StringArray {

}

public class T16_StringArray {

    static String[] array = {"one", "two", "three"};

    public static void main(String[] args) {
        for(String x:array){
        print(x);
        }
    }
}
