/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch08_polymorphysm.t9_rodents;

import static net.mindview.util.Print.print;

/**
 *
 * @author D2E
 */
public class Rodent {

    private String name = "rodent";
    private String food = "some food";
    private String location = "some location";
    private String sound = "'Mmm ?'";
    private Tooth tooth = new Tooth();
    
    private Rodent(){};

    public Rodent(Air air) {
        print("Init " + name);
    }

    public void eat() {
        print(name + " eats " + food);
    }

    public void go() {
        print(name + " goes " + location);
    }

    public void say() {
        print(name + " says " + sound);
    }

    @Override
    public String toString() {
        return "r{" + "name=" + name + '}';
    }

}
