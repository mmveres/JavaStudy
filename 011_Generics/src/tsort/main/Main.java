package tsort.main;

import tsort.entity.Bus;
import tsort.entity.TrolleyBus;
import tsort.tools.MySorter;

public class Main {
	
public static void main(String[] args) {
	
	Bus []buses=new Bus[3];
	buses[0]=new Bus("fff",111,2);
	buses[1]=new Bus("ddd",112,1);
	buses[2]=new Bus("sss",113,3);
//	class-level
//	MySorter<Bus>  ms= new MySorter<>();
	
	MySorter ms= new MySorter();
	ms.sort(buses);
	for (int i = 0; i < buses.length; i++) {
		System.out.println(buses[i]);
	}
	
	TrolleyBus []tbuses=new TrolleyBus[3];
	tbuses[0]=new TrolleyBus("fff",145,3,380);
	tbuses[1]=new TrolleyBus("hhh",167,1,380);
	tbuses[2]=new TrolleyBus("kkk",132,2,380);
//	MySorter<TrolleyBus>  mst= new MySorter<>();
	ms.sort(tbuses);
	for (int i = 0; i < tbuses.length; i++) {
		System.out.println(tbuses[i]);
	}
}
}
