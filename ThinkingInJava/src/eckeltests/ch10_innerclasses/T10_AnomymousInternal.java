/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch10_innerclasses;

/**
 *
 * @author d2e
 */

interface Rattable{
void callRat();}



public class T10_AnomymousInternal {
    Rattable getRat(){
    return new Rattable() {
        @Override
        public void callRat() {
            System.out.println("Rat is called!");
        }
    };
    }
    public static void main(String[] args) {
        Rattable r = new T10_AnomymousInternal().getRat();
        r.callRat();
    }
}
