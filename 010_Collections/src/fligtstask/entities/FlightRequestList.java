package fligtstask.entities;


class Container {
	private Container next;

	public Container getNext() {
		return next;
	}

	public void setNext(Container next) {
		this.next = next;
	}

	private FlightRequest flightRequest;

	public FlightRequest getFlightRequest() {
		return flightRequest;
	}

	public void setFlightRequest(FlightRequest premise) {
		this.flightRequest = premise;
	}
	
	



}

public class FlightRequestList {
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

	public void push(FlightRequest flightRequest) {
		Container c = new Container();
		c.setNext(head);
		c.setFlightRequest(flightRequest);
		head = c;
		first();
		++size;

	}

	public FlightRequest getFlightRequest() {
		if (isEmpty()) {
			return null;
		} else {
			return current.getFlightRequest();
		}
	}

	public FlightRequest pop() {
		if (isEmpty()) {
			return null;
		} else if (prevoius == null) {
			temp = current;
			current = current.getNext();
			--size;
			return temp.getFlightRequest();

		} else {
			temp = current;
			prevoius.setNext(current.getNext());
			--size;
			return temp.getFlightRequest();
		}
	}

	public int getSize() {
		return size;
	}

	public boolean isLast() {
		return current.getNext() == null;
	}

}
