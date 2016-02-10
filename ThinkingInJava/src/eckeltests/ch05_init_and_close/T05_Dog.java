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
class Dog1 {

    void bark(int i) {
        System.out.println("bark it is! " + i);
    }
    void bark(long i) {
        System.out.println("loooong vuf! " + i);
    }
    void bark(float i) {
        System.out.println("floating howl! " + i);
    }
    void bark(double i) {
        System.out.println("double  bark! " + i);
    }
    
}
    


public class T05_Dog {
    public static void main(String[] args) {
        Dog1 dog=new Dog1();
        dog.bark(1);
        dog.bark(1L);
        dog.bark(1.0d);
        dog.bark(1.0F);
    }
}
