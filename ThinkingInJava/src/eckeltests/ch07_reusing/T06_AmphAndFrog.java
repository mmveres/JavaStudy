/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch07_reusing;

/**
 *
 * @author D2E
 */
class Amphie {

    public void dive() {
        System.out.println("dive_amph");
    }

    public void swim() {
        System.out.println("swim_amph");
    }

    public void jump() {
        System.out.println("jump_amph");
    }

}

class Frog extends Amphie {
    public void dive() {
        System.out.println("dive_frg");
    }

    public void swim() {
        System.out.println("swim_frg");
    }

    public void jump() {
        System.out.println("jump_frg");
    }
    
    
}

public class T06_AmphAndFrog {
private static Amphie test;

    public static void main(String[] args) {
       test = new Frog();
       test.dive();
       test.swim();
       test.jump();
    }
}
