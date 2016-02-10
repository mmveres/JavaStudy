package doublelinkedlist.main;

import doublelinkedlist.entities.Wagon;

public class DoubleLinkedList {
	private Wagon head;
	private Wagon tail;
	private Wagon temp;
	private Wagon current;
	private int size;

	public void addFirst(Wagon wagon) {
		temp = head;
		head = wagon;
		head.setNextWagon(temp);
		head.setPrevWagon(null);
		if(temp!=null)temp.setPrevWagon(head);
		if (tail == null)
			tail = head;
		current=head;
		size++;

	}

	public void addLast(Wagon wagon) {
		temp = tail;
		tail = wagon;
		tail.setPrevWagon(temp);
		if(temp!=null)temp.setNextWagon(tail);
		tail.setNextWagon(null);
		if (head == null)
			head = tail;
		current=tail;
		size++;
	}

	public void addAfterCurrent(Wagon wagon) {
		temp = current.getNextWagon();
		current.setNextWagon(wagon);
		wagon.setPrevWagon(current);
		temp.setPrevWagon(wagon);
		wagon.setNextWagon(temp);
		size++;

	}

	public void deleteCurrent() {
		if(getSize()<=0)return;
		if (isFirst()) {
			head = head.getNextWagon();
			if(head!=null)head.setPrevWagon(null);
			first();
		} else if (isLast()) {
			tail = tail.getPrevWagon();
			if(tail!=null)tail.setNextWagon(null);
			last();
		} else {
			temp=current;
			current=temp.getNextWagon();
			current.setPrevWagon(temp.getPrevWagon());
			temp.getPrevWagon().setNextWagon(current);
			temp=null;

		}
		size--;

	}

	public Wagon getCurrent() {
		if (getSize() > 0)
			return current;
		return null;
	}

	public void next() {
		if (!isLast())
			current = current.getNextWagon();
	}

	public void previous() {
		if (!isFirst())
			current = current.getPrevWagon();
	}

	public void first() {
		current = head;
	}

	public void last() {
		current = tail;
	}

	public int getSize() {
		return size;
	}

	public boolean isFirst() {
		return current == head;
	}

	public boolean isLast() {
		return current == tail;
	}

}
