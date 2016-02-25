package app;

public class FibonacciCycle {

	public long getFibonacci(int n) {
		if (n < 2)
			return 1;
		long minus2 = 0;
		long minus1 = 1;
		long result = 0;
		for (int i = 2; i < n; i++) {
			result = minus2 + minus1;
			minus2 = minus1;
			minus1 = result;
			System.out.println("step: " + i + ", F = " + result);
		}
		return result;
	}

	public static void main(String[] args) {
		FibonacciCycle fc = new FibonacciCycle();
		fc.getFibonacci(100);
	}
}
