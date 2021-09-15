package com.bridglab.invoice;

import java.util.HashMap;

public class InvoiceGenerator {

	private static final int COST_PER_TIME_NORMAL = 1;
	private static final double MIN_COST_PER_KILOMETER_NORMAL = 10.0;
	private static final double MINIMUM_FARE_NORMAL = 5;
	private static final int COST_PER_TIME_PRIMIUM = 2;
	private static final double MIN_COST_PER_KILOMETER_PRIMIUM = 20.0;
	private static final double MINIMUM_FARE_PRIMIUM = 15;
	private static double totalFare;
	private double totalKm;
	private double totaltime;
	private ServiceType serviceType;
	
	HashMap<Integer,InvoiceSummary> users=new HashMap<Integer, InvoiceSummary>();
	private int numb;
	public InvoiceGenerator (double totalKm, double totaltime,ServiceType serviceType) {
		super();
		this.totalKm = totalKm;
		this.totaltime = totaltime;
		this.serviceType = serviceType;
	}

	public double calculateFare() {
		if(serviceType.equals(ServiceType.NORMAL_RIDE)) {
			totalFare = (double)((this.totalKm*MIN_COST_PER_KILOMETER_NORMAL)+(this.totaltime*COST_PER_TIME_NORMAL));
			if((int)totalFare <= MINIMUM_FARE_NORMAL) return MINIMUM_FARE_NORMAL;
		}
		else {
			totalFare = (double)((this.totalKm*MIN_COST_PER_KILOMETER_PRIMIUM)+(this.totaltime*COST_PER_TIME_PRIMIUM));
			if((int)totalFare <= MINIMUM_FARE_PRIMIUM) return MINIMUM_FARE_PRIMIUM;
		}
		return totalFare;
	}
	public InvoiceSummary calculateFare(Rides[] ride) {
        double totalFare=0;
        for (Rides rides : ride) {
           totalFare+= this.calculateFare();
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
