package realtortask.entity;

public class FlatRequest extends Premise{
	private int roomQty;
	private int floor;
	private float area;
	private static int counter;
	private final int id;
	
	public FlatRequest(int roomQty, int floor, float area) {
		
		this.roomQty = roomQty;
		this.floor = floor;
		this.area = area;
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

	@Override
	public String toString() {
		return "FlatRequest [roomQty=" + roomQty + ", floor=" + floor + ", area=" + area + ", id=" + id + "]";
	}




	}
