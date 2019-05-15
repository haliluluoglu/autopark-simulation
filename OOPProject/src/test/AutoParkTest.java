package test;

import java.util.Date;

import junit.framework.TestCase;
import oop.AutoPark;
import oop.SubscribedVehicle;
import oop.Subscription;

public class AutoParkTest extends TestCase {
	
	AutoPark autoPark;
	
	protected void setUp()
	{
		autoPark = new AutoPark(10.0,5);
		Date end1 = new Date(2020, 10, 10);
		Date begin1 = new Date(2020, 10, 15);
		
		Date end2 = new Date(2019, 2, 28);
		Date begin2 = new Date(2020, 3, 2);
		
		
		Subscription sub1 = new Subscription(end1, begin1, "34 HIU 01");
		SubcribedVehicle subVehicle1 = new SubscribedVehicle("34 HIU 01", sub1, false);
		
		
		Subscription sub1 = new Subscription(end1, begin2, "34 HIU 01");
		SubscribedVehicle subVehicle2 = new SubscribedVehicle("34 HIU 02", sub2, false);
		SubscribedVehicle subVehicle3 = new SubscribedVehicle("34 HIU 03", sub3, false);
		SubscribedVehicle subVehicle4 = new SubscribedVehicle("34 HIU 04", sub4, false);
		SubscribedVehicle subVehicle5 = new SubscribedVehicle("34 HIU 05", sub5, false);
	}
		
	public void testGetHourlyFee()
	{
		double temp = autoPark.getHourlyFee();
		assertEquals(temp,10.0);
	}
	
	public void testGetCapacity()
	{
		int temp = autoPark.getCapacity();
		assertEquals(temp,5);
	}
	
	public void testSearchVehicle()
	{
		assertEquals(subVehicle1, autoPark.searchVehicle("34 HIU 01"));
	}
	
	public void testAddVehicle()
	{
		autoPark.addVehicle(subVehicle1);
		assertEquals(subVehicle1, autoPark.searchVehicle(subVehicle1.getPlate()));
	}
	
	public void testIsFullVehicleArray()
	{
	
		
	}
	

}
