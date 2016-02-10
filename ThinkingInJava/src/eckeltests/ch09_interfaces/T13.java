/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch09_interfaces;

/**
 *
 * @author d2e
 */
 class T13 {

    /**
     * @param args the command line arguments
     */
    interface First {

        void goFirst();
    }

    interface SecondA extends First {

        void goSecondA();
    }

    interface SecondB extends First {

        void goSecondB();
    }

    interface Third00 extends SecondA, SecondB {

        void goThird();
    }

    class Third implements SecondA, SecondB {

        @Override
        public void goSecondA() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void goFirst() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void goSecondB() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
