package mazestack;

class Container {
	private Container next;

	public Container getNext() {
		return next;
	}

	public void setNext(Container next) {
		this.next = next;
	}

	private Cell cell;

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

}

public class CellStack {
	private Container head;
	private Container temp;
	private int size;

	public boolean isEmpty() {
		return head == null;
	}

	public void push(Cell cell) {
		Container c = new Container();
		c.setNext(head);
		c.setCell(cell);
		head = c;
		++size;

	}

	public Cell peek() {
		if (isEmpty()) {
			return null;
		} else {
			return head.getCell();
		}
	}

	public Cell pop() {
		if (isEmpty()) {
			return null;
		} else {
			temp = head;
			head = head.getNext();
			--size;
			return temp.getCell();
		}
	}
	
	public void clear(){
		head=null;
	}
	
	public int getSize() {
		return size;
	}

}
