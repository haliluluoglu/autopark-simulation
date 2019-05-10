
public class Subscription {
	private Date end,begin;
	private SubscribedVehicle vehicle;
	private String plate;
	
	public Subscription(Date end, Date begin, SubscribedVehicle vehicle, String plate) {
		this.end = end;
		this.begin = begin;
		this.vehicle = vehicle;
		this.plate=plate;
	}
	
	public Date getEnd() {
		return end;
	}
	public Date getBegin() {
		return begin;
	}
	public SubscribedVehicle getVehicle() {
		return vehicle;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public void setVehicle(SubscribedVehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public boolean isValid()
	{
		Date aDate = new Date();
		if(begin<aDate.getToday())
			
	}
	
	

}
