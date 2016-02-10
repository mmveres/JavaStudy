package railwaystack.entities;

public class Cargo extends Wagon{
private static int counter;
private int id;


public Cargo() {
	id=++counter;
	
}

@Override
public String toString() {
	return "Cargo [id=" + id + "]";
}


}
