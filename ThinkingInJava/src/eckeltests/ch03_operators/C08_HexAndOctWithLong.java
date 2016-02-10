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
public class C08_HexAndOctWithLong {

    public static void main(String[] args) {
        long value = Long.MAX_VALUE;

        
        System.out.println(value);
        System.out.println(Long.toHexString(value));
        System.out.println(Long.toOctalString(value));
        System.out.println(Long.toBinaryString(value));
        value = 0777777777777777777777L;
        System.out.println(value);
        System.out.println(Long.toHexString(value));
        System.out.println(Long.toOctalString(value));
        System.out.println(Long.toBinaryString(value));
        value=0x7fffffffffffffffL;
        System.out.println(value);
        System.out.println(Long.toHexString(value));
        System.out.println(Long.toOctalString(value));
        System.out.println(Long.toBinaryString(value));
        value=(long)Math.pow(2, 64);
        System.out.println(value);
        System.out.println(Long.toHexString(value));
        System.out.println(Long.toOctalString(value));
        System.out.println(Long.toBinaryString(value));
    }
}
