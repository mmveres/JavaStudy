package tsort.tools;

import tsort.entity.Bus;
import tsort.entity.Vehicle;

public class MySorter {

//method-level
	public <T extends Vehicle> void sort (T []array){
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-i-1; j++) {
				if(array[j].getRouteNum()>array[j+1].getRouteNum()){
					T temp=array[j];
					array[j]= array[j+1];
					array[j+1]=temp;
				}
				
			}
		}
	}

}

//class-level
//public class MySorter <T extends Vehicle>{
//	public void sort (T []array){
//		for (int i = 0; i < array.length; i++) {
//			for (int j = 0; j < array.length-i-1; j++) {
//				if(array[j].getRouteNum()>array[j+1].getRouteNum()){
//					T temp=array[j];
//					array[j]= array[j+1];
//					array[j+1]=temp;
//				}
//				
//			}
//		}
//	}
//
//}