/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typicalarraytasks;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author D2E
 */
public class ArrayUtils {

    public int searchBinarySorted(int[] array, int value) {
        int index = -1;
        int start = 0;
        int end = array.length;
        int mid;
        do {
            mid = start + (end - start) / 2;
            System.out.println(mid);
            if (value < array[mid]) {
                end = mid;
            } else if (value > array[mid]) {
                start = mid+1;
            } else {
                return index = mid;
            }

        } while (start < end);
        return index;
    }

    /**
     * sum of elements Найти сумму элементов массива
     */
    public int sumOfElements(int array[]) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];

        }
        return sum;
    }

    /**
     * index of first biggest value Найти максимальный элемент, значение и
     * индекс
     */
    public int indexOfFirstMax(int array[]) {
        int index = 0;
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                index = i;
                maxValue = array[i];
            }

        }
        return index;
    }

    /**
     * index of first min value Найти минимальный элемент, значение и индекс
     */
    public int indexOfFirstMin(int array[]) {
        int index = 0;
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                index = i;
                minValue = array[i];
            }

        }
        return index;
    }

    /**
     * average Найти среднее значение элементов массива
     */
    public double averageOf(int array[]) {
        double average = (double) sumOfElements(array) / array.length;
        return average;
    }

    /**
     * count of matches to value Посчитать количество элементов равных заданному
     */
    public int matchCount(int array[], int number) {
        int matchCount = 0;
        for (int element : array) {
            if (element == number) {
                matchCount++;
            }
        }

        return matchCount;
    }

    /**
     * count of matches bigger than number Посчитать количество элементов больше
     * нуля
     */
    public int biggerThanCount(int array[], int number) {
        int biggerThanCount = 0;
        for (int element : array) {
            if (element > number) {
                biggerThanCount++;
            }
        }

        return biggerThanCount;
    }

    /**
     * multiple elements by number Помножить элементы массива на число
     */
    public int[] multipleByValue(int array[], int number) {

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * number;
        }
        return array;
    }

    /**
     * adds index value to element value Прибавить к элементам массива их индекс
     */
    public int[] addIndexValue(int array[]) {

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + i;
        }
        return array;
    }

    /**
     * turns elements with even values to 0 Обнулить четные по значению элементы
     * массива
     */
    public int[] evenValuesToZero(int array[]) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = 0;
            }
        }
        return array;
    }

    /**
     * turns elements with odd index to 0 Обнулить элементы с нечетным индексом.
     */
    public int[] oddIndexToZero(int array[]) {

        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = 0;
            }
        }
        return array;
    }

    /**
     * returns index of first positive element Найти первый положительный
     * элемент
     */
    public int firstPositiveIndex(int array[]) {
        int firstPositiveIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                firstPositiveIndex = i;
                break;
            }
        }
        return firstPositiveIndex;
    }

    /**
     * returns element value in String, NONE if index is negative
     *
     */
    public String indexToValue(int array[], int index) {
        String Value = "NONE!!!!!";
        if (index > -1) {
            Value = Integer.toString(array[index]);

        }

        return Value;
    }

    /**
     * returns index of last negative element Найти последний отрицательный
     * элемент
     */
    public int lastNegativeIndex(int array[]) {
        int lastNegativeIndex = -1;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < 0) {
                lastNegativeIndex = i;
                break;
            }
        }
        return lastNegativeIndex;
    }

    /**
     * returns ArrayList of indexes for array elements matching number Найти
     * индексы вхождения элемента в массив
     */
    public ArrayList<Integer> matchIndexes(int array[], int number) {
        ArrayList<Integer> indexes = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /**
     * returns true if array sorted ascending Проверить массив на
     * упорядоченность элементов по возрастанию
     */
    public boolean isSortedAscending(int array[]) {
        boolean isSortedAscending = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                isSortedAscending = false;
                break;
            }
        }
        return isSortedAscending;
    }

    /**
     * returns true if array sorted descending Проверить массив на
     * упорядоченность элементов по убыванию
     */
    public boolean isSortedDescending(int array[]) {
        boolean isSortedDescending = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i]) {
                isSortedDescending = false;
                break;
            }
        }
        return isSortedDescending;
    }

    /**
     * shifts elements right by provided number - slow Циклический сдвиг
     * элементов массива на k- позиций вправо
     */
    public int[] shiftSlowRightBy(int array[], int number) {
        int tmp;
        for (int i = 1; i < number + 1; i++) {
            tmp = array[array.length - 1];
            for (int j = array.length - 2; j >= 0; j--) {
                array[j + 1] = array[j];

            }
            array[0] = tmp;
        }

        return array;
    }

    /**
     * shifts elements right by provided number - fast memory consumption
     * _optimized_ - temp array in any case is less than/or half of modified
     * array Циклический сдвиг элементов массива на k- позиций вправо
     */
    public int[] shiftFastRightBy(int array[], int number) {

        if (number <= array.length / 2) {
            int[] tmp = new int[number];
            //copy shifted N elements from end to temp array
            System.arraycopy(array, array.length - number, tmp, 0, number);
            //shift the rest elements right in initial array
            System.arraycopy(array, 0, array, number, array.length - number);
            //copy temp array to beginning of initial array
            System.arraycopy(tmp, 0, array, 0, number);

        } else {
            int[] tmp = new int[array.length - number];
            //copy what will be in end of future array to temp array
            System.arraycopy(array, 0, tmp, 0, array.length - number);
            //copy the unprocessed part to fill from beginning initial array 
            System.arraycopy(array, array.length - number, array, 0, number);
            //copy temp array to end initial array
            System.arraycopy(tmp, 0, array, number, array.length - number);

        }
        return array;
    }

    /**
     * Вывести элементы, значения которых равны значениям других элементов.
     * generates List of element values which are repeated twice or more _speed_
     * optimized
     */
    public ArrayList<Integer> listDubbingElements(int array[]) {
        ArrayList<Integer> dubbingList = new ArrayList();
        int tempArray[] = new int[array.length];
        //create copy to keep original array safe
        System.arraycopy(array, 0, tempArray, 0, array.length);
        //sort copy
        Arrays.sort(tempArray);

        for (int i = 0; i < tempArray.length - 1; i++) {
            //if elements match
            if (tempArray[i] == tempArray[i + 1]) {
                //add value to collection
                dubbingList.add(tempArray[i]);
                //shift counter to last index element with current value, if many
                i = lastIndexForValue(tempArray, i, tempArray[i]);

            }

        }

        return dubbingList;
    }

    /**
     *
     * Returns last index in array for provided value, starting from position
     *
     */
    public int lastIndexForValue(int array[], int startSearchIndex, int value) {
        int lastIndexForValue = -1;
        for (int i = array.length - 1; i > startSearchIndex; i--) {
            if (array[i] == value) {
                lastIndexForValue = i;
                break;
            }

        }

        return lastIndexForValue;
    }

    /**
     * Найти количество элементов больших среднего значения Returns qty of
     * elements with value above the average for array
     */
    public int qtyAboveAverage(int array[]) {
        int qtyAboveAverage = 0;
        double average = averageOf(array);
        for (int i = 0; i < array.length; i++) {
            if (average < (double) array[i]) {
                qtyAboveAverage++;
            }

        }

        return qtyAboveAverage;
    }

    /**
     * Вывести элементы, значения которых не равны значениям других элементов.
     * generates List of element values which are not repeated _speed_ optimized
     */
    public ArrayList<Integer> listNotDubbingElements(int array[]) {
        ArrayList<Integer> notDubbingList = new ArrayList();
        int tempArray[] = new int[array.length];
        //create copy to keep original array safe
        System.arraycopy(array, 0, tempArray, 0, array.length);
        //sort copy
        Arrays.sort(tempArray);

        for (int i = 0; i < tempArray.length - 1; i++) {
            //if elements match
            if (tempArray[i] == tempArray[i + 1]) {
                //shift counter to last index element with current value, if many
                i = lastIndexForValue(tempArray, i, tempArray[i]);

            } else {
                //add value to collection
                notDubbingList.add(tempArray[i]);
            }

        }

        return notDubbingList;
    }

    /**
     * Вывести элементы одного массива, которые не равны элементам второго
     * массива. generates List of element values from Array1 which are absent in
     * Array2 _speed_ optimized
     */
    public ArrayList<Integer> listUniqueElementsFromFirst(int array1[], int array2[]) {
        ArrayList<Integer> uniqueElementsFromFirst = new ArrayList();
        int ue1[] = arrayFromList(listUniqueElements(array1));
        int ue2[] = arrayFromList(listUniqueElements(array2));
        //System.out.println(Arrays.toString(ue1));
        //System.out.println(Arrays.toString(ue2));
        for (int i = 0; i < ue1.length; i++) {
            if (matchIndexes(ue2, ue1[i]).isEmpty()) {
                uniqueElementsFromFirst.add(ue1[i]);
            };

        }

        return uniqueElementsFromFirst;

    }

    /**
     *
     * generates List of unique element values from Array _speed_ optimized
     */
    public ArrayList<Integer> listUniqueElements(int array[]) {
        ArrayList<Integer> uniqueElements = new ArrayList();
        int tempArray[] = new int[array.length];
        //create copy to keep original array safe
        System.arraycopy(array, 0, tempArray, 0, array.length);
        //sort copy
        Arrays.sort(tempArray);

        for (int i = 0; i < tempArray.length - 1; i++) {
            //if two neighbour elements match
            if (tempArray[i] == tempArray[i + 1]) {
                //shift counter to last index of element with current value, if many
                i = lastIndexForValue(tempArray, i, tempArray[i]);
                //add value to collection
                uniqueElements.add(tempArray[i]);
            } else {
                //add value to collection
                uniqueElements.add(tempArray[i]);
            }

        }

        return uniqueElements;
    }

    public int[] arrayFromList(ArrayList<Integer> IntegerList) {

        int s = IntegerList.size();
        int[] intArray = new int[s];
        for (int i = 0; i < s; i++) {
            intArray[i] = IntegerList.get(i).intValue();
        }
        return intArray;
    }

    /**
     * Посчитать сколько элементов в массиве с таким-же значением, как и первый
     * generates List of unique element values from Array _speed_ optimized
     */
    public int countEqualToFirst(int array[]) {
        int countEqualToFirst = matchCount(array, array[0]) - 1;

        return countEqualToFirst;
    }

    /**
     * Merges two sorted arrays into one sorted array Принцип - меньший элемент
     * из двух сравниваемых массивов записываем в выходной массив , для того
     * массива, из которого записывали увеличиваем, счетчик - это все, пока не
     * закончится меньший из массивов затем дописываем остаток
     */
    public int[] mergeSortedTwo(int array1[], int array2[]) {

        int merged[] = new int[array1.length + array2.length];
        int counterM = 0;
        int counter1 = 0;
        int counter2 = 0;

        while (counter1 < array1.length && counter2 < array2.length) {
            if (array1[counter1] < array2[counter2]) {
                merged[counterM] = array1[counter1];
                counter1++;
            } else {
                merged[counterM] = array2[counter2];
                counter2++;
            }
            counterM++;
        }
        while (counter1 < array1.length) {
            merged[counterM] = array1[counter1];
            counter1++;
            counterM++;
        }

        while (counter2 < array2.length) {
            merged[counterM] = array2[counter2];
            counter2++;
            counterM++;
        }
        return merged;

    }

    /**
     * swaps positives in array Поменять первый положительный элемент с
     * последним положительным, второй с предпоследним и т.д.
     */
    public int[] mirrorSwapPositives(int array[]) {
        int fwdCounter = firstPositiveIndexFrom(array, 0);
        int bckCounter = lastPositiveIndexFrom(array, array.length - 1);

        while (fwdCounter < bckCounter) {
            //System.out.println("" + fwdCounter + " " + bckCounter);
            swap(array, fwdCounter, bckCounter);
            fwdCounter = firstPositiveIndexFrom(array, fwdCounter + 1);
            bckCounter = lastPositiveIndexFrom(array, bckCounter - 1);

        }

        return array;
    }

    public int firstPositiveIndexFrom(int array[], int position) {
        int firstPositiveIndex = -1;
        for (int i = position; i < array.length; i++) {
            if (array[i] > 0) {
                firstPositiveIndex = i;
                break;
            }
        }
        return firstPositiveIndex;
    }

    public int lastPositiveIndexFrom(int array[], int position) {
        int lastPositiveIndex = -1;
        for (int i = position; i > 0; i--) {
            if (array[i] > 0) {
                lastPositiveIndex = i;
                break;
            }
        }
        return lastPositiveIndex;

    }

    private void swap(int array[], int first, int second) {
        int tmp;

        tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    /**
     * bubble sorting сдвигаем вправо макс. элемент во все более уменьшающихся
     * массивах
     */
    public int[] sortBubble(int[] array) {
        for (int currentCut = array.length - 1; currentCut > 0; currentCut--) {
            for (int index = 0; index < currentCut; index++) {
                swapConditional(array, index);

            }

        }
        return array;

    }

    private void swapConditional(int[] array, int index) {
        if (array[index] > array[index + 1]) {
            swap(array, index, index + 1);
        }
    }

    /**
     * Insertion sorting во все увеличивающейся цепочке гоним элемент пока не
     * достигнем начала либо не встретим меньший
     *
     */
    public int[] sortInsertion(int[] array) {
        for (int currentCut = 1; currentCut < array.length; currentCut++) {
            for (int index = currentCut; index > 0 && array[index - 1] > array[index]; index--) {
                swap(array, index - 1, index);

            }

        }
        return array;

    }

    /**
     * Merge sorting 1 если массив из одного эл-та - он отсортирован 2 из двух -
     * выполняем swap если надо 3 из трех и более - дробим до N двух (+1) и
     * выполняем 2 4 двухэлементные отсортированные сливаеем в 4-х элементные
     * отсортированные и т.д. пока не наберем отсортированный массив
     *
     */
    public int[] sortMergeRecursiveBigMemory(int[] array) {
        int len = array.length;

        if (len < 2) {
            //System.out.println("1 " + Arrays.toString(array));
            return array;
        }

        if (len == 2) {
            swapConditional(array, len - 2);
            //System.out.println("2 "+ Arrays.toString(array));
            return array;
        }
        int[] first = Arrays.copyOfRange(array, 0, len / 2);
        int[] second = Arrays.copyOfRange(array, len / 2, array.length);
        //System.out.println(Arrays.toString(first));
        //System.out.println(Arrays.toString(second));

        return mergeSortedTwo(sortMergeRecursiveBigMemory(first), sortMergeRecursiveBigMemory(second));

    }

    public int[] sortMergeRecursiveMinMemory(int[] array) {
        int[] tmp = new int[array.length];
        mergeSorter(array, 0, array.length, tmp);

        return array;
    }

    private void mergeSorter(int[] inputArray, int startElem, int endElem, int[] tmpArray) {
        if ((endElem - startElem) <= 1) {
            return;
        }
        int midElem = startElem + (endElem - startElem) / 2;
        mergeSorter(inputArray, startElem, midElem, tmpArray);
        mergeSorter(inputArray, midElem, endElem, tmpArray);
        merge(inputArray, startElem, midElem, endElem, tmpArray);
    }

    private void merge(int[] inputArray, int startElem, int midElem, int endElem, int[] tmpArray) {
        int firstIndex = startElem;
        int secIndex = midElem;
        int resIndex = 0;

        while (firstIndex < midElem && secIndex < endElem) {
            if (inputArray[firstIndex] < inputArray[secIndex]) {
                tmpArray[resIndex++] = inputArray[firstIndex++];
            } else {
                tmpArray[resIndex++] = inputArray[secIndex++];
            }
        }
        while (firstIndex < midElem) {
            tmpArray[resIndex++] = inputArray[firstIndex++];
        }
        while (secIndex < endElem) {
            tmpArray[resIndex++] = inputArray[secIndex++];
        }
        System.arraycopy(tmpArray, 0, inputArray, startElem, resIndex);
    }

    public int[] swapAroundValue(int[] array, int value) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int tmp;

        while (startIndex < endIndex) {
            while (array[startIndex] <= value && startIndex < endIndex) {
                startIndex++;
            }
            while (array[endIndex] >= value && startIndex < endIndex) {
                endIndex--;
            }
            if (startIndex < endIndex) {
                tmp = array[startIndex];
                array[startIndex] = array[endIndex];
                array[endIndex] = tmp;
                startIndex++;
                endIndex--;

            }

        }

        return array;
    }

    public int[] sortQuick(int[] array) {
        sortQ(array, 0, array.length - 1);
        return array;

    }

    private void sortQ(int[] array, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        int cut = part(array, startIndex, endIndex);
        sortQ(array, startIndex, cut - 1);
        sortQ(array, cut + 1, endIndex);
    }

    private int part(int[] array, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int currVal = array[startIndex];
        //int step=1;
        while (true) {
            //System.out.println("... next cycle!");
            while (array[left] <= currVal && left < endIndex) {
                left++;
            }
            while (currVal <= array[right] && right > startIndex) {
                right--;
            }
            if (left >= right) {
                break;
            }
            //System.out.println("step "+ step++ + Arrays.toString(array));
            //System.out.println("swapping around value "+currVal+" elements with values "+array[left]+ " and " + array[right]);
            swap(array, right, left);
            left++;
            right--;
        }
        //System.out.println("last in cycle " + Arrays.toString(array));
        //System.out.println("swapping values " +array[startIndex]+" and " + array[right]);
        swap(array, startIndex, right);
        //System.out.println("end "+Arrays.toString(array));
        return right;
    }
}
