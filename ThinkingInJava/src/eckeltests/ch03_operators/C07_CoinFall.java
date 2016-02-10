/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch03_operators;

/**
 *
 * @author D2E
 */
public class C07_CoinFall {
    public static void main(String[] args) {
        String side = "avers";
        
        if ((float)Math.random()<0.5f){side="revers";}
        
        System.out.println("Coin falls: " + side);
    }
}
