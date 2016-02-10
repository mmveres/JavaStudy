package railwaystack.entities;

public abstract class Wagon {
	private Wagon nextWagon;

	public Wagon getNextWagon() {
		return nextWagon;
	}

	public void setNextWagon(Wagon nextWagon) {
		this.nextWagon = nextWagon;
	}


}
