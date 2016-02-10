/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch03_operators;

/**
 *
 * @author D2E
 */
public class C13_LetThenRight {

    static int value = 0xFFFF;

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(value));
        value = value << 1;
        System.out.println(Integer.toBinaryString(value));
        value = value >>> 1;
        System.out.println(Integer.toBinaryString(value));
        value = value >>> 1;
        System.out.println(Integer.toBinaryString(value));
        value = value >>> 1;
        System.out.println(Integer.toBinaryString(value));
        value = value >>> 1;
        System.out.println(Integer.toBinaryString(value));
        value = value >>> 1;
        System.out.println(Integer.toBinaryString(value));
        value = -17;
        System.out.println(Integer.toBinaryString(value));
        value=value>>2;
        System.out.println(Integer.toBinaryString(value));
        System.out.println(value);
        value=-17;
        value=value>>>2;
        System.out.println(Integer.toBinaryString(value));
        System.out.println(value);
    }
}
