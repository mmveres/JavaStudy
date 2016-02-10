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

class Entity{

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalization!");
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }



}

public class T10_FinalizeCheck {
    public static void main(String[] args) {
        Entity e=new Entity();
        e=null;
        System.gc();
    }
}
