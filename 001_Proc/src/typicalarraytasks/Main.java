/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typicalarraytasks;

import java.util.Arrays;

/**
 *
 * @author D2E
 */
public class Main {

    private static int[] stubArray1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int[] stubArray4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int[] stubArray5 = {1, 2, 2, 4, 5, 6, 7, 8, 9, 10, 12, 12, -5, 6, -5, -18, 7, 10, 4, 4, 23, 18};
    private static int[] stubArray3 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static int[] stubArray2;
    private static int[] temp01 = new int[10];
    private static ArrayGenerator arrayGenerator;
    private static ArrayUtils arrayUtils;
    private static int[] stubArray6;
    private static int[] stubArray7;
    private static int[] stubArray8;
    private static int[] stubArray9;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        arrayGenerator = new ArrayGenerator();
        arrayUtils = new ArrayUtils();
        stubArray2 = arrayGenerator.getRandomArray(10);
        temp01 = stubArray2;

        System.out.println("for array " + Arrays.toString(stubArray2) + " sum of elements is "
                + arrayUtils.sumOfElements(stubArray2));

        System.out.println("for array " + Arrays.toString(stubArray2) + " first max Value is: "
                + stubArray2[arrayUtils.indexOfFirstMax(stubArray2)] + " with index of "
                + arrayUtils.indexOfFirstMax(stubArray2));

        System.out.println("for array " + Arrays.toString(stubArray2) + " first min Value is: "
                + stubArray2[arrayUtils.indexOfFirstMin(stubArray2)] + " with index of "
                + arrayUtils.indexOfFirstMin(stubArray2));

        System.out.println("for array " + Arrays.toString(stubArray1) + " average is "
                + arrayUtils.averageOf(stubArray1));

        int number = -5;
        System.out.println("for array " + Arrays.toString(stubArray2) + " count of matches for number "
                + number + " is " + arrayUtils.matchCount(stubArray2, number));

        System.out.println("for array " + Arrays.toString(stubArray2) + " count of matches bigger than "
                + number + " is " + arrayUtils.biggerThanCount(stubArray2, number));

        System.out.println("array " + Arrays.toString(stubArray2) + " myltiplied by "
                + number + " is " + Arrays.toString(arrayUtils.multipleByValue(stubArray2, number)));

        stubArray2 = arrayGenerator.getRandomArray(10);
        System.out.println("array " + Arrays.toString(stubArray2) + " with added index value "
                + " is " + Arrays.toString(arrayUtils.addIndexValue(stubArray2)));

        stubArray2 = arrayGenerator.getRandomArray(10);
        System.out.println("array " + Arrays.toString(stubArray2) + " with even value elements turned to 0"
                + " is " + Arrays.toString(arrayUtils.evenValuesToZero(stubArray2)));

        stubArray2 = arrayGenerator.getRandomArray(10);
        System.out.println("array " + Arrays.toString(stubArray2) + " with odd index elements turned to 0"
                + " is " + Arrays.toString(arrayUtils.oddIndexToZero(stubArray2)));

        stubArray2 = arrayGenerator.getRandomArray(10);
        System.out.println("for array " + Arrays.toString(stubArray2) + " first positive element is "
                + arrayUtils.indexToValue(stubArray2, arrayUtils.firstPositiveIndex(stubArray2)));

        System.out.println("for array " + Arrays.toString(stubArray2) + " last negative element is "
                + arrayUtils.indexToValue(stubArray2, arrayUtils.lastNegativeIndex(stubArray2)));

        System.out.println("for array " + Arrays.toString(stubArray2) + " and number " + number
                + " matching elements indexes are " + arrayUtils.matchIndexes(stubArray2, number).toString());

        System.out.println("array " + Arrays.toString(stubArray2) + " is sorted ascending: "
                + arrayUtils.isSortedAscending(stubArray2));

        System.out.println("array " + Arrays.toString(stubArray1) + " is sorted ascending: "
                + arrayUtils.isSortedAscending(stubArray1));

        System.out.println("array " + Arrays.toString(stubArray1) + " is sorted descending: "
                + arrayUtils.isSortedDescending(stubArray1));

        System.out.println("array " + Arrays.toString(stubArray3) + " is sorted descending: "
                + arrayUtils.isSortedDescending(stubArray3));

        int shift = 7;
        stubArray2 = arrayGenerator.getRandomArray(10);
        System.out.println("array " + Arrays.toString(stubArray2) + " shifted SLOWLY right by " + shift
                + " elements is " + Arrays.toString(arrayUtils.shiftSlowRightBy(stubArray2, shift)));

        stubArray2 = arrayGenerator.getRandomArray(10);
        System.out.println("array " + Arrays.toString(stubArray2) + " shifted FAST right by " + shift
                + " elements is " + Arrays.toString(arrayUtils.shiftFastRightBy(stubArray2, shift)));

        stubArray2 = arrayGenerator.getRandomArray(10);
        System.out.println("array " + Arrays.toString(stubArray2) + " shifted FAST right by " + shift
                + " elements is " + Arrays.toString(arrayUtils.shiftFastRightBy(stubArray2, shift)));

        System.out.println("for array " + Arrays.toString(stubArray5) + " dubbing elements are "
                + arrayUtils.listDubbingElements(stubArray5).toString());

        System.out.println("for array " + Arrays.toString(stubArray1) + " average is "
                + arrayUtils.averageOf(stubArray1) + " and qty of elements above average is " + arrayUtils.qtyAboveAverage(stubArray1));

        System.out.println("for array " + Arrays.toString(stubArray5) + " NOT dubbing elements are "
                + arrayUtils.listNotDubbingElements(stubArray5).toString());

        System.out.println("for array " + Arrays.toString(stubArray5) + " unique elements are "
                + arrayUtils.listUniqueElements(stubArray5).toString());

        stubArray7 = arrayGenerator.getRandomArray(10);
        stubArray6 = arrayGenerator.getRandomArray(10);

        System.out.println("for arrays " + Arrays.toString(stubArray6) + " and "
                + Arrays.toString(stubArray7) + " unique elements of 1st array are "
                + arrayUtils.listUniqueElementsFromFirst(stubArray6, stubArray7));

        System.out.println("for array " + Arrays.toString(stubArray6) + " count of matches for first element is "
                + (arrayUtils.matchCount(stubArray6, stubArray6[0]) - 1));

        stubArray8 = arrayGenerator.getRandomArray(7);
        Arrays.sort(stubArray8);
        stubArray9 = arrayGenerator.getRandomArray(3);
        Arrays.sort(stubArray9);

        System.out.println("for arrays " + Arrays.toString(stubArray8) + " and "
                + Arrays.toString(stubArray9) + " merged sorted array is "
                + Arrays.toString(arrayUtils.mergeSortedTwo(stubArray8, stubArray9)));

        System.out.println("for array " + Arrays.toString(stubArray6) + " swapped positives array is "
                + Arrays.toString(arrayUtils.mirrorSwapPositives(stubArray6)));

        System.out.println("for array " + Arrays.toString(stubArray6) + " BUBBLE sorted array is "
                + Arrays.toString(arrayUtils.sortBubble(stubArray6)));

        stubArray6 = arrayGenerator.getRandomArray(12);
        System.out.println("for array " + Arrays.toString(stubArray6) + " INSERTION sorted array is "
                + Arrays.toString(arrayUtils.sortInsertion(stubArray6)));

        stubArray6 = arrayGenerator.getRandomArray(11);
        System.out.println("for array " + Arrays.toString(stubArray6) + " MERGE BIG MEMORY sorted array is "
                + Arrays.toString(arrayUtils.sortMergeRecursiveBigMemory(stubArray6)));

        stubArray6 = arrayGenerator.getRandomArray(15);
        System.out.println("for array " + Arrays.toString(stubArray6) + " MERGE SMALL MEMORY sorted array is "
                + Arrays.toString(arrayUtils.sortMergeRecursiveMinMemory(stubArray6)));

        stubArray6 = arrayGenerator.getRandomArray(10);
        int value = 5;
        //stubArray6 = new int[]{1,3,5,5,4,2,2,2,7,8,9,3,-9,-18,-27,3,9,8,8};
        System.out.println("for array " + Arrays.toString(stubArray6) + " array swaped around " + value + " is "
                + Arrays.toString(arrayUtils.swapAroundValue(stubArray6, value)));

        stubArray6 = arrayGenerator.getRandomArray(10);
        System.out.println("for array " + Arrays.toString(stubArray6) + "QUICK sorted array is "
                + Arrays.toString(arrayUtils.sortQuick(stubArray6)));

        
        
        long start;
        long end;
        
        int supLength = 100000;
        stubArray6 = arrayGenerator.getRandomArray(supLength);
        stubArray7 = new int[supLength];
        stubArray8 = new int[supLength];
        stubArray9 = new int[supLength];
        System.arraycopy(stubArray6, 0, stubArray7, 0, supLength);
        System.arraycopy(stubArray6, 0, stubArray8, 0, supLength);
        System.arraycopy(stubArray6, 0, stubArray9, 0, supLength);
        //System.out.println( Arrays.toString(stubArray6));
        //System.out.println( Arrays.toString(stubArray7));
        //System.out.println( Arrays.toString(stubArray8));

        
        
        start = System.nanoTime();
        stubArray6 = arrayUtils.sortBubble(stubArray6);
        end = System.nanoTime();
        System.out.println("bubble sort time for " + supLength + " random elements is " + (end - start)/(Math.pow(10d, 9d)));

        start = System.nanoTime();
        stubArray7 = arrayUtils.sortInsertion(stubArray7);
        end = System.nanoTime();
        System.out.println("insertion sort time for " + supLength + " random elements is " + (end - start)/(Math.pow(10d, 9d)));
        
        start = System.nanoTime();
        stubArray8 = arrayUtils.sortMergeRecursiveMinMemory(stubArray8);
        end = System.nanoTime();
        System.out.println("merge sort time for " + supLength + " random elements is " + (end - start)/(Math.pow(10d, 9d)));
        
        start = System.nanoTime();
        stubArray9 = arrayUtils.sortQuick(stubArray9);
        end = System.nanoTime();
        System.out.println("quick sort time for " + supLength + " random elements is " + (end - start)/(Math.pow(10d, 9d)));
        
        
        System.out.println("for array " + Arrays.toString(stubArray5) + "QUICK sorted array is "
                + Arrays.toString(arrayUtils.sortQuick(stubArray5)));
        
        int value1 =20;
        System.out.println("for array " + Arrays.toString(stubArray5) + "binary searched index of "
                +value1+ " is "
                + arrayUtils.searchBinarySorted(stubArray5, value1));
    }

}
