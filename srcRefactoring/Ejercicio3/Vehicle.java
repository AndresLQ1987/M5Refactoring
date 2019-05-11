package Ejercicio3;

public class Vehicle {

	private String model;
	private String marca;
	private Tipo categoria;
	public static Tipo BASIC = Tipo.BASIC;
	public static Tipo GENERAL = Tipo.GENERAL;
	public static Tipo LUXE = Tipo.LUXE;

	private enum Tipo {
		BASIC, GENERAL, LUXE
	}

	public Vehicle(String model, String marca, Tipo cat) {
		this.model = model;
		this.marca = marca;
		categoria = cat;
	}

	public String getModel() {
		return model;
	}

	public String getMarca() {
		return marca;
	}

	public Tipo getCategoria() {
		return categoria;
	}
}
