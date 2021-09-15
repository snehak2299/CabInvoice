package com.bridglab.invoice;

import java.util.HashMap;

public class InvoiceGenerator {

	private static final int COST_PER_TIME = 1;
	private static final double MIN_COST_PER_KILOMETER = 10.0;
	private static final double MINIMUM_FARE = 5;
	HashMap<Integer,InvoiceSummary> users=new HashMap<Integer, InvoiceSummary>();
	private int numb;

	public double calculateFare(double distance, int time) {
		
		double totalFare= distance*MIN_COST_PER_KILOMETER+time*COST_PER_TIME;
		if(totalFare<MINIMUM_FARE)
			return MINIMUM_FARE;
		return totalFare;
	}
	public InvoiceSummary calculateFare(Rides[] ride) {
        double totalFare=0;
        for (Rides rides : ride) {
           totalFare+= this.calculateFare(rides.distance, rides.time);
        }
        users.put(numb,new InvoiceSummary(ride.length,totalFare));
        numb++;
        return new InvoiceSummary(ride.length, totalFare);
    }
	 public String findFareOfGivenId(int i)
	    {
	        System.out.println(users.get(i));
	        return String.valueOf(users.get(i));

	    }

}
