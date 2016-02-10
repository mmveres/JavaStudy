package realtortask.main;

import realtortask.container.PremiseList;
import realtortask.entity.Flat;
import realtortask.entity.FlatRequest;
import realtortask.entity.Premise;

public class Main {
	public static void main(String[] args) {
		PremiseList flatList = new PremiseList();
		PremiseList reqList = new PremiseList();
		for (int i = 0; i < 20; i++) {
			flatList.push(flatGenerator());
		}
		printAllList(flatList);
		findBestFlat(flatList, new FlatRequest(4, 4, 70.0f), reqList);
		printAllList(reqList);
		
		

	}

	private static void printAllList(PremiseList flatList) {
		flatList.first();
		for (int i = 0; i < flatList.getSize(); i++) {
			System.out.println(flatList.getPremise());
			flatList.next();
		}
	}

	public static Premise flatGenerator() {
		int floor = 1 + (int) (Math.random() * 9);
		int rQty = 1 + (int) (Math.random() * 4);
		float area = (6.0f + 15f * rQty) * (1.0f + (float) (Math.random() * 0.2F));
		return new Flat(rQty, floor, area, "DEFAULT_ADDRESS");
	}

	public static Premise findBestFlat(PremiseList flatList, FlatRequest request, PremiseList rqList) {
		System.out.println("got request " + request);
		
		if (flatList.getSize() == 0){
			System.out.println("nothing to chose from, adding request to list");
			rqList.push(request);
			return null;
		}
;
		Flat flat = null;
		int roomQty = request.getRoomQty();
		int floor = request.getFloor();
		float needArea = request.getArea();
		flatList.first();
		do {
			flat = (Flat) flatList.getPremise();
			if (flat.getFloor() == floor && flat.getRoomQty() == roomQty
					&& (Math.abs(flat.getArea() - needArea)) / needArea <= 0.1f){
				System.out.println("match found, deleting: " + flat + " from list");
				flat=(Flat)flatList.pop();
				break;
			}
				
			flat = null;
			flatList.next();

		} while (!flatList.isLast());
		if(flat==null){
			System.out.println("match not found, adding request to list");
			rqList.push(request);}
		return flat;

	}

}
