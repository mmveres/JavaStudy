/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch10_innerclasses;

/**
 *
 * @author d2e
 *
 */
class Outer {

    public int getCount() {
        return count;
    }

    private int count = 1;

    private void laugh() {
        System.out.println("Salyam aleykum!");
    }

    void callGenie() {
        Inner in = new Inner();
        in.changeOuter();
        //private method is accessible
        in.reverse();
        //private field is accessible
        in.innerCount=24;
    }

    class Inner {
        
        private int innerCount=1;

        private void reverse() {
            count = 22;
            laugh();
            laugh();
        }

        void changeOuter() {
            count++;
            laugh();
        }
    }

}

public class T07_PrivateInner {

    public static void main(String[] args) {
        Outer o = new Outer();
        System.out.println(o.getCount());
        o.callGenie();
        o.new Inner().changeOuter();
        System.out.println(o.getCount());
    }
}
