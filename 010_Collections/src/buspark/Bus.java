package buspark;

public class Bus {
	private String busNumber;
	private String driverName;
	private int routeNum;
	private static int num;
	private final int id;
	
	
	
	public Bus(String driverName) {
		this.driverName = driverName;
		busNumber= "AA"+(1000+(int)(Math.random()*9000))+"DD";
		routeNum= 10+(int)(Math.random()*90);
		id=num++;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public int getRouteNum() {
		return routeNum;
	}
	public void setRouteNum(int routeNum) {
		this.routeNum = routeNum;
	}
	@Override
	public String toString() {
		return "Bus [ID"+id+" "+ busNumber + " " + driverName + " " + routeNum + "]";
	}
	
	

}
