/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch08_polymorphysm;

import static net.mindview.util.Print.print;

/**
 *
 * @author D2E
 */
class Starship {

    AlertStatus[] alStats = {new AlertStatusLow(), new AlertStatusNormal(), new AlertStatusHigh()};
    AlertStatus as=alStats[(int)(Math.random()*3)];

    public void rndAlertStatus() {
        as=alStats[(int)(Math.random()*3)];
    }
    
    public void showAlertStatus(){
    as.showStatus();
    }
}

class AlertStatus {

    public void showStatus() {
    }
};

class AlertStatusLow extends AlertStatus {

    public void showStatus() {
        print("Alert low!");
    }
}

class AlertStatusNormal extends AlertStatus {

    public void showStatus() {
        print("Alert moderate!");
    }
}

class AlertStatusHigh extends AlertStatus {

    public void showStatus() {
        print("Alert high!");
    }
}

public class T17_StarShip {
    public static void main(String[] args) {
        Starship starship = new Starship();
        for (int i = 0; i < 10; i++) {
            starship.showAlertStatus();
            starship.rndAlertStatus();
            
        }
    }
}
