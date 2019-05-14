
public class ParkRecord {
	private Time enterTime,exitTime;
	private Vehicle vehicle;
	
	public ParkRecord(Time enterTime, Vehicle vehicle) {
		this.enterTime = enterTime;
		this.vehicle = vehicle;
	}
	
	public ParkRecord(Time exitTime) {
		this.exitTime = exitTime;
	}

	public Time getEnterTime() {
		return enterTime;
	}

	public Time getExitTime() {
		return exitTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setEnterTime(Time enterTime) {
		this.enterTime = enterTime;
	}

	public void setExitTime(Time exitTime) {
		this.exitTime = exitTime;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public int getParkingDuration()
	{
		return exitTime.getDifference(enterTime);
	}
}
