package figures;

public class Point extends Figure implements Moveable{
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		
		return getClass().getSimpleName() + " [x= " + x +", y= "+ y +"]";
	}

	@Override
	public
	void print() {
		System.out.println(toString());
		
	}

	@Override
	public void moveUp(int step) {
		y=y+step;
		
	}

	@Override
	public void moveDown(int step) {
		y=y-step;
		
	}

	@Override
	public void moveLeft(int step) {
		x=x-step;
		
	}

	@Override
	public void moveRight(int step) {
		x=x+step;
		
	}
}
