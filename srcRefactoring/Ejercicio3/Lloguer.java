package Ejercicio3;

import java.util.Date;

public class Lloguer {
	
	private int MIN_QUANTITAT_BASIC = 3;
	private int MIN_QUANTITAT_GENERAL = 4;
	private int DIES_MATEIX_PREU_BASIC = 3;
	private int DIES_MATEIX_PREU_GENERAL = 2;
	private double PREU_PER_DIA_BASIC = 1.5;
	private double PREU_PER_DIA_GENERAL = 2.5;
	private double PREU_PER_DIA_LUXE = 6;

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

	public void eliminaVehicle() {
		setVehicle(null);
	}

	public boolean teVehicle() {
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
	public double preu() {
		double quantitat = 0;
		switch (vehicle.getCategoria()) {
		case BASIC:
			quantitat += MIN_QUANTITAT_BASIC;
			if (dies > DIES_MATEIX_PREU_BASIC) {
				quantitat += (dies - DIES_MATEIX_PREU_BASIC) * PREU_PER_DIA_BASIC;
			}
			break;
		case GENERAL:
			quantitat += MIN_QUANTITAT_GENERAL;
			if (dies > DIES_MATEIX_PREU_GENERAL) {
				quantitat += (dies - DIES_MATEIX_PREU_GENERAL) * PREU_PER_DIA_GENERAL;
			}
			break;
		case LUXE:
			quantitat += dies * PREU_PER_DIA_LUXE;
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
