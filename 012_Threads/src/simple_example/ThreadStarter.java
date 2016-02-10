package simple_example;

public class ThreadStarter {
	public static void main(String[] args) {

		NamedRunnable nr = new NamedRunnable(new Value(), true);
		Thread one = new Thread(nr);
		Thread two = new Thread(nr);
		Thread three = new Thread(nr);
		one.setName("Первый");
		two.setName("Второй");
		three.setName("Третий");
		one.start();
		two.start();
		three.start();
		
		
		
	}
}

class Value {
	int v;
}

class NamedRunnable implements Runnable {
	Value value;
	Boolean flag;

	public NamedRunnable(Value value, Boolean flag) {
		this.value = value;
		this.flag=flag;
	}

	public void run() {
		int count=0;
		while (10 > count++) {
			if(flag){
				if(flag)flag=false;
				System.out.println("Запущен " + Thread.currentThread().getName() + " - v: " + value.v++);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Закончен " + Thread.currentThread().getName() + " - v: " + value.v++);
				
				flag=true;
			}
		}
	}
}
