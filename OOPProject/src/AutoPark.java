
public class AutoPark {
	private SubscribedVehicle subscribedVehicles[];
	private ParkRecord parkRecords[];
	private double hourlyFee,incomeDaily;
	private int capacity;
	
	
	public AutoPark(double hourlyFee, int capacity) {
		this.capacity=capacity;
		subscribedVehicles = new SubscribedVehicle[capacity];
		parkRecords = new ParkRecord[capacity];
		this.hourlyFee=hourlyFee;		
	}
	
	public SubscribedVehicle[] getSubscribedVehicles() {
		return subscribedVehicles;
	}


	public ParkRecord[] getParkRecords() {
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


	public void setSubscribedVehicles(SubscribedVehicle[] subscribedVehicles) {
		this.subscribedVehicles = subscribedVehicles;
	}


	public void setParkRecords(ParkRecord[] parkRecords) {
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
		for(SubscribedVehicle aVehicle : subscribedVehicles)
		{
			if(aVehicle.getPlate()==plate)
			{
				return aVehicle;
			}
		}
		return null;
	}
	
	public boolean isParked(String plate)
	{
		
		if(searchVehicle(plate) !=null)
		{
			for(ParkRecord aParkRecord : parkRecords)
			{
				if(aParkRecord != null)
				{
					
				}
			}
		}
		return false;
	}
	
}
