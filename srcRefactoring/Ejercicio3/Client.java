package Ejercicio3;

import java.util.ArrayList;

public class Client {
	
	private static final double EUROS_PER_UNITAT_DE_COST = 30;
	
	private String nif;
	private String nom;
	private String telefon;
	private ArrayList<Lloguer> lloguers;

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
	
	public String informeHTML() {
		return composaCapsaleraHTML() +
			   composaDetallHTML() +
			   composaPeuHTML();
	}

	private String composaCapsalera() {
		return "Informe de lloguers del client " + nom + " (" + nif + ")\n";
	}
	private String composaCapsaleraHTML() {
		return "<h1>Informe de lloguers<h1>\n" +
			   "<p>Informe de lloguers del client <em>" + nom + "</em> (<strong>" + nif + "</strong>)</p>\n";
	}

	private String composaDetall() {
		String detall = "";
		for (Lloguer lloguer : lloguers) {
			detall += "\t" + lloguer.getVehicle().getMarca() + " " + lloguer.getVehicle().getModel() + ": "
					+ (lloguer.preu() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
		}
		return detall;
	}
	
	private String composaDetallHTML() {
		String detall = "";
		detall += "<table>\n";
		detall += "\t<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>\n";
		for (Lloguer lloguer : lloguers) {
			detall += "\t<tr><td>" + lloguer.getVehicle().getMarca() + "</td><td>" + lloguer.getVehicle().getModel() + "</td><td>"
					+ (lloguer.preu() * EUROS_PER_UNITAT_DE_COST) + "€</td></tr>\n";
		}
		detall += "</table>\n";
		return detall;
	}

	private String composaPeu() {
		return "Import a pagar: " + importTotal() + "€\n" + "Punts guanyats: " + bonificacionsTotals() + "\n";
	}
	
	private String composaPeuHTML() {
		return "<p>Import a pagar: <em>" + importTotal() + "€</em></p>\n" + 
			   "<p>Punts guanyats: <em>" + bonificacionsTotals() + "</em></p>\n";
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
			double quantitat = lloguer.preu();
			total += quantitat * EUROS_PER_UNITAT_DE_COST;
		}
		return total;
	}
}
