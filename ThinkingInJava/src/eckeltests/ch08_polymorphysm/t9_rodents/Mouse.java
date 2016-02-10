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
public class Mouse extends Rodent {

    private String name = "Mouse";
    private String food = "cheese";
    private String location = "under bed";
    private String sound = "'Pi-pi-pi...'";
    private Tooth tooth= new Tooth();
        
    
    public Mouse(Air air) {
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
