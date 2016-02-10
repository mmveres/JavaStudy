package railwaystack.main;

import railwaystack.entities.Wagon;

public class WagonStack {
	private Wagon head;
	private Wagon temp;

	public void push(Wagon wagon) {
		wagon.setNextWagon(head);
		head = wagon;
	}

	public Wagon pop() {
		if (!isEmpty()) {
			temp = head;
			head = head.getNextWagon();
			return temp;
		} else {
			return null;
		}

	}

	public boolean isEmpty() {
		return head == null;
	}

}
