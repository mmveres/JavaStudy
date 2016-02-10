package eckeltests.ch12_exceptions;

import java.util.Scanner;

class MyContainer {
	private int value;

	public void setValue(int value) throws NegativeValueException {
		if (value < 0)
			throw new NegativeValueException("Negative number entered!");
		this.value = value;
	}
	
	public void decreaseValue() throws NegativeValueException {
		if ((value-1)<0)throw new NegativeValueException();
		value--;
	}
};

class NegativeValueException extends Exception {

	NegativeValueException() {
		// TODO Auto-generated constructor stub
	};

	NegativeValueException(String message) {
		super(message);
	}
}

public class T05_ResumingModel {
	public static void main(String[] args) {
		Scanner scanUserInput = new Scanner(System.in);
		MyContainer mc = new MyContainer();
		boolean nextCycle = false;
		do {
			if (scanUserInput.hasNextInt()) {

				try {
					mc.setValue(scanUserInput.nextInt());
					nextCycle = false;
				} catch (NegativeValueException e) {
					System.out.println(e.getMessage());
					nextCycle = true;
				}
			}
		} while (nextCycle);
		scanUserInput.close();
	}
}
