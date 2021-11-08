package com.bridgelabz.cabinvicegenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceService {
	private static final double COST_PER_KM = 10;
	private static final double COST_PER_MIN = 1;
	private static final double MIN_FARE = 5.0;

	public double calculateFare(double distance, int time) {

		double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
		return Math.max(totalFare, MIN_FARE);
	}

	public double calculateTotalFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare = calculateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare;

	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime());
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	public InvoiceSummary getInvoice(int userId) {
		Map<Integer, Ride[]> map = new HashMap<Integer, Ride[]>();
		Ride[] rides1 = { new Ride(2.0, 5), new Ride(0.1, 1) };
		Ride[] rides2 = { new Ride(5.0, 10), new Ride(1, 1) };

		Ride[] rides3 = { new Ride(8.0, 15), new Ride(1, 10) };
		map.put(1, rides1);
		map.put(2, rides2);
		map.put(3, rides3);

		for (Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
			if (userId == entry.getKey()) {
				System.out.println(entry.getKey());
				Ride[] ridesArray = entry.getValue();
				return calculateFare(ridesArray);
			}
		}
		return null;
	}

	private static final double MINIMUM_COST_PER_KILOMETER_NORMAL = 10;
	private static final int COST_PER_TIME_NORMAL = 1;
	private static final double MINIMUM_FARE_NORMAL = 5;
	public static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15;
	public static final double COST_PER_TIME_PREMIUM = 2;
	public static final double MINIMUM_FARE_PREMIUM = 20;

	public double calculateFare(double distance, int time, String type) {

		if (type.equalsIgnoreCase("Normal")) {
			double totalFare = distance * MINIMUM_COST_PER_KILOMETER_NORMAL + time * COST_PER_TIME_NORMAL;
			return Math.max(totalFare, MINIMUM_FARE_NORMAL);
		} else if (type.equalsIgnoreCase("Premium")) {
			double totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_PREMIUM;
			return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
		} else {
			System.out.println("Please Enter Proper Customer Type");
			return 0.0;
		}
	}

	// for type - total fare calculate
	public double calculateFare(Ride[] rides, String type) {
		double totalFare = 0.0;
		if (type.equalsIgnoreCase("Normal")) {
			for (Ride ride : rides) {
				totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
			}
			return totalFare;

		} else if (type.equalsIgnoreCase("Premium")) {
			for (Ride ride : rides) {
				totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);

			}
			return totalFare;
		} else
			System.out.println("Please Enter Proper Customer Type");
		return 0.0;
	}

	// For type- summary invoice
	public InvoiceSummary calculateTotalFare(Ride[] rides, String type) {
		double totalFare = 0.0;
		if (type.equalsIgnoreCase("Normal")) {
			for (Ride ride : rides) {
				totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
			}
		} else if (type.equalsIgnoreCase("Premium")) {
			for (Ride ride : rides) {
				totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
			}
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
}