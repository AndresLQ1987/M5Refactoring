package Ejercicio2;

import java.util.Date;

public class Lloguer {
	
	private Date data;
	private int dies;
	private Vehicle vehicle;
	
	public Lloguer(Date data, int dies) {
		this.data = data;
		this.dies = dies;
		setVehicle(null);
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getDies() {
		return dies;
	}

	public void setDies(int dies) {
		this.dies = dies;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void lloga(Vehicle v) {
		setVehicle(v);
	}
	
	public void eliminaLloguer() {
		setVehicle(null);
	}
	
	public boolean teLloguer() {
		if (vehicle != null) {
			return true;
		} else {
			return false;
		}
	}
}
