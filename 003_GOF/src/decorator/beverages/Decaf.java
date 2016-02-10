package decorator.beverages;

public class Decaf extends Beverage {
	private float cost = 3.69F;
	private int size;

	public Decaf() {

		description = "Decaf";
		size = Beverage.SIZE_BIG;
	}

	@Override
	public float getCost() {
		// TODO Auto-generated method stub
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
		return size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

}
