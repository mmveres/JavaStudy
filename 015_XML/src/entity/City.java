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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cityCode;
		result = prime * result + (isCapital ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + populationAmount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (cityCode != other.cityCode)
			return false;
		if (isCapital != other.isCapital)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (populationAmount != other.populationAmount)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", cityCode=" + cityCode + ", isCapital=" + isCapital + ", populationAmount="
				+ populationAmount + ", country=" + country + "]";
	}






}
