package Ejercicio3;

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

	/*
	 * Ya no le pasamos el lloguer ya que es el propio lloguer el que calcula la
	 * quantitat y el sabe sus atributos por lo que no es necesario pasarselo por
	 * parametros.
	 */
	public double quantitat() {
		double quantitat = 0;
		switch (vehicle.getCategoria()) {
		case BASIC:
			quantitat += 3;
			if (dies > 3) {
				quantitat += (dies - 3) * 1.5;
			}
			break;
		case GENERAL:
			quantitat += 4;
			if (dies > 2) {
				quantitat += (dies - 2) * 2.5;
			}
			break;
		case LUXE:
			quantitat += dies * 6;
			break;
		}
		return quantitat;
	}

	public int bonificacions() {
		int bonificacions = 1;
		// afegeix bonificació per dos dies de lloguer de Luxe
		if (vehicle.getCategoria() == Vehicle.LUXE && dies > 1) {
			bonificacions++;
		}
		return bonificacions;
	}
}
