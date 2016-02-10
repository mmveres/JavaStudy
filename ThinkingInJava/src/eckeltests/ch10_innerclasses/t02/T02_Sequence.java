/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckeltests.ch10_innerclasses.t02;
//: innerclasses/Sequence.java
// Holds a sequence of Objects.

interface Selector {

    boolean isLast();

    Object current();

    void next();
    
    void printOuterHashcode();
}

class StringObject {

    private String str = "so#";
    private static int idGen = 1;
    private int id;

    public StringObject() {
        id = idGen++;
    }

    @Override
    public String toString() {
        return "StringObject{" + str + id + '}';
    }

}

class T02_Sequence {

    private Object[] items;
    private int next = 0;

    public T02_Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {

        private int i = 0;

        public boolean isLast() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) {
                i++;
            }
        }

        public void printOuterHashcode() {
            System.out.println(T02_Sequence.this.hashCode());
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        T02_Sequence sequence = new T02_Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(new StringObject());
        }
        Selector selector = sequence.selector();
        selector.printOuterHashcode();
        while (!selector.isLast()) {
            System.out.println(selector.current());
            selector.next();
            
        }
    }
}
/* Output:
0 1 2 3 4 5 6 7 8 9
 *///:~
