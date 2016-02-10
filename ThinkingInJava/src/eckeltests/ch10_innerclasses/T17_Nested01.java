/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch10_innerclasses;

/**
 *
 * @author d2e
 */
class T17_Nested01 {

    class Inner {

        public Inner() {
            System.out.println("Inner object init");
        }
        

        class MoreInner {

            public MoreInner() {System.out.println("MoreInner object init!");
            }
        }

    }

    static class InnerS {

        public InnerS() {System.out.println("Static Inner init!");
        }
        

        static class MoreInnerS {

            public MoreInnerS() {System.out.println("Static MoreInner init!");
            }
        }

    }

    public static void main(String[] args) {
        T17_Nested01 t17 = new T17_Nested01();
        T17_Nested01.Inner.MoreInner mi = t17.new Inner().new MoreInner();
        
        
    }
}
