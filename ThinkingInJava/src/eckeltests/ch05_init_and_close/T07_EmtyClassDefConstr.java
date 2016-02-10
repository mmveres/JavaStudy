/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch05_init_and_close;

/**
 *
 * @author D2E
 */

class Cat{}

public class T07_EmtyClassDefConstr {
    public static void main(String[] args) {
        Cat cat=new Cat();
        System.out.println(cat.hashCode());
    }
}
