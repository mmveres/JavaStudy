package strategy.main;

import strategy.objects.Duck;
import strategy.objects.FlyNoWay;
import strategy.objects.FlyWithRocketPower;
import strategy.objects.FlyWithWings;
import strategy.objects.MallardDuck;
import strategy.objects.ModelDuck;
import strategy.objects.RubberDuck;
import strategy.objects.TurkeyAdapter;
import strategy.objects.WildTurkey;
import strategy.objects.WoodenDuck;

public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		Duck wooden = new WoodenDuck();
		Duck rubber = new RubberDuck();
		Duck model = new ModelDuck();
		mallard.display();
		mallard.performFly();
		mallard.performQuack();
		wooden.display();
		wooden.performFly();
		wooden.performQuack();
		rubber.display();
		rubber.performFly();
		rubber.performQuack();
		model.display();
		model.performQuack();

		for (int i = 0; i < 15; i++) {
			if (i == 5) {
				model.setFlyBehaviour(new FlyWithRocketPower());
			}
			if (i == 8) {
				model.setFlyBehaviour(new FlyNoWay());
			}
			if (i == 12) {
				model.setFlyBehaviour(new FlyWithWings());
			}
			model.performFly();

		}
		
		WildTurkey turkey = new WildTurkey();
		Duck virtualDuck = new TurkeyAdapter(turkey);
		virtualDuck.display();
		virtualDuck.performQuack();
		virtualDuck.performFly();
	}
}
