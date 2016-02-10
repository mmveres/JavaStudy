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
public class T23_Fibonacci {

    public static int fibonacciRec(int value) {
        if (value == 0) {
            return 0;
        } else if (value == 1) {
            return 1;
        } else {
            return fibonacciRec(value - 2) + fibonacciRec(value - 1);
        }

    }

    public static int fibonacciIter(int value) {
        int fibN2 = 0;
        int fibN1 = 1;
        int tmp = fibN1;

        for (int i = 0; i < value; i++) {
            tmp = fibN1 + fibN2;
            fibN2 = fibN1;
            fibN1 = tmp;

        }
        return fibN1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 35; i++) {
            print(i + " " +fibonacciIter(i));
            
        }
    }

}
