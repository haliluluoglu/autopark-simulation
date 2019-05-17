package test;


import junit.framework.TestCase;
import oop.AutoPark;
import oop.Date;
import oop.OfficialVehicle;
import oop.RegularVehicle;
import oop.SubscribedVehicle;
import oop.Subscription;
import oop.Time;

public class AutoParkTest extends TestCase {
	
	AutoPark autoPark = new AutoPark(10.0,5);
	
	//protected void setUp()
	//{


		
		
		Date end2 = new Date(2019, 2, 28);
		Date begin2 = new Date(2020, 3, 2);
		
		
		// sub1 = new Subscription(end1, begin1, "34 HIU 01");
		//SubscribedVehicle subVehicle1 = new SubscribedVehicle("34 HIU 01", sub1, false);
		
		
		Subscription sub2 = new Subscription(end2, begin2, "34 HIU 02");
		//SubscribedVehicle subVehicle2 = new SubscribedVehicle("34 HIU 02", sub2, false);
		//SubscribedVehicle subVehicle3 = new SubscribedVehicle("34 HIU 03", sub3, false);
		//SubscribedVehicle subVehicle4 = new SubscribedVehicle("34 HIU 04", sub4, false);
		//SubscribedVehicle subVehicle5 = new SubscribedVehicle("34 HIU 05", sub5, false);
	//}
		
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
		Date end1 = new Date(2020, 10, 10);
		Date begin1 = new Date(2020, 10, 15);
		Subscription sub1 = new Subscription(end1, begin1, "34 HIU 01");
		SubscribedVehicle subVehicle1 = new SubscribedVehicle("34 HIU 01", sub1);
		
		autoPark.addVehicle(subVehicle1);
		assertEquals(subVehicle1, autoPark.searchVehicle(subVehicle1.getPlate()));
	}
	
	public void testSearchVehicleWrongPlate()
	{
		Date end1 = new Date(2020, 10, 10);
		Date begin1 = new Date(2020, 10, 15);
		Subscription sub1 = new Subscription(end1, begin1, "345 HIU 012");
		SubscribedVehicle subVehicle1 = new SubscribedVehicle("345 HIU 012", sub1);
		
		autoPark.addVehicle(subVehicle1);
		assertEquals(null, autoPark.searchVehicle(subVehicle1.getPlate()));
	}
	
	public void testAddVehicle()
	{
		Date end1 = new Date(2020, 10, 10);
		Date begin1 = new Date(2020, 10, 15);
		Subscription sub1 = new Subscription(end1, begin1, "34 HIU 01");
		SubscribedVehicle subVehicle1 = new SubscribedVehicle("34 HIU 01", sub1);
		
		autoPark.addVehicle(subVehicle1);
		assertEquals(subVehicle1, autoPark.searchVehicle(subVehicle1.getPlate()));
	}
	
	public void testIsFullVehicleArray()
	{
			Date end1 = new Date(2020, 10, 10);
			Date begin1 = new Date(2020, 10, 15);
			Subscription sub1 = new Subscription(end1, begin1, "34 HIU 01");
			SubscribedVehicle subVehicle1 = new SubscribedVehicle("34 HIU 01", sub1);
			SubscribedVehicle subVehicle2 = new SubscribedVehicle("34 HIU 02", sub1);
			SubscribedVehicle subVehicle3 = new SubscribedVehicle("34 HIU 03", sub1);
			SubscribedVehicle subVehicle4 = new SubscribedVehicle("34 HIU 04", sub1);
			SubscribedVehicle subVehicle5 = new SubscribedVehicle("34 HIU 05", sub1);
			
			autoPark.addVehicle(subVehicle1);
			autoPark.addVehicle(subVehicle2);
			autoPark.addVehicle(subVehicle3);
			autoPark.addVehicle(subVehicle4);
			autoPark.addVehicle(subVehicle5);
		
			
		assertEquals(0,autoPark.getCapacity());
	}
	
	public void testCantAddSamePlateVehicle()
	{
		Date end1 = new Date(2020, 10, 10);
		Date begin1 = new Date(2020, 10, 15);
		Subscription sub1 = new Subscription(end1, begin1, "34 HIU 01");
		SubscribedVehicle subVehicle1 = new SubscribedVehicle("34 HIU 01", sub1);
		
		autoPark.addVehicle(subVehicle1);
		
		assertEquals(false, autoPark.addVehicle(subVehicle1));
	}
	
	public void testVehicleEntersIsOfficial()
	{
		Time enter1 = new Time(12,25);
		OfficialVehicle offVehicle1 = new OfficialVehicle("34 HIU 01");
		
		assertEquals(true, autoPark.vehicleEnters(offVehicle1.getPlate(), enter1, offVehicle1.isOfficial()));
	}
	
	public void testVehicleExitsOfficialVehicle()
	{
		Time enter1 = new Time(12,25);
		Time exit1 = new Time(13,50);
		
	
		OfficialVehicle offVehicle1 = new OfficialVehicle("34 HIU 01");
		autoPark.vehicleEnters(offVehicle1.getPlate(), enter1, offVehicle1.isOfficial());
		autoPark.vehicleExits(offVehicle1.getPlate(), exit1);
	
		assertEquals(0.0, autoPark.getIncomeDaily());
	}
	
	public void testVehicleExitsRegularVehicle()
	{
		Time enter1 = new Time(12,25);
		Time exit1 = new Time(14,55);
		
		RegularVehicle regVehicle1 = new RegularVehicle("34 HIU 01");
		autoPark.vehicleEnters(regVehicle1.getPlate(), enter1, regVehicle1.isOfficial());
		autoPark.vehicleExits(regVehicle1.getPlate(), exit1);
		
		assertEquals(20.0, autoPark.getIncomeDaily());
	}

	
}
