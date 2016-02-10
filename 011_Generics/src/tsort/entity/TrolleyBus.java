package tsort.entity;

public class TrolleyBus extends Vehicle{
	private String name;
	private int plate;
	private int routeNum;
	private int voltage;
	
	
	

	
	public TrolleyBus(String name, int plate, int routeNum, int voltage) {
		super();
		this.name = name;
		this.plate = plate;
		this.routeNum = routeNum;
		this.voltage = voltage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPlate() {
		return plate;
	}
	public void setPlate(int plate) {
		this.plate = plate;
	}
	public int getRouteNum() {
		return routeNum;
	}
	public void setRouteNum(int routeNum) {
		this.routeNum = routeNum;
	}
	public int getVoltage() {
		return voltage;
	}
	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}
	@Override
	public String toString() {
		return "TrolleyBus [name=" + name + ", plate=" + plate + ", routeNum=" + routeNum + ", voltage=" + voltage
				+ "]";
	}

	
	
	
}
