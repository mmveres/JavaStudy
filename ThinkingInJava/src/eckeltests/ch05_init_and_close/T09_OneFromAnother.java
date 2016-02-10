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

class Box{
int height;
String heightUnit;

public Box(){
    this(0,"meters");
}

    public Box(int height, String heightUnit) {
        this.height = height;
        this.heightUnit = heightUnit;
    }

    @Override
    public String toString() {
        return "Box{" + "height=" + height + ", heightUnit=" + heightUnit + '}';
    }

}

class  T09_OneFromAnother {
    public static void main(String[] args) {
        Box b1=new Box();
        Box b2=new Box(2, "feet");
        System.out.println(b1 + " <-> " +b2);
        
    }
}
