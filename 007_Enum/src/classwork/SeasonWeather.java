package classwork;

class Season {
	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Season(int value) {
		super();
		this.value = value;
	}
	
}

public class SeasonWeather {
	public static void main(String[] args) {
Season spring = new Season(1);
Season summer = new Season(2);
Season fall = new Season(3);
Season winter = new Season(4);
	}

}
