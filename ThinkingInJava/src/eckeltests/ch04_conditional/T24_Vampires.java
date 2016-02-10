/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch04_conditional;

import java.util.Arrays;
import static net.mindview.util.Print.print;

/**
 *
 * @author D2E
 */
public class T24_Vampires {

    public static void main(String[] args) {
        vamprires();
    }

    public static void vamprires() {
        int[] digit = new int[4];
        int mult11 = 0;
        int mult12 = 0;
        int mult21 = 0;
        int mult22 = 0;

        for (int i = 1000; i < 9999; i++) {
            digit[0] = i / 1000;
            digit[1] = (i - digit[0] * 1000) / 100;
            digit[2] = (i - digit[0] * 1000 - digit[1] * 100) / 10;
            digit[3] = i - digit[0] * 1000 - digit[1] * 100 - digit[2] * 10;
            
            
//            print(Arrays.toString(digit));
            for (int j = 0; j < digit.length; j++) {
                if (digit[j] == 0) {
                    continue;
                }
                mult11 = digit[j] * 10;

                for (int k = 0; k < digit.length; k++) {
                    if (j == k) {
                        continue;
                    }
                    if (digit[k] == 0) {
                        continue;
                    }
                    mult12 = digit[k];
                    for (int l = 0; l < digit.length; l++) {
                        if (l == j || l == k) {
                            continue;
                        }
                        if (digit[l] == 0) {
                            continue;
                        }
                        mult21 = digit[l] * 10;
                        for (int m = 0; m < digit.length; m++) {
                            if (m == j || m == k || m == l) {
                                continue;
                            }
                            if (digit[m] == 0) {
                                continue;
                            }
                            mult22 = digit[m];
                            //print((mult11 +mult12)+ " "+ (mult21+mult22));
                            if (i == (mult11 + mult12) * (mult21 + mult22)) {
                                print(Arrays.toString(digit) + " " + (mult11 + mult12) + " " + (mult21 + mult22));
                            }
                        }

                    }

                }

            }

        }
    }
}
