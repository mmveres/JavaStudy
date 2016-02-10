/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch04_conditional;

/**
 *
 * @author D2E
 */
public class T17_RandomInf {

    static class Random25 {

        static int prev;
        static int current;

        static void get25() {
            while (true) {
                current = (int) (Math.random() * 100);
                printCompare(prev, current);
                prev = current;

            }
        }

        private static void printCompare(int prev, int current) {
            if (current > prev) {
                System.out.println("new " + current + "  is bigger than old " + prev);
            } else if (current < prev) {
                System.out.println("new " + current + "  is smaller than old " + prev);
            }else{
                 System.out.println("new " + current + "  is equal to old " + prev);
            }
        }

    }
    
    public static void main(String[] args) {
        Random25.get25();
    }
}
