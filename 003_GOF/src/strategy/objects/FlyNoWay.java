package strategy.objects;

public class FlyNoWay implements FlyBehaviour{

	@Override
	public void fly() {
		System.out.println("I CAN'T fly!");
	}
}
