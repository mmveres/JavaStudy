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
public class C04_SpeedCalc {

    public static void main(String[] args) {
        float timeHrs = 10f;
        float distKm = 400f;
        float speedKmPerHr = distKm/timeHrs;
        System.out.println("distance: " + distKm + " teme: " + timeHrs + " speed: " + speedKmPerHr);
    }
}
