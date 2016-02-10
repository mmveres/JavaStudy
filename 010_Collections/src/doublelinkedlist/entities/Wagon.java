package doublelinkedlist.entities;

public abstract class Wagon {
	private Wagon nextWagon;
	private Wagon prevWagon;

	public Wagon getPrevWagon() {
		return prevWagon;
	}

	public void setPrevWagon(Wagon prevWagon) {
		this.prevWagon = prevWagon;
	}

	public Wagon getNextWagon() {
		return nextWagon;
	}

	public void setNextWagon(Wagon nextWagon) {
		this.nextWagon = nextWagon;
	}


}
