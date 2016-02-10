/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch05_init_and_close;

import static net.mindview.util.Print.print;

/**
 *
 * @author D2E
 */

class Box1{
static String first="first";
static String second;

static{
    second="second";
    }

static void show(){
print(first);
print(second);

}
}

class T14_InitBeforeUse {
    public static void main(String[] args) {
        Box1.show();
    }
}
