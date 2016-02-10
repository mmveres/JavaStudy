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
class SuperString {

    String value;

    {
        value = "_default_";
    }

    @Override
    public String toString() {
        return value;
    }

}

public class T15_ExtendsStringAndInit {
    public static void main(String[] args) {
        print(new SuperString());
    }
}
