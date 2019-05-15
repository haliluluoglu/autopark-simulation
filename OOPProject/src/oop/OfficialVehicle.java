package oop;

public class OfficialVehicle implements Vehicle{
	
	private String plate;
	private Subscription subscriptions;
	private boolean official=true;
	
	public OfficialVehicle(String plate, Subscription subscriptions, boolean official) {
		this.plate = plate;
		this.subscriptions = subscriptions;
		this.official = official;
	}

	public String getPlate() {
		return plate;
	}

	public Subscription getSubscriptions() {
		return subscriptions;
	}

	public boolean isOfficial() {
		return official;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public void setSubscriptions(Subscription subscriptions) {
		this.subscriptions = subscriptions;
	}

	public void setOfficial(boolean official) {
		this.official = official;
	}
	
}
