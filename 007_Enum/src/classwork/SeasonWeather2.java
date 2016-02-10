package classwork;

import java.util.Scanner;

enum Season2 {
	Spring(1, "Vesna") {
		@Override
		public int getValue() {
			// TODO Auto-generated method stub
			return super.getValue() + 100;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return super.getName() + " - flowers are growing!";
		}
	},
	Summer(2, "Leto"), Fall(3, "Osen"), Winter(4, "Zima");

	int value;
	String name;

	private Season2(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

}

public class SeasonWeather2 {
	public static void main(String[] args) {
		for (Season2 s : Season2.values()) {
			System.out.println(s.getName() + ", " + s.name() + ", " + s.ordinal());

		}
		Season2 var=null;
		Scanner sc = new Scanner(System.in);
		int numSeason= sc.nextInt();
		for (Season2 s : Season2.values())	 {
if(s.ordinal()==numSeason)var=s;			
		}
		
		switch (var) {
		case Fall: System.out.println("Yellow");break;
		case Spring: System.out.println("Green");break;
		case Summer: System.out.println("Red");break;
		case Winter: System.out.println("White");break;
		default: break;
		}
		
		sc.close();
	}

}
