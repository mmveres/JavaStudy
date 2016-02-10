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
public class Hamster extends Rodent {

    private String name = "Hamster";
    private String food = "corn";
    private String location = "into hole";
    private String sound = "'Tsss-tsss...'";
    private Tooth tooth= new Tooth();

    public Hamster(Air air) {
        super(air);
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
