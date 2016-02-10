package case19;
/*
 * Case19. В восточном календаре принят 60-летний цикл, состоящий из 12-лет-
них подциклов, обозначаемых названиями цвета: зеленый, красный, жел-
тый, белый и черный. В каждом подцикле годы носят названия животных:
крысы, коровы, тигра, зайца, дракона, змеи, лошади, овцы, обезьяны, ку-
рицы, собаки и свиньи. По номеру года определить его название, если 1984
год — начало цикла: «год зеленой крысы».
 */

enum ColorCycle {
	Green, Red, Yellow, White, Black;

	public static ColorCycle getColor(int i) {
		ColorCycle c = null;
		for (ColorCycle color : ColorCycle.values()) {
			if (color.ordinal() == i) {
				c = color;
				break;
			}
		}
		return c;
	}

}

enum AnimalCycle {
	Rat, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, Chicken, Dog, Pig;

	public static AnimalCycle getAnimal(int i) {
		AnimalCycle a = null;
		for (AnimalCycle animal : AnimalCycle.values()) {
			if (animal.ordinal() == i) {
				a = animal;
				break;
			}
		}
		return a;
	}
}

class AnimalCalculator {
	public static final int MARKER = 1984;
	public static final int COLOR_FULL_CYCLE = AnimalCycle.values().length * ColorCycle.values().length;
	public static final int ANIMAL_FULL_CYCLE = AnimalCycle.values().length;

	public static String calcAnimal(int year) {
		String animal = "unknown";

		if (year >= MARKER) {
			return getAnimal(year,MARKER);
		} else {
			int temp=MARKER-(((MARKER-year)/COLOR_FULL_CYCLE)+1)*COLOR_FULL_CYCLE;
//			System.out.println("temp "+temp);
			return getAnimal(year,temp);
		}

	}

	public static String getAnimal(int year, int marker) {
		String animal;
		int colorYearNum = ((year - marker) % COLOR_FULL_CYCLE) / ANIMAL_FULL_CYCLE;
//		System.out.println(colorYearNum);
		animal = ColorCycle.getColor(colorYearNum).toString() + " ";
		int animalNum = (year - marker) % ANIMAL_FULL_CYCLE;
//		System.out.println(animalNum);
		animal = animal + AnimalCycle.getAnimal(animalNum);
		return animal;
	}

}

public class Main {
	public static void main(String[] args) {
		for (int i = 1800; i < 2067; i++) {
			System.out.println(i+ " " + AnimalCalculator.calcAnimal(i));
		}
//		System.out.println(AnimalCalculator.calcAnimal(1986));
		

	}

}
