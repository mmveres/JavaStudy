/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch05_init_and_close;

import static net.mindview.util.Print.print;

/**
 *
 * @author D2E
 */
class Tank {

    public static final int MAX_CAPACITY = 100;
    public static final int MIN_CAPACITY = 0;

    private int currCapacity;

    Tank() {
        this(10);
    }

    Tank(int usedCapacity) {
        this.currCapacity = Math.abs(usedCapacity);
    }

    public void addFuel(int volume) {
        currCapacity = currCapacity + Math.abs(volume);
        if (currCapacity > MAX_CAPACITY) {
            System.out.println("Max achieved!");
            currCapacity = MAX_CAPACITY;
        }
    }

    public void useFuel(int volume) {
        currCapacity = currCapacity - Math.abs(volume);
        if (currCapacity < MIN_CAPACITY) {
            System.out.println("No fuel left!");
            currCapacity = MIN_CAPACITY;
        }
    }

    @Override
    public String toString() {
        return "Tank{" + "current capacity=" + currCapacity + '}';
    }

    @Override
    protected void finalize() throws Throwable {

        if (currCapacity > MIN_CAPACITY) {
            System.out.println(this.hashCode()+" Not emty!");

        } else {
            System.out.println(this.hashCode()+" tank destroyed!");
            super.finalize(); //To change body of generated methods, choose Tools | Templates.s
        }
    }

}

public class T12_Tank {

    public static void main(String[] args) {
        Tank t = new Tank();
        print(t);
        t.addFuel(12);
        print(t);
        t.useFuel(21);
        print(t);
        t = null;
        System.gc();
        t = new Tank();
        print(t);
        t.useFuel(10);
        print(t);
        t = null;
        System.gc();
    }
}
