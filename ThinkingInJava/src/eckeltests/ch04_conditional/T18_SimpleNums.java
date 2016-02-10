/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch04_conditional;

/**
 *
 * @author D2E
 */
public class T18_SimpleNums {

    static class SimpleGenerator {

        public static void generate(int maxNum) {
            
            for (int i = 1; i <= maxNum; i = i + 2) {
                int count=0;
//                System.out.println("ext i" + i);
                for (int j = i; j > 0; j=j-2) {
//                    System.out.println(j + " "+ i%j);
                    if(i%j==0){
                    count++;}
                    if(count>2){break;}
                }
                if (count==2){System.out.println("simple:" +i);}
            }
        }

        public static void main(String[] args) {
            SimpleGenerator.generate(31);
        }
    }
}
