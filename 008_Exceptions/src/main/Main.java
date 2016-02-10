package main;

class NegativeValueException extends Exception {
	String message;

	public NegativeValueException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}

class OutOfRestrictedBoundsException extends Exception {
	String message;

	public OutOfRestrictedBoundsException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}

class QueueFullException extends Exception {
	String message;

	public QueueFullException(String s) {
		this.message = s;
	}

	public String getMessage() {
		return message;
	}

}

class QueueEmptyException extends Exception {
	String message;

	public QueueEmptyException(String s) {
		this.message = s;
	}

	public String getMessage() {
		return message;
	}
}

class MyArray {

	int[] arr;
	int size;

	public MyArray(int n) {
		arr = new int[n];
	}

	public void offer(int element) throws QueueFullException, OutOfRestrictedBoundsException, NegativeValueException {
		if (size == arr.length) {
			throw new QueueFullException("The queue if full");
		}
		if (element < 0)
			throw new NegativeValueException("Negative value entered!");
		if (element < 1 | element > 100)
			throw new OutOfRestrictedBoundsException("Damn, enter something between 1 and 100 incl.!");

		arr[size] = element;
		size++;
	}

	public int poll() throws QueueEmptyException {
		if (size == 0) {
			throw new QueueEmptyException("The queue is empty");
		}
		int res = arr[0];
		System.arraycopy(arr, 1, arr, 0, arr.length - 1);
		size--;
		return res;

	}

}

public class Main {

	static void method() throws QueueFullException,OutOfRestrictedBoundsException, NegativeValueException {
		MyArray ar = new MyArray(5);
		try {
			ar.offer(10);
			ar.offer(11);
			ar.offer(12);
			ar.offer(150);
			ar.offer(14);
			//ar.offer(15);

			System.out.println(ar.poll());
			System.out.println(ar.poll());
			System.out.println(ar.poll());
			System.out.println(ar.poll());
			System.out.println(ar.poll());

		} catch (QueueFullException e) {
			e.printStackTrace();
			throw (e);
		} catch (QueueEmptyException e) {
			e.printStackTrace();

		} catch (NegativeValueException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw (e);
		} catch (OutOfRestrictedBoundsException e) {
			e.printStackTrace();
			throw (e);
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally");
		}

		System.out.println("Bye");

	}

	public static void main(String[] args) {

		try {
			method();
		} catch (QueueFullException e) {
			e.printStackTrace();
		} catch (OutOfRestrictedBoundsException e) {
			
			e.printStackTrace();
		} catch (NegativeValueException e) {
			
			e.printStackTrace();
		}

	}

}
