package eckeltests.ch12_exceptions;



class MyTestException extends Exception{
	public MyTestException() {
		// TODO Auto-generated constructor stub
	}
	MyTestException (String msg){
		super(msg);
	}
}

public class T01_test {
	public static void main(String[] args) {
		try {
			System.out.println("Throwing Exception");
			throw new MyTestException("Generated in TRY");
		} catch (MyTestException e) {
			System.out.println("Caught:" + e.getMessage());
	}finally {
		System.out.println("This is final block!");
	}
}}
