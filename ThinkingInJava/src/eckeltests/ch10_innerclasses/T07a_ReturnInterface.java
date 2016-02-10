/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch10_innerclasses;

/**
 *
 * @author d2e
 */
interface Testable {

    void test();
}

public class T07a_ReturnInterface {

    Testable returnInterface() {
        class InnerTest implements Testable {

            @Override
            public void test() {
                System.out.println("test is done!");
            }
        }
        return new InnerTest();
    }

    public static void main(String[] args) {
        Testable t = new T07a_ReturnInterface().returnInterface();
        t.test();
    }
}
