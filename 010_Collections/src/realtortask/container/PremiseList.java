package realtortask.container;

import realtortask.entity.Premise;

class Container {
	private Container next;

	public Container getNext() {
		return next;
	}

	public void setNext(Container next) {
		this.next = next;
	}

	private Premise premise;

	public Premise getPremise() {
		return premise;
	}

	public void setPremise(Premise premise) {
		this.premise = premise;
	}
	
	



}

public class PremiseList {
	private Container head;
	private Container temp;
	private Container current;
	private Container prevoius;
	private int size;

	public void first() {
		current = head;
		prevoius = null;
	}

	public void next() {
		prevoius = current;
		current = current.getNext();
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void push(Premise premise) {
		Container c = new Container();
		c.setNext(head);
		c.setPremise(premise);
		head = c;
		first();
		++size;

	}

	public Premise getPremise() {
		if (isEmpty()) {
			return null;
		} else {
			return current.getPremise();
		}
	}

	public Premise pop() {
		if (isEmpty()) {
			return null;
		} else if (prevoius == null) {
			temp = current;
			current = current.getNext();
			--size;
			return temp.getPremise();

		} else {
			temp = current;
			prevoius.setNext(current.getNext());
			--size;
			return temp.getPremise();
		}
	}

	public int getSize() {
		return size;
	}

	public boolean isLast() {
		return current.getNext() == null;
	}

}
