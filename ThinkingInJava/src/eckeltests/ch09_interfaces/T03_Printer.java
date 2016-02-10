/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch09_interfaces;

/**
 *
 * @author D2E
 */
abstract class Printer {

    public Printer() {
        print();
    }

    
    
    abstract void print();

}

class LaserPrinter extends Printer {

    private String type = "Laser";

    void print() {
        System.out.println(type);
    }
}
class inkPrinter extends Printer {

    private String type = "Ink";

    void print() {
        System.out.println(type);
    }
}

 class T03_Printer {
    public static void main(String[] args) {
        LaserPrinter laserPrinter = new LaserPrinter();
        laserPrinter.print();
    }
}
