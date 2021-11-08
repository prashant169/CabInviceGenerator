package com.bridgelabz.cabinvicegenerator;


import java.util.Objects;

public class InvoiceSummary {
    int numberOfRides;
    double totalFare;
    double avgFare;

    public InvoiceSummary() {

    }

    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
    }

    public InvoiceSummary getInvoiceSummary() {
        this.avgFare = this.totalFare / this.numberOfRides;
        return this;
    }

    // to compare objects we should have hashcode method else they
    //create a two different instances so creating equals() and hashcode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numberOfRides == that.numberOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.avgFare, avgFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfRides, totalFare, avgFare);
    }
}