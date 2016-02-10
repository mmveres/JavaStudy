package classwork;

enum Weekday {
	Monday("from 9 till 18", 9), Tuesday("from 9 till 18", 9), Wednesday("from 9 till 18", 9), Thursday(
			"from 9 till 18", 9), Friday("from 9 till 16", 7), Saturday("day off", 0), Sunday("day off", 0);

	int wrkHrs;
	String descrtiption;

	private Weekday(String descrtiption, int wrkHrs) {
		this.wrkHrs = wrkHrs;
		this.descrtiption = descrtiption;
	}

	public int getWrkHrs() {
		return wrkHrs;
	}

	public String getDescrtiption() {
		return descrtiption;
	}

	public static Weekday getDay(int number) {
		Weekday wd = null;
		if (number < 0 | number > Weekday.values().length - 1)
			wd = null;

		for (Weekday w : Weekday.values()) {
			if (w.ordinal() == number)
				wd = w;
			;

		}
		return wd;
	}

}

public class WorkingHours {

	public static void main(String[] args) {
		int dayOff1 = (int) (Math.random() * 7);
		int dayOff2;
		do {
			dayOff2 = (int) (Math.random() * 7);
		} while (dayOff1 == dayOff2);
		System.out.println(dayOff1 + " " + dayOff2);
		Weekday[] days = new Weekday[7];
		for (int i = 0; i < days.length; i++) {
			if (i != dayOff1 & i != dayOff2)
				days[i] = Weekday.getDay(i);

		}

		int totalWrkHrs = 0;
		for (Weekday weekday : days) {
			if (weekday == null)
				continue;
			System.out.println("Worked " + weekday + " " + weekday.getWrkHrs() + " Hrs - " + weekday.getDescrtiption());
			totalWrkHrs += weekday.getWrkHrs();

		}
		System.out.println("-----------------");
		System.out.println("Total hours: " + totalWrkHrs);
	}

}
