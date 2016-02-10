package figures;

import exceptions.NotATriangleException;
import exceptions.NullLengthLineException;

public class Triangle extends Figure implements Moveable{
	private Point point1;
	private Point point2;
	private Point point3;
	private Line sideA;
	private Line sideB;
	private Line sideC;
	
	public static boolean isTriangle(Point p1, Point p2, Point p3){
		int result=(p2.getY()-p1.getY())*(p3.getX()-p1.getX()) -(p3.getY()-p1.getY())*(p2.getY()-p1.getX());
		if (result==0) return false;
		return true;
	}

	public Triangle(Line l1, Line l2, Line l3) {
		this.sideA = l1;
		this.sideB = l2;
		this.sideC = l3;
	}

	public Triangle(Point point1, Point point2, Point point3) throws NotATriangleException {
		setPoint1(point1);
		setPoint2(point2);
		setPoint3(point3);
	}

	public Line getSideA() throws NullLengthLineException{
		// lazy init - singleton
		if (sideA == null)
			sideA = new Line(point3, point2);
		return sideA;
	}

	public Line getSideB() throws NullLengthLineException {
		if (sideB == null)
			sideB = new Line(point3, point1);
		return sideB;
	}


	public Line getSideC() throws NullLengthLineException {
		if (sideC == null)
			sideC = new Line(point2, point1);
		return sideC;
	}


	public double getLengthSideB() {
		// delegation
		return sideB.getLength();
	}

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) throws NotATriangleException {
		setPoint1(new Point(x1, y1));
		setPoint2(new Point(x2, y2));
		setPoint3(new Point(x3, y3));
	}

	public void setPoint1(Point point1) throws NotATriangleException {
		if(point2!=null&point3!=null){
			if (!isTriangle(point1, point2, point3))throw new NotATriangleException("Error at setPoint1()");
		}
		this.point1 = point1;
	}

	public void setPoint2(Point point2) throws NotATriangleException {
		if(point1!=null&point3!=null){
			if (!isTriangle(point1, point2, point3))throw new NotATriangleException("Error at setPoint2()");
		}
		this.point2 = point2;
	}

	public void setPoint3(Point point3) throws NotATriangleException {
		if(point1!=null&point2!=null){
			if (!isTriangle(point1, point2, point3))throw new NotATriangleException("Error at setPoint3()");
		}
		this.point3 = point3;
	}

	public Point getPoint1() {
		return point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public Point getPoint3() {
		return point3;
	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " [" + point1.toString() + "," + point2.toString() + "," + point3.toString() + "]";
	}

	@Override
	public
	void print() {
		System.out.println(toString());

	}

	@Override
	public void moveUp(int step) {
		point1.moveUp(step);
		point2.moveUp(step);
		point3.moveUp(step);
		
	}

	@Override
	public void moveDown(int step) {
		point1.moveDown(step);
		point2.moveDown(step);
		point3.moveDown(step);
		
	}

	@Override
	public void moveLeft(int step) {
		point1.moveLeft(step);
		point2.moveLeft(step);
		point3.moveLeft(step);
		
	}

	@Override
	public void moveRight(int step) {
		point1.moveRight(step);
		point2.moveRight(step);
		point3.moveRight(step);
		
	}

}
