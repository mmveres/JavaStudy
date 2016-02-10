package railwaystack.entities;

public class Pass extends Wagon{
private static int counter;
private int id;


public Pass() {
	id=++counter;
}

@Override
public String toString() {
	return "Pass [id=" + id + "]";
}


}
