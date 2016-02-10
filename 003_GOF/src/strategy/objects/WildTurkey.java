package strategy.objects;

public class WildTurkey implements Turkey{

	@Override
	public void gobble() {
		System.out.println("Kvo-kvo-kvo!");
		
	}

	@Override
	public void fly() {
		System.out.println("I'm flying short distance!");
		
	}

}
