/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch08_polymorphysm.t10;

/**
 *
 * @author D2E
 */
public class MyExecutor {
ClassA obj;

    private void execute() {
        obj=new ClassB();
        obj.first();
    }
    
    
    public static void main(String[] args) {
        MyExecutor e=new MyExecutor();
        e.execute();
        
    }
}
