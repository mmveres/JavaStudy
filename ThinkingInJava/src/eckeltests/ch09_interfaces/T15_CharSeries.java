/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch09_interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 *
 * @author d2e

 * 
 */


class CharGenerator {
    
    

        private char[] symbol = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        char generate() {
            return symbol[(int) (Math.random() * symbol.length)];

        }
        
        String generate4(){
            StringBuffer sb=new StringBuffer("");
            for (int i = 0; i < 4; i++) {
                sb.append(generate());
                
            }
        return sb.toString();
            
        }

    }

class CGAdapter extends CharGenerator implements Readable{
private int count;

    public CGAdapter(int count) {
        this.count = count;
        
    }
    
    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) return -1;
        String result = generate4()+" ";
        cb.append(result);
        return result.length();
    }
}


 class T15_CharSeries {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(new CGAdapter(5));
    while (sc.hasNext()){
        System.out.println(sc.next());
    
    }
    
    
}
}

