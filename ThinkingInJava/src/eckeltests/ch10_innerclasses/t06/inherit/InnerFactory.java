/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch10_innerclasses.t06.inherit;

import eckeltests.ch10_innerclasses.t06.iface.Doable;
import eckeltests.ch10_innerclasses.t06.parent.Outer;

/**
 *
 * @author d2e
 */
public class InnerFactory extends Outer{
    Doable getInnerClass(){
        return new Outer().getInner();
        
    }
}
