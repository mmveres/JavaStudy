package railwaystack.main;

import railwaystack.entities.Cargo;
import railwaystack.entities.Wagon;

public class WagonTStack {
	private WagonStack pass;
	private WagonStack cargo;

	public WagonTStack() {
		pass = new WagonStack();
		cargo = new WagonStack();
	}

	public void push(Wagon wagon) {
		if (wagon instanceof Cargo) {
			cargo.push(wagon);
		} else {
			pass.push(wagon);
		}
	}
	
	public Wagon pop(){
		//let's consider cagro goes out first
		if(!cargo.isEmpty())return cargo.pop();
		//then pass goes out
		if(!pass.isEmpty())return pass.pop();
		return null;
	}
	
	public boolean isEmpty(){
		return cargo.isEmpty()&&pass.isEmpty();
	}

}
