package entity;

public class City {
	private int 	cityCode;
	private String	name;
	private boolean	isCapital;
	private int 	populationAmount;
	private Country	country;
	
	
	
	
	public City(int cityCode, String name, boolean isCapital, int populationAmount, Country country) {
		super();
		this.cityCode = cityCode;
		this.name = name;
		this.isCapital = isCapital;
		this.populationAmount = populationAmount;
		this.country = country;
	}
	
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCapital() {
		return isCapital;
	}
	public void setCapital(boolean isCapital) {
		this.isCapital = isCapital;
	}
	public int getPopulationAmount() {
		return populationAmount;
	}
	public void setPopulationAmount(int populationAmount) {
		this.populationAmount = populationAmount;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}






}
