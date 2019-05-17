package oop;

public class Subscription {
	private Date end,begin;
	private SubscribedVehicle vehicle;
	private String plate;

	
	public Subscription(Date end, Date begin, String plate) {
		if((end!=null) && (end!=null) && (plate!=null) )
		{
				this.plate=plate;
				this.end = end;
				this.begin = begin;
				vehicle =  new SubscribedVehicle(plate, this);
		
		}
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
	
	public String getPlate()
	{
		return plate;
	}
	
	public void setPlate(String plate)
	{
		this.plate=plate;
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
	
	public boolean isValid()
	{
		return Date.getToday().isAfterThan(end);
	}
	
}
