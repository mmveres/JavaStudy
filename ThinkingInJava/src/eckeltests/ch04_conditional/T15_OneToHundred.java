/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch04_conditional;

/**
 *
 * @author D2E
 */
public class T15_OneToHundred {
    static class Generator{
            static void generate(){
                for (int i = 1; i < 101; i++) {
                    System.out.println("next I: " + i);
                    
                }
}
    }
    
    public static void main(String[] args) {
        Generator.generate();
    }
}
