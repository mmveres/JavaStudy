package figures;

import exceptions.NullLengthLineException;

public class Line extends Figure implements Moveable{
	Point start;
	Point end;

	public static float calcLength(Point start, Point end){
		
		return (float)(Math.sqrt(Math.pow(end.getX()-start.getX(),2) + Math.pow(end.getY()-start.getY(),2)));
	}
	
	public void setEnd(Point end) throws NullLengthLineException {
		if(start!=null){
			if (calcLength(start, end)==0)throw new NullLengthLineException("Null line lenghth. Error in setEnd()");
		}
		this.end = end;
	}

	public Point getEnd() {
		return end;
	}

	public void setStart(Point start) throws NullLengthLineException {
		if(end!=null){
			if (calcLength(start, end)==0)throw new NullLengthLineException("Null line lenghth. Error in setStart()");
		}
		this.start = start;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(int x, int y) throws NullLengthLineException {
		setStart(new Point(x,y));
	}

	public Line(int x1, int y1, int x2, int y2) throws NullLengthLineException {
		// composition
		setStart(new Point(x1, y1));
		setEnd(new Point(x2, y2));
	}

	public Line(Point start, Point end) throws NullLengthLineException {
		// aggregation
		setStart(start);
		setEnd(end);
	}

	public float getLength() {
		return calcLength(start, end);
	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " [" + start.toString() + "," + end.toString() + "]";
	}

	@Override
	public
	void print() {
		System.out.println(toString());

	}

	@Override
	public void moveUp(int step) {
		start.moveUp(step);
		end.moveUp(step);
		
	}

	@Override
	public void moveDown(int step) {
		start.moveDown(step);
		end.moveDown(step);
		
	}

	@Override
	public void moveLeft(int step) {
		start.moveLeft(step);
		end.moveLeft(step);
		
	}

	@Override
	public void moveRight(int step) {
		start.moveRight(step);
		end.moveRight(step);
		
		
	}
}
