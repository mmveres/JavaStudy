/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch05_init_and_close;

/**
 *
 * @author D2E
 */



    class Values {

        private String val1 = "hell";
        private String val2;

        Values(String value) {
            this.val2 = value;
        }

        @Override
        public String toString() {
            return "Values{" + "val1=" + val1 + ", val2=" + val2 + '}';
        }

    }

public class T02_InitInTwoPlace {


    public static void main(String[] args) {
         Values value = new Values("voivod");
         System.out.println(value);

    }

}
