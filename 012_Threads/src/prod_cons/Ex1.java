package prod_cons;

import java.util.Arrays;

class MyThread extends Thread{
	int i;

	@Override
	public void run() {
		i=(int) Thread.currentThread().getId();
		System.out.println(Thread.currentThread().getId());
	}

	@Override
	public String toString() {
		return "MyThread [i=" + i + "]";
	}
	
	
}

public class Ex1 {
	public static void main(String[] args) {
		MyThread []thArray = new MyThread[10];
		for (int i = 0; i < thArray.length; i++) {
			thArray[i]=new MyThread();
			thArray[i].start();
			
		}
System.out.println(Arrays.toString(thArray));
	}

}
