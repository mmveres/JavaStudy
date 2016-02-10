/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch09_interfaces.t10;

import static net.mindview.util.Print.print;

/**
 *
 * @author D2E
 */
enum Note {
    MIDDLE_C, C_SHARP, B_FLAT; // Etc.
}

interface Playable {

    void play(Note n);
}

 abstract class Instrument {
    // Compile-time constant:

    int VALUE = 5; // static & final
    // Cannot have method definitions:

    

    abstract void adjust();
}

class Wind extends Instrument implements Playable{

    public void play(Note n) {
        print(this + ".play() " + n);
    }

    public String toString() {
        return "Wind";
    }

    public void adjust() {
        print(this + ".adjust()");
    }
}

class Percussion extends Instrument implements Playable {

    public void play(Note n) {
        print(this + ".play() " + n);
    }

    public String toString() {
        return "Percussion";
    }

    public void adjust() {
        print(this + ".adjust()");
    }
}

class Stringed extends Instrument implements Playable {

    public void play(Note n) {
        print(this + ".play() " + n);
    }

    public String toString() {
        return "Stringed";
    }

    public void adjust() {
        print(this + ".adjust()");
    }
}

class Brass extends Wind {

    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {

    public String toString() {
        return "Woodwind";
    }
}

public class T10_MusicInt {
    // Doesn't care about type, so new types
    // added to the system still work right:

    static void tune(Playable p) {
        // ...
        p.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune((Playable)i);
        }
    }

    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = {
            new Wind(),
            new Percussion(),
            new Stringed(),
            new Brass(),
            new Woodwind()
        };
        tuneAll(orchestra);
    }
}
