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
public class ArrayTasks {

    public static int calcSumOfArrayElements(int array[]) {
        int sum = 0;
        for (int elem : array) {
            sum += elem;
        }
        return sum;
    }

    public static double getAverageArrayValue(int array[]) {
        double sum = calcSumOfArrayElements(array);
        return sum / array.length;
    }

    public static int findFirstMin(int array[]) {
        //int minValue = array[0];
        int minIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex] /*minValue*/) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findLastMax(int array[]) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = array.length - 1;
        for (int i = maxIndex; i >= 0; i--) {
            if (array[i] > maxValue) {
                maxIndex = i;
                maxValue = array[i];
            }
        }
        return maxIndex;
    }

    public static int findFirstValue(int array[], int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void zeroEvenElements(int array[]) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = 0;
            }
        }
    }

    public static int calcMatchCount(int array[], int value) {
        int count = 0;
        for (int elem : array) {
            if (elem == value) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkArraySortedIncreasing(int array[]) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] > array[i]) {
                count++;
            } //else{
            //  return false;
            //}
        }
        return count == array.length - 1;
         //            bad sample with many errors
//        for( int i = 0; i< array.length ; i++){
//            if( array[i+1] > array[i]){
//                System.out.println("increasing");
//            }else if(array[i+1]<array[i]){
//                System.out.println("decreasing");
//            }else{
//                System.out.println("Not sorted");
//            }
//            
//        }
        //return true;
        //}

    }

    public static boolean checkArraySortedDecreasing(int array[]) {
        boolean sorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                sorted = false;
                break;
                // return false; - but not obvisiolly
            }
        }
        return sorted;
    }

    public static int[] inverse(int[] array) {
        for (int startIndex = 0, endIndex = array.length - 1;
                startIndex < array.length / 2; startIndex++, endIndex--) {
            swap(array, startIndex, endIndex);
        }
        return array;
    }

    public static void swap(int[] array, int startIndex, int endIndex) {
        int temp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = temp;
    }

    public static int[] shiftRightCyclic(int array[], int positions) {
        for (int shift = 0; shift < positions; shift++) {
            int temp = array[array.length - 1];
            for (int i = array.length - 2; i >= 0; i--) {
                array[i + 1] = array[i];
            }
            array[0] = temp;
        }
        return array;
    }

    public static int[] shiftRightCyclicFast(int array[], int positions) {
        //array[i+positions] = array[i]
        int size = array.length;
        int temp[] = new int[size];

        for (int i = 0; i < size; i++) {
            temp[(i + positions) % size] = array[i];
        }
        System.arraycopy(temp, 0, array, 0, size);
        return array;
    }

    public static int[] shiftRightCyclicVeryFast(int array[], int positions) {
        //array[i+positions] = array[i]
        int size = array.length;
        int temp[] = new int[size];
        System.arraycopy(array, 0, temp, positions, size - positions);
        System.arraycopy(array, size - positions, temp, 0, positions);

        // back to array
        System.arraycopy(temp, 0, array, 0, size);
        return array;
    }

    public static void printRepeats(int array[]) {
//        for(int i= 0 ; i< array.length; i++){
//            for( int j = 0; j< array.length ; j++){
//                if( array[i]==array[j] && i<j){
//                    System.out.println("array["+i+"]==array["+j+"]=="+array[i]);
//                }
//            }
//        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println("array[" + i + "]==array[" + j + "]==" + array[i]);
                }
            }
        }

    }

    public static void printRepeatsExt(int array[]) {
        outer:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    continue outer;
                }
            }

            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println("array[" + i + "]==array[" + j + "]==" + array[i]);
                    break;
                }
            }
        }
    }

    public static void printRepeatsAdditionalMemory(int array[]) {
        boolean repeatFlags[] = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if (repeatFlags[i]) {
                continue;
            }

            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    if (repeatFlags[i] == false) {
                        repeatFlags[i] = true;
                        System.out.println("array[" + i + "]==array[" + j + "]==" + array[i]);
                    }
                    repeatFlags[j] = true;

                }
            }
        }
    }

    public static void printNonRepeats(int array[]) {
        for (int i = 0; i < array.length; i++) {
            boolean unique = true;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    unique = false;
                    break;
                }

            }
            if (unique) {
                System.out.println("array[" + i + "]=" + array[i] + " - is unique");
            }/*else{
             System.out.println("array["+i+"]="+array[i]+" - is not unique");
             }*/

        }
    }

    public static int binarySearch(int array[], int value) {
        int lower = 0;
        int upper = array.length;
        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (value > array[mid]) {
                lower = mid + 1;
            } else { // value < array[mid]
                upper = mid;
            }
        }
        return -1;
    }

    public static void printDifference(int firstArray[], int secondArray[]) {
        Arrays.sort(secondArray);
        for (int i = 0; i < firstArray.length; i++) {
            int index = binarySearch(secondArray, firstArray[i]);
            if (index == -1) {
                System.out.println("firstArray[" + i + "]=" + firstArray[i] + " - is unique");
            }
        }
    }

    public static int[] mergeTwoSortedArrays(int firstArray[], int secondArray[]) {
        int result[] = new int[firstArray.length + secondArray.length];

        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = 0;

        while (firstIndex < firstArray.length && secondIndex < secondArray.length) {
            if (firstArray[firstIndex] < secondArray[secondIndex]) {
                result[resultIndex++] = firstArray[firstIndex++];
            } else {
                result[resultIndex++] = secondArray[secondIndex++];
            }
        }
        while (firstIndex < firstArray.length) {
            result[resultIndex++] = firstArray[firstIndex++];
        }
        while (secondIndex < secondArray.length) {
            result[resultIndex++] = secondArray[secondIndex++];
        }

        return result;
    }

    public static void mergeSort(int array[]) {
        //checks
        //array not null
        //array.length > 1 .....
        int temp[] = new int[array.length];
        mergeSorter(array, 0, array.length, temp);

    }

    /**
     *
     * @param array
     * @param from inclusive
     * @param to exclusive
     */
    private static void mergeSorter(int array[], int from, int to, int[] temp) {
        if (to - from <= 1) {
            return;
        }
        int mid = from + (to - from) / 2;
        mergeSorter(array, from, mid, temp);
        mergeSorter(array, mid, to, temp);
        merger(array, from, mid, to, temp);

    }

    private static void merger(int[] array, int from, int mid, int to, int[] temp) {
        int firstIndex = from;
        int secondIndex = mid;
        int resultIndex = 0;

        while (firstIndex < mid && secondIndex < to) {
            if (array[firstIndex] < array[secondIndex]) {
                temp[resultIndex++] = array[firstIndex++];
            } else {
                temp[resultIndex++] = array[secondIndex++];
            }
        }
        while (firstIndex < mid) {
            temp[resultIndex++] = array[firstIndex++];
        }
        while (secondIndex < to) {
            temp[resultIndex++] = array[secondIndex++];
        }
        System.arraycopy(temp, 0, array, from, resultIndex);
    }

    public static void changePositive(int array[]) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            while (array[start] < 0 && start < end) {
                start++;
            }
            while (array[end] > 0 && start < end) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }

    }

}
