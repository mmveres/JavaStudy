package railwaystack.main;

import railwaystack.entities.Cargo;
import railwaystack.entities.Pass;
import railwaystack.entities.Wagon;

public class Main {
	public static void main(String[] args) {
		WagonTStack ws = new WagonTStack();
		Wagon wagon;
		System.out.println("in---------------------------------");
		for (int i = 0; i < 19; i++) {
			wagon=getRandomWagon();
			System.out.println(wagon);
			ws.push(wagon);

		}
		System.out.println("out--------------------------------");
		while(!ws.isEmpty()){
			System.out.println(ws.pop());
		}
	}

	private static Wagon getRandomWagon() {

		switch ((int) (Math.random() * 2)) {
		case 0:
			return new Cargo();
		case 1:
			return new Pass();
		default:
			return null;

		}

	}

}
