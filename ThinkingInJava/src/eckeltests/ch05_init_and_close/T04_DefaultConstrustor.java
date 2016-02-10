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
class Vow {

    Vow() {
        System.out.println("Vow!");
    }
    
    Vow(String text){
        System.out.println("Vow! " + text);
    }
}

public class T04_DefaultConstrustor {
    public static void main(String[] args) {
        Vow vow=new Vow();
        Vow test = new Vow("dimka");
    }
}
