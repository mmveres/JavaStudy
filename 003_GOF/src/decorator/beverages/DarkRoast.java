package decorator.beverages;

public class DarkRoast extends Beverage {
	private float cost = 2.99F;
	private int size;

	public DarkRoast() {

		description = "DarkRoast";
		size=Beverage.SIZE_BIG;
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
		return size;
	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub
		this.size = size;
	

	}
}
