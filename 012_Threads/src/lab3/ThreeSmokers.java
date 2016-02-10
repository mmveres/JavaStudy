package lab3;

/*Задача о курильщиках. Есть три процесса-курильщика и один процесс-посредник. 
 * Курильщик непрерывно скручивает сигареты и курит их. 
 * Чтобы скрутить сигарету, нужны табак, бумага и спички. 
 * У одного процесса- курильщика есть табак, у второго – бумага, а у третьего – спички.
 *  Посредник кладет на стол по два разных случайных компонента. 
 *  Тот процесс-курильщик, у которого есть третий компонент, забирает компоненты со стола, 
 *  скручивает сигарету и курит. Посредник дожидается, пока курильщик закончит,
 *   затем процесс повторяется. 
 *   Создать многопоточное приложение, моделирующее поведение курильщиков и посредника. 
 *   При решении задачи использовать семафоры.*/

import java.util.Arrays;

public class ThreeSmokers {
	public static void main(String[] args) {
		SmokingTable table = new SmokingTable();
		Bartender giver = new Bartender(table);
		Smoker smoker1 = new Smoker(table, Smoker.TOBACCO);
		Smoker smoker2 = new Smoker(table, Smoker.PAPER);
		Smoker smoker3 = new Smoker(table, Smoker.MATCHES);

		new Thread(smoker1).start();
		new Thread(smoker2).start();
		new Thread(smoker3).start();
		new Thread(giver).start();

	}

}

class Smoker implements Runnable {
	public static final int TOBACCO = 0;
	public static final int PAPER = 1;
	public static final int MATCHES = 2;
	private SmokingTable table;
	private int component;

	public Smoker(SmokingTable table, int component) {
		this.table = table;
		this.component = component;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (table) {
				while (!table.isCigartteAvailable() || !cigaretteFits(table.getCigarette())) {
					System.out.println("Smoker with " + getCompName(component) + " waits.");
					try {
						table.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.out.println("Smoker with " + getCompName(component) + " smokes cigarette");
				table.setCigaretteAvailable(false);

				table.notifyAll();
			}

		}
	}

	private boolean cigaretteFits(Cigarette cigarette) {
		System.out.print("Smoker with " + getCompName(component) + " checks " + cigarette+"... ");
		boolean result = false;
		if (cigarette.getComponents()[component] == false) {
			result = true;
		}
		System.out.println(result?"OK!!!!":"no fit.");
		return result;
	}

	private String getCompName(int component) {
		switch (component) {
		case 0:
			return "TOBACCO";
		case 1:
			return "PAPER";
		case 2:
			return "MATCHES";
		default:
			return "UNKNOWN";
		}
	}

}

class Bartender implements Runnable {
	private SmokingTable table;

	public Bartender(SmokingTable table) {
		this.table = table;
	}

	@Override
	public void run() {
		int counter = 0;
		while (counter++ < 30) {
			synchronized (table) {
				while (table.isCigartteAvailable()) {
					System.out.println("-------------- Bartender waits");
					try {
						table.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Cigarette cigarette = Cigarette.getNewUncomplete();
				System.out.println("-------------- Bartender provides new " + cigarette);
				table.putCigarette(cigarette);
				table.setCigaretteAvailable(true);
				table.notifyAll();
			}

		}

	}

}

class SmokingTable {
	private Cigarette cigarette;
	private boolean cigaretteAvailable;

	public Cigarette getCigarette() {
		return cigarette;
	}

	public void putCigarette(Cigarette cigarette) {
		this.cigarette = cigarette;
	}

	public boolean isCigartteAvailable() {
		return cigaretteAvailable;
	}

	public void setCigaretteAvailable(boolean available) {
		this.cigaretteAvailable = available;
	}

}

class Cigarette {
	private boolean[] components;

	public static Cigarette getNewUncomplete() {
		Cigarette cigarette = null;
		switch ((int) (Math.random() * 3)) {
		case 0: {
			cigarette = new Cigarette(false, true, true);
			break;
		}
		case 1: {
			cigarette = new Cigarette(true, false, true);
			break;
		}
		case 2: {
			cigarette = new Cigarette(true, true, false);
			break;
		}
		}
		return cigarette;
	}

	public boolean hasTobacco() {
		return components[0];
	}

	public boolean hasPaper() {
		return components[1];
	}

	public boolean hasMatches() {
		return components[2];
	}

	public boolean[] getComponents() {
		return components;
	}

	public Cigarette(boolean tobacco, boolean paper, boolean matches) {
		components = new boolean[3];
		components[0] = tobacco;
		components[1] = paper;
		components[2] = matches;
	}

	@Override
	public String toString() {
		return "Cigarette [tobacco=" + components[0] + ", paper=" + components[1] + ", matches=" + components[2] + "]";
	}

}
