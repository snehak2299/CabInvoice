package com.bridglab.invoicetest;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import com.bridglab.invoice.InvoiceGenerator;
import com.bridglab.invoice.InvoiceSummary;
import com.bridglab.invoice.Rides;
import com.bridglab.invoice.ServiceType;

public class InvoiceService {
	
	@Test
	public void shouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator(1.0,1,ServiceType.NORMAL_RIDE);
		Assert.assertEquals(11.0, invoiceGenerator.calculateFare(),0.0);
	}
	@Test
	public void shouldReturnTotalFare_forPrimiumRide() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator(1.0,1,ServiceType.PERIMIUM_RIDE);
		Assert.assertEquals(22.0, invoiceGenerator.calculateFare(),0.0);
	}
	
	
	@Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		InvoiceGenerator invoiceGenerator=new InvoiceGenerator(1.0,1,ServiceType.PERIMIUM_RIDE);
        Rides[] ride1={new Rides(2.0,1,5),new Rides(0.1,1,1)};
        Rides[] ride2={new Rides(2,4,6),new Rides(2,2,3),new Rides(2,5,6)};
        InvoiceSummary fare1=invoiceGenerator.calculateFare(ride1);
        Assert.assertEquals("InvoiceSummary [noOfRides= 2 , totalFare= 44 , averageFare=22 ]",fare1);      
        InvoiceSummary fare2=invoiceGenerator.calculateFare(ride2);
        Assert.assertEquals("InvoiceSummary [noOfRides= 3 , totalFare= 64 , averageFare=46.666 ]",fare2);

    }
}
