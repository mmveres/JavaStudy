/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch10_innerclasses.t06.parent;

import eckeltests.ch10_innerclasses.t06.iface.Doable;

/**
 *
 * @author d2e
 */
public class Outer {
    protected class Inner implements Doable{

        @Override
        public void doSomething() {
            System.out.println("It's done!");
        }
    }
    
    public Inner getInner(){
        return new Inner();}
}
