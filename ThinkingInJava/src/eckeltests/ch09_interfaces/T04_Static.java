/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch09_interfaces;

/**
 *
 * @author D2E
 */
abstract class AC {
    AC ac;
    
}

class DC extends AC {

    public void current() {
        System.out.println("direct");
    }
}

 class T04_Static {
    

}
