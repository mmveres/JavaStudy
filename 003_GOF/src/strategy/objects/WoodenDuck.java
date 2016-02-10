package strategy.objects;

public class WoodenDuck extends Duck{

	public WoodenDuck(){
		flyBehaviour= new FlyNoWay();
		quackBehaviour= new MuteQuack();
	}
	
	@Override
	public void display() {
		System.out.println("I'm WOODEN duck!");
		
	}

}
