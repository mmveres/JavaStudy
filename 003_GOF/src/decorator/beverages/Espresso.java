package decorator.beverages;

public class Espresso extends Beverage {
	private float cost = 1.99F;
	private int size;

	public Espresso() {

		description = "Espresso";
		size = Beverage.SIZE_BIG;
	}

	@Override
	public float getCost() {
		switch (size) {
		case Beverage.SIZE_SMALL:
			cost = cost / 3;
			break;
		case Beverage.SIZE_MID:
			cost = cost / 2;
			break;
		}
		return cost;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSize(int size) {
		this.size = size;

	}

}
