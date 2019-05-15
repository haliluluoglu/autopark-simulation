package oop;

public class RegularVehicle implements Vehicle{
	private String plate;
	private boolean official=false;
	
	public RegularVehicle(String plate, boolean isOfficial) {
		this.plate = plate;
		this.official = isOfficial;
	}

	public String getPlate() {
		return plate;
	}

	public boolean isOfficial() {
		return official;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public void setOfficial(boolean isOfficial) {
		this.official = isOfficial;
	}

	@Override
	public Subscription getSubscriptions() {
		return null;
	}
}
