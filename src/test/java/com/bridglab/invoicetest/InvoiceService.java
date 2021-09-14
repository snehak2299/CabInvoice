package com.bridglab.invoicetest;

import org.junit.Assert;
import org.junit.Test;
import com.bridglab.invoice.InvoiceGenerator;
import com.bridglab.invoice.Rides;

public class InvoiceService {
	
	@Test
	public void givenDistanceTime_shouldReturnFare() {
		InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare=invoiceGenerator.calculateFare(distance,time);
		Assert.assertEquals(25, fare,0.0);
		
	}
	@Test
	public void givenDistanceTime_minimumFare_shouldReturnFare() {
		InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare=invoiceGenerator.calculateFare(distance,time);
		Assert.assertEquals(5, fare,0.0);
		
	}
	 @Test
	    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		 	InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
	        Rides[] ride={new Rides(2.0,5),new Rides(0.1,1)
	        };
	        double fare=invoiceGenerator.calculateFare(ride);
	        Assert.assertEquals(30,fare,0.0);
	    }
}
