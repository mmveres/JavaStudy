package tsort.entity;

public class Bus extends Vehicle{
	private String name;
	private int plate;
	private int routeNum;
	
	
	
	public Bus(String name, int plate, int routeNum) {
		super();
		this.name = name;
		this.plate = plate;
		this.routeNum = routeNum;
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
	@Override
	public String toString() {
		return "Bus [name=" + name + ", plate=" + plate + ", routeNum=" + routeNum + "]";
	}
	
	
}
