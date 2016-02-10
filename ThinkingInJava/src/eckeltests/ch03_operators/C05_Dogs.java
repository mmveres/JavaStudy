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
class Dog {

    String name;
    String says;
}

public class C05_Dogs {

    public static void main(String[] args) {
        Dog spot = new Dog();
        Dog scruffy = new Dog();
        spot.name = "spot";
        scruffy.name = "scruffy";
        spot.says = "vuf";
        scruffy.says = "bark";
        System.out.println(" dog name " + spot.name + " is and it says " + spot.says);
        System.out.println(" dog name " + scruffy.name + " is and it says " + scruffy.says);
        Dog newDog = new Dog();
        spot=newDog;
        System.out.println(spot==newDog);
        System.out.println(spot.equals(newDog));
    }

}
