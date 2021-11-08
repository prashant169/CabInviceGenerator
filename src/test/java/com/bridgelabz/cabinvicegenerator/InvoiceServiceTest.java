package com.bridgelabz.cabinvicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	InvoiceService invoiceService;

	@Before
	public void setup() {
		invoiceService = new InvoiceService();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceService invoiceService = new InvoiceService();
		double distance = 2.0;
		int time = 5;
		double totalFare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(25, totalFare, 0);
	}

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinFare() {
		InvoiceService invoiceService = new InvoiceService();
		double distance = 0.1;
		int time = 1;
		double totalFare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(5.0, totalFare, 0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnTotalOfTotalFare() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(5.0, 10), new Ride(0.1, 1), new Ride(20, 60) };
		InvoiceService invoiceService = new InvoiceService();
		double totalFare = invoiceService.calculateTotalFare(rides);
		Assert.assertEquals(260, totalFare, 0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1), };
		InvoiceService invoiceService = new InvoiceService();
		InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedInvoices = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
	}

	@Test
	public void givenUserId_ShouldReturnInvoiceSummary() {

		InvoiceSummary invoiceSummary = invoiceService.getInvoice(1);
		InvoiceSummary expectedInvoices = new InvoiceSummary(2, 30);
		Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
	}
}