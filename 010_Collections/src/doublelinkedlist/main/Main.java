package doublelinkedlist.main;

import doublelinkedlist.entities.Cargo;
import doublelinkedlist.entities.Pass;
import doublelinkedlist.entities.Wagon;

public class Main {
	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();
		Wagon wagon;
		
		
		
		
		System.out.println("in---------------------------------");
		for (int i = 0; i < 10; i++) {
			dll.addLast(getRandomWagon());
			
		}
		printAllList(dll);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("delete------------------------------");
			dll.first();
			for (int j = 0; j < (int)(Math.random()*dll.getSize()); j++) {
				dll.next();
			}
			dll.deleteCurrent();
			printAllList(dll);
			
		}
		
		
	}

	private static void printAllList(DoubleLinkedList dll) {
		dll.first();
		for (int i = 0; i < dll.getSize(); i++) {
			System.out.println(dll.getCurrent());
			dll.next();
		}
		;

	}

	private static void pushRandomPosition(DoubleLinkedList dll, Wagon wagon) {
		switch ((int) (Math.random() * 3)) {
		case 0: {
		//	System.out.println("adding first: " + wagon);
			dll.addFirst(wagon);
		}
			;
			break;
		case 1: {
		//	System.out.println("adding last: " + wagon);
			dll.addLast(wagon);
		}
			;
			break;
		case 2: {
		//	System.out.println("adding random: " + wagon);
			dll.first();
			for (int i = 0; i < (int) (Math.random() * dll.getSize()); i++) {
				dll.addAfterCurrent(wagon);
			}
		};
		break;
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
