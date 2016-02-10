/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch08_polymorphysm.t10;

import static net.mindview.util.Print.print;

/**
 *
 * @author D2E
 */
public class ClassA {
    
    public void first(){
    print("Calling second mtd in class A");
    second();
    
    }

    public void second() {
        print("Second mtd in class A called");
    }
}
