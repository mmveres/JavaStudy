package tsort.entity;

public abstract class Vehicle implements Comparable<Vehicle> {
	abstract public int getRouteNum();

	@Override
	public int compareTo(Vehicle o) {
		if(this.getRouteNum()>o.getRouteNum())return 1;
		if (this.getRouteNum()==o.getRouteNum())return 0;
		if (this.getRouteNum()<o.getRouteNum())return -1;
		return 0;
	}
	
	

}
