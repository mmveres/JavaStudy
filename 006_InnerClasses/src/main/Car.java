package main;

public class Car extends Vehicle{
	// this Engine belongs ONLY to car!!!!
	private String make;
	private int year;
	
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Car(String make, int year) {
		super();
		this.make = make;
		this.year = year;
	}
	public static class Engine{
		static String make;
		static double power;
	};
	class Wheels{
		private String make;
		private int price;
		public Wheels(String make, int price) {
			super();
			this.make = make;
			this.price = price;
		}
		public String getMake() {
			return make;
		}
		public void setMake(String make) {
			this.make = make;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
		public String getCarMake(){
			return Car.this.make;
		}
		
	}

}
