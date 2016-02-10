/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch08_polymorphysm.t9_rodents;

import java.util.Arrays;
import static net.mindview.util.Print.print;

/**
 *
 * @author D2E
 */
public class Pack {



    Rodent[] rodents = new Rodent[12];

    @Override
    public String toString() {
        return "Pack{" + Arrays.toString(rodents)+ "}"; 
    }
    
    

    public void makePack() {
        for (int i = 0; i < rodents.length; i++) {
            rodents[i] = rndRodent();

        }
    }

    private Rodent rndRodent() {
        switch ((int) (Math.random() * 2)) {
            case 0:
                return new Hamster(Air.getAir());
            case 1:
                return new Mouse(Air.getAir());
            default:
                return null;
        }
    }
    
    public static void main(String[] args) {
        Pack pack = new Pack();
        pack.makePack();
        print(pack);
        pack.allDoAll();
        
        
        
    }

    public void allDoAll() {
        for (Rodent r : rodents) {
            r.eat();
            r.go();
            r.say();
            
        }
    }
}
