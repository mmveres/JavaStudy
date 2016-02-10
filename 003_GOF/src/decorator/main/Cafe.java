package decorator.main;

import decorator.beverages.Beverage;
import decorator.beverages.DarkRoast;
import decorator.beverages.Decaf;
import decorator.beverages.Espresso;
import decorator.ingredient.Cream;
import decorator.ingredient.Mocha;
import decorator.ingredient.Pepper;
import decorator.ingredient.Soy;

public class Cafe {
	public static void main(String[] args) {
		Beverage bev1 = new Espresso();
		System.out.println(bev1.getDescription() + " cost "+ bev1.getCost());
		
		Beverage bev2 = new Pepper(new Cream(new Soy(new DarkRoast())));
		System.out.println(bev2.getDescription() + " cost "+ bev2.getCost());
		
		bev2 = new Pepper(new Cream(new Soy(new Mocha(new Soy(new Decaf())))));
		System.out.println(bev2.getDescription() + " cost "+ bev2.getCost());
		
		
		bev2 = new Decaf();
		bev2.setSize(Beverage.SIZE_MID);
		bev2 = new Pepper(new Cream(new Soy(new Mocha(new Soy(bev2)))));
		System.out.println(bev2.getDescription() + " cost "+ bev2.getCost());
	}
}
