package strategy.objects;

public class ModelDuck extends Duck{

	public ModelDuck(){
		flyBehaviour= new FlyWithWings();
		quackBehaviour= new Quack();
	}
	
	@Override
	public void display() {
		System.out.println("I'm Model duck!");
		
	}

}
