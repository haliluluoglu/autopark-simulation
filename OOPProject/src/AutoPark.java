import java.util.ArrayList;

public class AutoPark {
	private SubscribedVehicle subscribedVehicles[];
	private ArrayList<ParkRecord> parkRecords;
	private double hourlyFee,incomeDaily;
	private int capacity;
	
	
	public AutoPark(double hourlyFee, int capacity) {
		this.capacity=capacity;
		subscribedVehicles = new SubscribedVehicle[capacity];
		parkRecords = new ArrayList<ParkRecord>();
		this.hourlyFee=hourlyFee;		
	}
	
	public SubscribedVehicle[] getSubscribedVehicles() {
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


	public void setSubscribedVehicles(SubscribedVehicle[] subscribedVehicles) {
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
				if(aParkRecord.getVehicle().getPlate() !=null)
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
				subscribedVehicles[this.capacity]=aVehicle;
				this.capacity--;
				return true;
			}
		}
		return false;
	}
	
	public boolean vehicleEnters(String plate, Time enter, boolean isOfficial)
	{
		if(!isParked(plate))
		{
			Vehicle aVehicle = searchVehicle(plate);
			ParkRecord aRecord = new ParkRecord(enter,aVehicle);
			if(!isOfficial)
			{
				parkRecords.add(aRecord);
			}
			return true;
		}
		return false;
	}
	
	public boolean vehicleExits(String plate, Time exit)
	{
		if(!isParked(plate))
		{
			Vehicle aVehicle = searchVehicle(plate);
			ParkRecord aRecord = new ParkRecord(exit);
			aRecord.setVehicle(aVehicle);
			
			if(aVehicle.isOfficial())
			{
				this.hourlyFee=0;
				this.incomeDaily=0;
			}
			else
			{
					int temp = aRecord.getParkingDuration();
					this.incomeDaily += this.hourlyFee * temp;
					parkRecords.remove(aRecord);
			}
			return true;
		}
		return false;	
	}
	
	private void enlargeArray()
	{
		this.capacity++;
	}
}
