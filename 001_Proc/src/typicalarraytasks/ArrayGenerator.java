/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typicalarraytasks;

/**
 *
 * @author D2E
 */
public class ArrayGenerator {
    private int[] testArray;
    private int minValue=-20;
    private int maxValue=20;
    
    public int[] getRandomArray(int size){
        testArray=new int[size];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i]= minValue + (int)(Math.random()*(maxValue-minValue));
            
        }
        return testArray;
    }
}
