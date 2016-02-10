package strategy.objects;

public class TurkeyAdapter extends Duck {
	WildTurkey wturkey;
	
	public TurkeyAdapter(WildTurkey wturkey){
		this.wturkey=wturkey;

		}
	

	@Override
	public void display() {
		System.out.println("I'm Turkey!");
		
	}

	public void performFly(){
		for (int i = 0; i < 5; i++) {
			wturkey.fly();
		};
	}
	
	public void performQuack(){
		wturkey.gobble();
	}
	

	

}
