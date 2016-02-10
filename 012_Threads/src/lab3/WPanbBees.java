package lab3;

/*Задача о Винни-Пухе или правильные пчелы. В одном лесу живут n пчел и один медведь,
 *  которые используют один горшок меда, вместимостью Н глотков.
 *   Сначала горшок пустой. Пока горшок не наполнится, медведь спит.
 *    Как только горшок заполняется, медведь просыпается и съедает весь мед, после чего снова засыпает.
 *     Каждая пчела многократно собирает по одному глотку меда и кладет его в горшок. 
 *     Пчела, которая приносит последнюю порцию меда, будит медведя. 
 *     Создать многопоточное приложение, моделирующее поведение пчел и медведя.*/

public class WPanbBees {
	public static void main(String[] args) {
		Pot pot = new Pot(25);
		Bear bear=new Bear(pot);
		Thread bearT= new Thread(bear);
		bearT.start();
		for (int i = 0; i < 4; i++) {
			new Thread(new Bee(pot)).start();
		}
//		try {
//			bearT.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}


class Bear implements Runnable{
	private Pot pot;
	
	public Bear(Pot pot) {
		this.pot = pot;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			synchronized (pot) {
				while(!pot.isFull()){
					try {
						pot.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Bear awakens");
				pot.eatAllHoney();
				System.out.println("Bear ate all honey");
				pot.notifyAll();
			}
		}
		
	}}


class Bee implements Runnable{
	private static int counter=1;
	private final int id;
	private Pot pot;
	public Bee(Pot pot) {
		id=counter++;
		this.pot = pot;
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			synchronized (pot) {
				while(pot.isFull()){
					try {
						pot.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				pot.addHoney();
				System.out.println("Bee #"+id+" adds portion!");
				if(pot.isFull()){
					System.out.println("Bee #"+id+" wakes bear!");
					pot.notifyAll();
				}
				
			}
		}
		
	}}

class Pot{
	private int capacity;
	private int value;

	public Pot(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean isFull(){
		return value==capacity;
	}
	
	public void addHoney(){
		if(value<capacity){
			System.out.println("Pot now is " +value+" of "+ capacity);
			value++;
			
		}
	}
	
	public void eatAllHoney(){
		value=0;
	}
}