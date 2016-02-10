/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch09_interfaces;

/**
 *
 * @author d2e
 */
interface Cycle {

    void move();
}

interface Automotive {

    Cycle getCycle(int type);
}

class Unicycle implements Cycle {

    public Unicycle() {
        System.out.println("Unicycle created");
    }

    @Override
    public void move() {
        System.out.println("Unicycle moved");
    }
}

class Bycicle implements Cycle {

    public Bycicle() {
        System.out.println("Bycicle created");
    }

    @Override
    public void move() {
        System.out.println("Bycicle moved");
    }
}

class Tricycle implements Cycle {

    public Tricycle() {
        System.out.println("Tricycle created");
    }

    @Override
    public void move() {
        System.out.println("Tricycle moved");
    }
}


class CycleFactory implements Automotive{
    public static final int UNICYCLE=0;
    public static final int BYCICLE=1;
    public static final int TRICYCLE=2;
    
    @Override
    public Cycle getCycle(int type) {
           switch(type){
            case UNICYCLE: return new Unicycle();
            case BYCICLE: return new Bycicle();
            case TRICYCLE: return new Tricycle();
            default: return new Unicycle();
           }
    }
}



 class T18_CycleFactory {
    
    
    public static void main(String[] args) {
        CycleFactory c = new CycleFactory();
        for (int i = 0; i < 10; i++) {
            c.getCycle((int)(Math.random()*3)).move();
         
        }
    }
}
