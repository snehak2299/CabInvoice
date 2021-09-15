package com.bridglab.invoicetest;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import com.bridglab.invoice.InvoiceGenerator;
import com.bridglab.invoice.InvoiceSummary;
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
        Rides[] ride1={new Rides(2.0,1,5),new Rides(0.1,1,1)};
        Rides[] ride2={new Rides(2,4,6),new Rides(2,2,3),new Rides(2,5,6)};
        InvoiceSummary fare1=invoiceGenerator.calculateFare(ride1);
        Assert.assertEquals("InvoiceSummary{noOfRides=2, totalFare=30.0, averageFare=15.0}",fare1);

        InvoiceSummary fare2=invoiceGenerator.calculateFare(ride2);
       Assert.assertEquals("InvoiceSummary{noOfRides=3, totalFare=125.0, averageFare=41.666666666666664}",fare2);

    }
}
