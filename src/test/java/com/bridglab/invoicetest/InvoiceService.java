package com.bridglab.invoicetest;

import org.junit.Assert;
import org.junit.Test;
import com.bridglab.invoice.InvoiceGenerator;

public class InvoiceService {
	
	@Test
	public void givenDistanceTime_shouldReturnFare() {
		InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare=invoiceGenerator.calculateFare(distance,time);
		Assert.assertEquals(25, fare,0.0);
		
	}
}
