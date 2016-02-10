package buspark;

import java.util.Iterator;

public class Park {
	private BusList in = new BusList();
	private BusList out = new BusList();
	private Bus bus;
	private int qty;
	
	public Park(int qty) {
		for (int i = 0; i < qty; i++) {
			in.push(new Bus("FFF"));
			
		}
		
	}
	
	public void BusOut(){
		if(!in.isEmpty()){
			qty=(int)(Math.random()*in.getSize());
			in.first();
			for (int i = 0; i <qty; i++) {
				in.next();
				
			}
			System.out.println("Bus out:" + in.getBus());
			out.push(in.pop());
		}
		
	}
	
	public void BusIn(){
		if(!out.isEmpty()){
			qty=(int)(Math.random()*out.getSize());
			out.first();
			for (int i = 0; i <qty; i++) {
				out.next();
				
			}
			System.out.println("Bus in:" + out.getBus());
			in.push(out.pop());
		}
	}
	
	public void listIn(){
		in.first();
		while(!in.isEmpty()){
			System.out.println(in.getBus());
			if(in.isLast())break;
				in.next();
		}
		if(in.isEmpty())System.out.println("none");
	}
	
	public void listOut(){
		out.first();
		while(!out.isEmpty()){
			System.out.println(out.getBus());
			if(out.isLast())break;
			out.next();
		}
		if(out.isEmpty())System.out.println("none");
	}
	
	public int getInQty(){
		return in.getSize();
	}
	
	public int getOutQty(){
		return out.getSize();
	}

}
