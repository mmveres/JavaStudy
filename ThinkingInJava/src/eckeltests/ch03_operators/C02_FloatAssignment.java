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


class TankF {
    float fuelLevel;
}
public class C02_FloatAssignment {

    public static void main(String[] args) {
        TankF t1 = new TankF();
        TankF t2 = new TankF();
        t1.fuelLevel = 9f;
        t2.fuelLevel = 23f;
        System.out.println("t1.level= " + t1.fuelLevel + " t2.level= " + t2.fuelLevel);
        t1 = t2;
        System.out.println("t1.level= " + t1.fuelLevel + " t2.level= " + t2.fuelLevel);
        t1.fuelLevel = 457f;
        System.out.println("t1.level= " + t1.fuelLevel + " t2.level= " + t2.fuelLevel);
    }
}
