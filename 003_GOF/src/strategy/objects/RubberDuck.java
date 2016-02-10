package strategy.objects;

public class RubberDuck extends Duck{

	public RubberDuck(){
		flyBehaviour= new FlyNoWay();
		quackBehaviour= new Squeak();
	}
	
	@Override
	public void display() {
		System.out.println("I'm RUBBER duck!");
		
	}

}
