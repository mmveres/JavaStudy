/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraytasks2;

import java.util.Arrays;

/**
 *
 * @author D2E
 */
public class ArrayTasksMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arrayFloating[] = {2, 8, 1, 9, 6, 7, 5, 5, 5, 4, 1, 3, 9, 4, 3};
        System.out.println("=========sum==========");
        System.out.println(ArrayTasks.calcSumOfArrayElements(array));
        System.out.println("=========avg==========");
        System.out.println(ArrayTasks.getAverageArrayValue(array));
        System.out.println("=========findFirstMin==========");
        System.out.println(ArrayTasks.findFirstMin(arrayFloating));
        System.out.println("=========findLastMax==========");
        System.out.println(ArrayTasks.findLastMax(arrayFloating));
        System.out.println("=========findFirstValue==========");
        int index = ArrayTasks.findFirstValue(arrayFloating, 19);
        System.out.println(index == -1 ? " Not found"
                : "index = " + index + " value=" + arrayFloating[index]);
        System.out.println("=========zeroEvenElements==========");
        int tempArray[] = array.clone();
        ArrayTasks.zeroEvenElements(tempArray);
        System.out.println(Arrays.toString(tempArray));
        System.out.println(Arrays.toString(array));
        System.out.println("=========calcMatchCount==========");
        System.out.println(ArrayTasks.calcMatchCount(arrayFloating, 5));
        System.out.println("=========checkArraySortedIncreasing==========");
        System.out.println(ArrayTasks.checkArraySortedIncreasing(array));

        System.out.println(ArrayTasks.checkArraySortedIncreasing(arrayFloating));
        System.out.println("=========checkArraySortedDecreasing==========");
        System.out.println(ArrayTasks.checkArraySortedDecreasing(
                ArrayTasks.inverse(array)));
        System.out.println(Arrays.toString(array));
        System.out.println("=========shiftRightCyclic==========");

        System.out.println(Arrays.toString(ArrayTasks.shiftRightCyclic(array, 3)));
        System.out.println("=========shiftRightCyclicFast==========");
        System.out.println(Arrays.toString(ArrayTasks.shiftRightCyclicFast(array, 3)));
        System.out.println("=========shiftRightCyclicVeryFast==========");
        System.out.println(Arrays.toString(ArrayTasks.shiftRightCyclicVeryFast(array, 4)));

        System.out.println("=========printRepeats==========");
        ArrayTasks.printRepeats(arrayFloating);
        int reapeatingArray[] = {1, 2, 3, 2, 3, 4, 3, 5, 3};
        System.out.println("=========reapeating==========");
        System.out.println(Arrays.toString(reapeatingArray));
        ArrayTasks.printRepeatsAdditionalMemory(reapeatingArray);
        System.out.println("===========unique===============");
        ArrayTasks.printNonRepeats(reapeatingArray);
        System.out.println("=====difference=========");
        ArrayTasks.printDifference(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, reapeatingArray);
        System.out.println("=====merging==========");
        System.out.println(Arrays.toString(ArrayTasks.mergeTwoSortedArrays(
                new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 10},
                new int[]{2, 4, 5, 6, 8, 10}
        )));
        System.out.println("====merge sort=========");
        System.out.println(Arrays.toString(arrayFloating));
        ArrayTasks.mergeSort(arrayFloating);
        System.out.println(Arrays.toString(arrayFloating));

        System.out.println("========positive change========");
        int positiveChangeArray[] = {-1, 3, -5, -7, 2, 4, -4, -10, 6, -11, 12};
        System.out.println(Arrays.toString(positiveChangeArray));
        ArrayTasks.changePositive(positiveChangeArray);
        System.out.println(Arrays.toString(positiveChangeArray));
        ///-1 ,3,-5,-7,2,4,-4,-10,6,-11,12
        ///-11 , -5 , -7 ,-10, -4 || -1 || 4 , 2 ,6 ,3  
        ///-11 ,|| -5 , -7 ,-10, -4 || -1  2 3 4 6
        // -11 || - 7 , -10 || -5 -4 -1 2 3 4 5
        // -11  -10 , - 7 , -5 -4 -1 2 3 4 5

    }

}
