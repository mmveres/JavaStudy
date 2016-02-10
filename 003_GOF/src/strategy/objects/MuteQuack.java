package strategy.objects;

public class MuteQuack implements QuackBehaviour{

	@Override
	public void quack() {
		System.out.println("I'm MUTE!");
		
	}

}
