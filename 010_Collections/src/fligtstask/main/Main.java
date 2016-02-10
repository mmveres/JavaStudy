package fligtstask.main;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import fligtstask.entities.Destinations;
import fligtstask.entities.FlightRequest;
import fligtstask.entities.FlightRequestList;

public class Main {
	public static void main(String[] args) {
		FlightRequestList frl=new FlightRequestList();
		for (int i = 0; i < 10; i++) {
			frl.push(requestGenerator());
		}
		printAllList(frl);
		frl.first();
		for(int i=0;i<(int)(Math.random()*frl.getSize());i++){
			frl.next();
			
		}
		System.out.println("deleting "+frl.pop());
		printAllList(frl);

	}

	public static FlightRequest requestGenerator() {
		FlightRequest fr = new FlightRequest();
		Destinations from = Destinations.getByid((int) (Math.random() * Destinations.values().length));
		Destinations to = null;
		do {
			to = Destinations.getByid((int) (Math.random() * Destinations.values().length));
		} while (from == to);
		fr.setDestinationPoint(to.toString());
		fr.setFlightNumber(1010 + from.ordinal() * 100 + to.ordinal());
		fr.setPassengerName("Default");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			fr.setRequestedDate(sdf.parse(dateGenerator()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return fr;
	}
	
	private static void printAllList(FlightRequestList fl) {
		fl.first();
		for (int i = 0; i < fl.getSize(); i++) {
			System.out.println(fl.getFlightRequest());
			fl.next();
		}
	}

	private static String dateGenerator() {
		int month = 1 + (int) (Math.random() * 12);
		int year = 2015 + (int) (Math.random() * 2);
		int maxDays = 31;
		switch (month) {
		case 4:
			maxDays = 30;
			break;
		case 6:
			maxDays = 30;
			break;
		case 11:
			maxDays = 30;
			break;
		case 9:
			maxDays = 30;
			break;
		case 2: {
			if (year % 4 == 0) {
				maxDays = 29;
			} else {
				maxDays = 28;
			}
		}
			break;

		default:
			break;
		}
		int day=1+(int)(Math.random()*maxDays);
		return ""+(day<10?"0"+day:day)+"-"+(month<10?"0"+month:month)+"-"+year;
	}
}
