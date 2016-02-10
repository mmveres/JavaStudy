//: interfaces/filters/Waveform.java
package eckeltests.ch09_interfaces.filters;

public class Waveform {
  private static long counter;
  private final long id = counter++;
  public String toString() { return "Waveform " + id; }
} ///:~
