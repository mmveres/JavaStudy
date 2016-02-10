package case20;
/*
Case20. Даны два целых числа: D (день) и M (месяц), определяющие правиль-
ную дату. Вывести знак Зодиака, соответствующий этой дате: «Водолей»
(20.1–18.2), «Рыбы» (19.2–20.3), «Овен» (21.3–19.4), «Телец» (20.4–20.5),
«Близнецы» (21.5–21.6), «Рак» (22.6–22.7), «Лев» (23.7–22.8), «Дева»
(23.8–22.9), «Весы» (23.9–22.10), «Скорпион» (23.10–22.11), «Стрелец»
(23.11–21.12), «Козерог» (22.12–19.1). 
 */

class InvalidMonthException extends Exception {
};

class InvalidDateException extends Exception {
};

enum Zodiac {
	Vodoley(20, 1), Ryby(19, 2), Oven(21, 3), Telets(20, 4), Bliznetsy(25, 5), Rak(22, 6), Lev(23, 7), Deva(23,
			8), Vesy(23, 9), Skorpion(23, 10), Strelets(23, 11), Kozerog(22, 12);

	int day, month;

	private Zodiac(int day, int month) {
		this.day = day;
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

}

class ZodiacMindwarp {
	public static Zodiac getSign(int day, int month) throws InvalidDateException, InvalidMonthException {
		if (day < 1 || day > 31)
			throw new InvalidDateException();
		if (month < 1 || month > 12)

			throw new InvalidMonthException();
		System.out.println("monthh " + month + "; day " + day);

		Zodiac z = null;
		Zodiac[] z_items = Zodiac.values();

		for (Zodiac zodiac : z_items) {
			if (zodiac.getMonth() == month) {
				z = zodiac;
				break;
			}
		}
		if (day >= z.getDay())
			return z;

		int num = z.ordinal() - 1;
		if (num == -1) {
			num = 11;
		}
		return z_items[num];

	}

}

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println(ZodiacMindwarp.getSign(20, 1));
		} catch (InvalidDateException | InvalidMonthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
