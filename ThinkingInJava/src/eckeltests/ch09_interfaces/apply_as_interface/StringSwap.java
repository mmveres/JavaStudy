/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch09_interfaces.apply_as_interface;

import eckeltests.ch09_interfaces.filters.Waveform;
import static net.mindview.util.Print.print;

/**
 *
 * @author D2E
 */
public class StringSwap implements Processor{

    public String name() {
        return getClass().getSimpleName();
    }

    public String process(Object input) {
        char[] array = ((String)input).toCharArray();
        for (int i = 0; i < array.length-1; i = i + 2) {
            swap(array, i, i + 1);

        }

        return String.valueOf(array);
    }

    private void swap(char[] array, int pos1, int pos2) {
        char tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;

    }
    
    public static void main(String[] args) {
        StringSwap s= new StringSwap();
        Apply.process(s, "ABABABAB");
        Apply.process(s, "BIKAVER IS BIG");
    }
}
