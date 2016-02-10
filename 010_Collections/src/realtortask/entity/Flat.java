package realtortask.entity;

public class Flat extends Premise{
	private int roomQty;
	private int floor;
	private float area;
	private String address;
	private static int counter;
	private final int id;
	
	public Flat(int roomQty, int floor, float area, String address) {
		
		this.roomQty = roomQty;
		this.floor = floor;
		this.area = area;
		this.address = address;
		id=counter++;
	}

	public int getRoomQty() {
		return roomQty;
	}

	public void setRoomQty(int roomQty) {
		this.roomQty = roomQty;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Flat [roomQty=" + roomQty + ", floor=" + floor + ", area=" + area + ", address=" + address + ", id="
				+ id + "]";
	}
	
	
	
	
	
	

}
