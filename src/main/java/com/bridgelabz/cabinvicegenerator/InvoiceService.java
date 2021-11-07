package com.bridgelabz.cabinvicegenerator;

public class InvoiceService {
	private static final double COST_PER_KM = 10;
	private static final double COST_PER_MIN = 1;
	private static final double MIN_FARE = 5.0;

	public double CalculateFare(double distance, int time) {
		double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
		return Math.max(totalFare, MIN_FARE);
	}

	public double calculateFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare = CalculateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare;

	}

}