package Exercici8;

import java.util.Set;

public class Concessionaris {
	private String adreça;
	private Set<Vehicles> vehicles;

	public Concessionaris(String adreça, Set<Vehicles> vehicles) {
		super();
		this.adreça = adreça;
		this.vehicles = vehicles;
	}

	public String getAdreça() {
		return adreça;
	}

	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}

	public Set<Vehicles> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicles> vehicles) {
		this.vehicles = vehicles;
	}

}
