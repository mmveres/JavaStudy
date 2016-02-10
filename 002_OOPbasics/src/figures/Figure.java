package figures;

public abstract class Figure implements Comparable<Figure>, Moveable{
public abstract void print();
private static int counter=1;
private int id;

public Figure() {
	super();
	id = counter++;
}
public int getId() {
	return id;
}

	@Override
	public int compareTo(Figure f) {
		if(this.id>f.id)return 1;
		if(this.id<f.id)return -1;
		return 0;
	}
}
