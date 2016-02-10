package buspark;

class Container {
	private Container next;

	public Container getNext() {
		return next;
	}

	public void setNext(Container next) {
		this.next = next;
	}

	private Bus bus;

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

}

public class BusList {
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

	public void push(Bus bus) {
		Container c = new Container();
		c.setNext(head);
		c.setBus(bus);
		head = c;
		first();
		++size;

	}

	public Bus getBus() {
		if (isEmpty()) {
			return null;
		} else {
			return current.getBus();
		}
	}

	public Bus pop() {
		if (isEmpty()) {
			return null;
		} else if (prevoius == null) {
			temp = current;
			current = current.getNext();
			--size;
			return temp.getBus();

		} else {
			temp = current;
			prevoius.setNext(current.getNext());
			--size;
			return temp.getBus();
		}
	}

	public int getSize() {
		return size;
	}

	public boolean isLast() {
		return current.getNext() == null;
	}

}
