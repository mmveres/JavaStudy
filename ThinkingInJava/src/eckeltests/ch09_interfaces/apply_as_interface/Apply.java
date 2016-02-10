//: interfaces/interfaceprocessor/Apply.java
package eckeltests.ch09_interfaces.apply_as_interface;
import static net.mindview.util.Print.*;

public class Apply {
  public static void process(Processor p, Object s) {
    print("Using Processor " + p.name());
    print(p.process(s));
  }
} ///:~
