package punish_bear_task;

public class Main {
	public static void main(String[] args) {
//		Forest(x, y) - forest size
		Forest f = new Forest(50, 50);
		System.out.println(f);
//		Hive(N, forest) - N=qty of bee groups
		new Hive(5, f);

	}

}
