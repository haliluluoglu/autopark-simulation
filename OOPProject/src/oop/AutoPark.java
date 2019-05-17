package oop;
import java.util.ArrayList;


public class AutoPark {
	private ArrayList<SubscribedVehicle> subscribedVehicles;
	private ArrayList<ParkRecord> parkRecords;
	private double hourlyFee,incomeDaily;
	private int capacity;
	
	
	public AutoPark(double hourlyFee, int capacity) {
		this.capacity=capacity;
		subscribedVehicles = new ArrayList<SubscribedVehicle>();
		parkRecords = new ArrayList<ParkRecord>();
		this.hourlyFee=hourlyFee;		
	}
		
	public ArrayList<SubscribedVehicle> getSubscribedVehicles() {
		return subscribedVehicles;
	}

	public ArrayList<ParkRecord> getParkRecords() {
		return parkRecords;
	}

	public double getHourlyFee() {
		return hourlyFee;
	}


	public double getIncomeDaily() {
		return incomeDaily;
	}


	public int getCapacity() {
		return capacity;
	}

	public void setSubscribedVehicles(ArrayList<SubscribedVehicle> subscribedVehicles) {
		this.subscribedVehicles = subscribedVehicles;
	}

	public void setParkRecords(ArrayList<ParkRecord> parkRecords) {
		this.parkRecords = parkRecords;
	}

	public void setHourlyFee(double hourlyFee) {
		this.hourlyFee = hourlyFee;
	}


	public void setIncomeDaily(double incomeDaily) {
		this.incomeDaily = incomeDaily;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public SubscribedVehicle searchVehicle(String plate)
	{
		//Matcher m1 = Pattern.compile("\\d\\d [A-Z][A-Z] \\d\\d").matcher(plate);
		//Matcher m2 = Pattern.compile("\\d\\d [A-Z][A-Z][A-Z] \\d\\d").matcher(plate);
		//Matcher m3 = Pattern.compile("\\d\\d [A-Z][A-Z] \\d\\d\\d").matcher(plate);
		//Matcher m4 = Pattern.compile("\\d\\d [A-Z][A-Z][A-Z] \\d\\d\\d").matcher(plate);

		if((plate!=null)  && (plate.length()>=8 &&	 (plate.length()<=10)) )
		{
			for(SubscribedVehicle aVehicle : subscribedVehicles)
			{
				if(aVehicle.getPlate()==plate)
					return aVehicle;				
			}
		}
		return null;
	}
	
	public boolean isParked(String plate)
	{
		if(plate != null)
		{	
			for(ParkRecord aParkRecord : parkRecords)
			{
				if(aParkRecord.getVehicle().getPlate().compareTo(plate) == 0)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean addVehicle(SubscribedVehicle aVehicle)
	{
		if(this.capacity > 0)
		{
			if(searchVehicle(aVehicle.getPlate())==null)
			{
				
				subscribedVehicles.add(aVehicle);
				this.capacity--;
				System.out.println("naptýn");
				return true;
			}
		}
		return false;
	}
	
	public boolean vehicleEnters(String plate, Time enter, boolean isOfficial)
	{
		if(plate != null && enter != null)
		{
			if(!isParked(plate))
			{
				SubscribedVehicle subVehicle = searchVehicle(plate);
				
				if(subVehicle != null)
				{
					ParkRecord aRecord = new ParkRecord(enter, subVehicle);
					parkRecords.add(aRecord);
					return true;
				}
				else
				{
					if(isOfficial)
					{
						OfficialVehicle offVehicle = new OfficialVehicle(plate);
						ParkRecord aRecord = new ParkRecord(enter, offVehicle);
						parkRecords.add(aRecord);
						return true;
					}
					else
					{
						RegularVehicle regVehicle = new RegularVehicle(plate);
						ParkRecord aRecord = new ParkRecord(enter, regVehicle);
						parkRecords.add(aRecord);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean vehicleExits(String plate, Time exit)
	{
		
		if(plate != null && exit !=null)
		{
			if(isParked(plate))
			{	
				for(int i=0; i<parkRecords.size(); i++)
				{
					if(parkRecords.get(i) != null)
					{
						if(parkRecords.get(i).getVehicle().getPlate().compareTo(plate) == 0 )
						{	
							parkRecords.get(i).setExitTime(exit);
							
							if(parkRecords.get(i).getVehicle().getSubscriptions() != null)
							{
								if(parkRecords.get(i).getVehicle().getSubscriptions().isValid() == true)
								{	
									if(parkRecords.get(i).getVehicle().isOfficial() == false)
									{
										incomeDaily += Math.abs((hourlyFee * parkRecords.get(i).getParkingDuration()));
									}
									else
									{
										this.incomeDaily=0;
										this.hourlyFee=0;
									}
								}
							}
							else
							{
								incomeDaily += Math.abs((hourlyFee * parkRecords.get(i).getParkingDuration()));
							}
							parkRecords.remove(parkRecords.get(i).getVehicle());
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	private void enlargeArray()
	{
		this.capacity++;
	}

	@Override
	public String toString() {
		return "AutoPark [subscribedVehicles=" + subscribedVehicles + ", parkRecords=" + parkRecords + ", hourlyFee="
				+ hourlyFee + ", incomeDaily=" + incomeDaily + ", capacity=" + capacity + "]";
	}
	
}
