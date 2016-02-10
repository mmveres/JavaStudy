package lab3;

/*Задача о парикмахере. В тихом городке есть парикмахерская. Салон парикмахерской мал,
 *  ходить там может только парикмахер и один посетитель.
 *  Парикмахер всю жизнь обслуживает посетителей. Когда в салоне никого нет, 
 *  он спит в кресле. Когда посетитель приходит и видит спящего парикмахера, 
 *  он будет его, садится в кресло и спит, пока парикмахер занят стрижкой. 
 *  Если посетитель приходит, а парикмахер занят, то он встает в очередь и засыпает. 
 *  После стрижки парикмахер сам провожает посетителя. Если есть ожидающие посетители, 
 *  то парикмахер будит одного из них и ждет пока тот сядет в кресло парикмахера и начинает стрижку. 
 *  Если никого нет, он снова садится в свое кресло и засыпает до прихода посетителя. 
 *  Создать многопоточное приложение, моделирующее рабочий день парикмахерской.*/


public class HairD {
	public static void main(String[] args) {
		BarberShop shop=new BarberShop();
		HairDresser hd = new HairDresser(shop);
		new Thread(hd).start();
		for (int i = 0; i < 5; i++) {
//			try {
//				Thread.sleep((long)(Math.random()*50));
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			new Thread(new Client(shop)).start();
		}				
	}
}

class Client implements Runnable {
	private static int counter=1;
	private final int id;
	private BarberShop barberShop;

	public Client(BarberShop barberShop) {
		this.barberShop = barberShop;
		id=counter++;
		System.out.println("Client #"+id+" came.");
	}

	@Override
	public void run() {
		synchronized (barberShop) {
			barberShop.increaseQueue();
			while(barberShop.isChairOccupied()){
				
				try {
					System.out.println("Client #"+id+" is waiting in queue.");
					barberShop.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			barberShop.setChairOccupied(true);	
			System.out.println("Client #"+id+" now in chair.");
			barberShop.notifyAll();
			while(!barberShop.isServiceDone()){
				try {
					
					barberShop.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			barberShop.setChairOccupied(false);
			System.out.println("Client #"+id+" is leaving.");
			barberShop.notifyAll();
			
		}

	}
}

class HairDresser implements Runnable {
	private BarberShop barberShop;

	public HairDresser(BarberShop barberShop) {
		this.barberShop = barberShop;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (barberShop) {
				while (barberShop.isQueueEmpty()) {
					
					try {
						System.out.println("Hairderesser is going to sleep.");
						barberShop.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.print("Hairderesser is servicing client...");
				barberShop.decreaseQueue();
				System.out.println("... served.");		
				barberShop.notifyAll();

			}
		}

	}

}

class BarberShop {
	private boolean chairOccupied;
	private int queue=0;
	private boolean serviceDone=false;

	public void increaseQueue(){
		queue++;
		System.out.println("Queue is " + queue);
		
	}
	public void decreaseQueue(){
		serviceDone=true;
		if(queue>0) queue--;
		
	}
	
	public boolean isQueueEmpty(){
		return queue==0;
	}
	
public boolean isServiceDone() {
	return serviceDone;
}

	public boolean isChairOccupied() {
		return chairOccupied;
	}

	public void setChairOccupied(boolean chairOccupied) {
		this.chairOccupied = chairOccupied;
		if(chairOccupied==false) serviceDone=false;
		
	}

}
