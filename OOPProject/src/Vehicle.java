
public class Vehicle implements RegularVehicle, SubscribedVehicle, OfficialVehicle{
	private String plate;
	private Subscription subscriptions;
	public Vehicle(String plate, Subscription subscriptions) {
		super();
		this.plate = plate;
		this.subscriptions = subscriptions;
	}
	public String getPlate() {
		return plate;
	}
	public Subscription getSubscriptions() {
		return subscriptions;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public void setSubscriptions(Subscription subscriptions) {
		this.subscriptions = subscriptions;
	}
	
	

}
