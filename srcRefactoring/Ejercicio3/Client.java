package Ejercicio3;

import java.util.ArrayList;

public class Client {
	private String nif;
	private String nom;
	private String telefon;
	private ArrayList<Lloguer> lloguers;
	
	private static final double EUROS_PER_UNITAT_DE_COST = 30;

	public Client(String nif, String nom, String telefon) {
		this.nif = nif;
		this.nom = nom;
		this.telefon = telefon;
		this.lloguers = new ArrayList<Lloguer>();
	}

	public String getNif() {
		return nif;
	}

	public String getNom() {
		return nom;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public ArrayList<Lloguer> getLloguers() {
		return lloguers;
	}

	public void afegeix(Lloguer lloguer) {
		if (!lloguers.contains(lloguer)) {
			lloguers.add(lloguer);
		}
	}

	public void elimina(Lloguer lloguer) {
		if (lloguers.contains(lloguer)) {
			lloguers.remove(lloguer);
		}
	}

	public boolean conte(Lloguer lloguer) {
		return lloguers.contains(lloguer);
	}

	public String informe() {
		return composaCapsalera() +
			   composaDetall() +
			   composaPeu();
	}

	private String composaCapsalera() {
		return "Informe de lloguers del client " + nom + " (" + nif + ")\n";
	}

	private String composaDetall() {
		String detall = "";
		for (Lloguer lloguer : lloguers) {
			detall += "\t" + lloguer.getVehicle().getMarca() + " " + lloguer.getVehicle().getModel() + ": "
					+ (lloguer.quantitat() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
		}
		return detall;
	}

	private String composaPeu() {
		return "Import a pagar: " + importTotal() + "€\n" + "Punts guanyats: " + bonificacionsTotals() + "\n";
	}

	private int bonificacionsTotals() {
		int bonificacions = 0;
		for (Lloguer lloguer : lloguers) {
			bonificacions += lloguer.bonificacions();
		}
		return bonificacions;
	}

	private double importTotal() {
		double total = 0;
		for (Lloguer lloguer : lloguers) {
			double quantitat = lloguer.quantitat();
			total += quantitat * EUROS_PER_UNITAT_DE_COST;
		}
		return total;
	}
}
