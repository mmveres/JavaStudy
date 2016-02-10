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
public class C10_PlaceOperatrors {

    public static void main(String[] args) {
        final int lowBit = 0x55;
        final int hiBit = 0xAA;
        int result = lowBit & hiBit;
        System.out.println("0" + Integer.toBinaryString(lowBit));
        System.out.println(Integer.toBinaryString(hiBit));
        System.out.println("logical AND: " + Integer.toBinaryString(result));
        result = lowBit | hiBit;
        System.out.println("0" + Integer.toBinaryString(lowBit));
        System.out.println(Integer.toBinaryString(hiBit));
        System.out.println("logical OR: " + Integer.toBinaryString(result));
        result = lowBit ^ hiBit;
        System.out.println("0" + Integer.toBinaryString(lowBit));
        System.out.println(Integer.toBinaryString(hiBit));
        System.out.println("logical XOR: " + Integer.toBinaryString(result));
        int x = 112;
        int y = 94;
        int z;
        z = x & y;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println("logical AND: " + Integer.toBinaryString(z));

        z = x | y;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println("logical OR: " + Integer.toBinaryString(z));
        z = x ^ y;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println("logical xOR: 0" + Integer.toBinaryString(z));
        
    }
}
