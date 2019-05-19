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
	 *  Ya no le pasamos el lloguer ya que es el propio lloguer el que calcula la 
	 *  quantitat y el sabe sus atributos por lo que no es necesario pasarselo por
	 *  parametros.
	 */
	public double quantitat() {
		switch (vehicle.getCategoria()) {
        case BASIC:
            if (dies > 3) {
            	return dies * 1.5;
            } else {
            	return 3;
            }
        case GENERAL:
            if (dies > 2) {
                return 4 + (dies - 2) * 2.5;
            } else {
            	return 4;
            }
        case LUXE:
            return dies * 6;
        default:
        	return dies;
		}
	}
}
