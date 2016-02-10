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
public class T20_IfElseRange {

    static int testNew(int testval, int start, int stop) {

        if (testval >= start && testval <= stop) {
            return 1; //входит
        } else {
            return 0;//не входит
        }

    }

    public static void main(String[] args) {
        

        print(testNew(5, 1, 8));
        print(testNew(-2, 1, 8));
        print(testNew(10, 1, 8));
        print(testNew(1, 1, 8));
        print(testNew(8, 1, 8));

    }

}
