package eckeltests.ch12_exceptions.examples;

//: exceptions/Cleanup.java
// Guaranteeing proper cleanup of a resource.

public class Cleanup {
  public static void main(String[] args) {
    try {
      InputFile in = new InputFile("/home/d2e/workspace/ThinkingInJava/src/eckeltests/ch12_exceptions/examples/Cleanup.java");
      try {
        String s;
        int i = 1;
        while((s = in.getLine()) != null)
          System.out.println(s);; // Perform line-by-line processing here...
      } catch(Exception e) {
        System.out.println("Caught Exception in main");
        e.printStackTrace(System.out);
      } finally {
        in.dispose();
      }
    } catch(Exception e) {
      System.out.println("InputFile construction failed");
    }
  }
} /* Output:
dispose() successful
*///:~
