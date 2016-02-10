package decorator.ingredient;

import decorator.beverages.Beverage;

public class Soy extends Ingredient {
	private Beverage beverage;
	private String description;
	private float cost = 0.29F;

	public Soy(Beverage beverage) {
		super();
		this.beverage = beverage;
		description = "Soy";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + " " + description;
	}

	@Override
	public float getCost() {
		switch (getSize()) {
		case Beverage.SIZE_SMALL:
			cost = cost / 3;
			break;
		case Beverage.SIZE_MID:
			cost = cost / 2;
			break;
		}
		return beverage.getCost() + cost;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return beverage.getSize();
	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub

	}

}
