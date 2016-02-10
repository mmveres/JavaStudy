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
interface Chef {

    void cook();
}

class Outer1 {

    Chef getInner() {
        return new Inner1();
    }

    private class Inner1 implements Chef {

        @Override
        public void cook() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}

public class T09_PrivateInner2 {

    public static void main(String[] args) {
        Outer1 o1=new Outer1();
        System.out.println(o1.getInner().getClass());
    }
}
