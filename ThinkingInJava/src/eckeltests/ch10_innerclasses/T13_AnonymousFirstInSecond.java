/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch10_innerclasses;

/**
 *
 * @author d2e
 */
class T13_First {

    private int x;

    public int getX() {
        return x;
    }
    
    

    public T13_First(int i) {
        x = i;
        System.out.println("Instance called with " + x);

    }

}

class T13_Second {

    T13_First getT13_First(int i) {
        return new T13_First(i) {

            
            public int getX() {
                
                return super.getX()*4; //To change body of generated methods, choose Tools | Templates.
            }
            
        };

    }
}

public class T13_AnonymousFirstInSecond {
    public static void main(String[] args) {
        T13_Second t13s=new T13_Second();
        T13_First t13f=t13s.getT13_First(2);
        System.out.println(t13f.getX());
    }
}
