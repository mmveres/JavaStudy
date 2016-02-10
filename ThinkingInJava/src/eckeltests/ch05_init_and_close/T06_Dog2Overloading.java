/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch05_init_and_close;

/**
 *
 * @author D2E
 */

class Dog2 {

    void bark(int i, String txt) {
        String sound="l";
        for (int j = 0; j < i; j++) {
            sound=sound+"o";
            
        }
        System.out.println(sound+"ng sound of " + txt);
    }
    
    void bark(String txt, int i) {
        for (int j = 0; j < i; j++) {
System.out.println("bark #" + i+ " "+ txt);
            
        }
        
    }
    
    void bark(long i, String value) {
        System.out.println("loooong vuf! " + i);
    }
    void bark(float i) {
        System.out.println("floating howl! " + i);
    }
    void bark(double i) {
        System.out.println("double  bark! " + i);
    }
    
}

public class T06_Dog2Overloading {
    public static void main(String[] args) {
        Dog2 chuppy=new Dog2();
    chuppy.bark("szuko", 10);
    chuppy.bark(18, "cat");
    }
    
    
}
