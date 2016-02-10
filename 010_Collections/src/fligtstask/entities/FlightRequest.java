package fligtstask.entities;

import java.util.Date;

public class FlightRequest {
	private static int counter;
	private final int id;
	private String destinationPoint;
	private int flightNumber;
	private String passengerName;
	private Date requestedDate;
	
	public FlightRequest() {
		id=counter++;
	}

	public String getDestinationPoint() {
		return destinationPoint;
	}

	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	@Override
	public String toString() {
		return "FlightRequest [id=" + id + ", destinationPoint=" + destinationPoint + ", flightNumber=" + flightNumber
				+ ", passengerName=" + passengerName + ", requestedDate=" + requestedDate + "]";
	}
	
	

}
