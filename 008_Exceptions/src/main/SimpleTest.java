package main;

public class SimpleTest {
	public static void f() {
		int i=10;
		int div;
		int dividor = 0;
		try {
			
			div = i / dividor;
			i = Integer.parseInt("абракадабра");
		}

		finally {
			System.out.println("Блок finally 1");
		}
	};

	public static void main(String[] args) {
		try {
			f();

		} catch (NumberFormatException e) {
			System.out.println("Не число");
		} catch (ArithmeticException e) {
			System.out.println("Деление на 0");
		} finally {
			System.out.println("Блок finally 2");
		}
	}
}
