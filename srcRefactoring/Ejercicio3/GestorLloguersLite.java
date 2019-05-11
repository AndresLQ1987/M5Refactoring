package Ejercicio3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GestorLloguersLite {
	
	public static void main(String[] args) {
		
		Vehicle coche1 = new Vehicle("Volkswagen", "Polo", Vehicle.BASIC);
		Vehicle coche2 = new Vehicle("Nissan", "SkyLine", Vehicle.GENERAL);
		Vehicle coche3 = new Vehicle("Bugatti", "Iberion", Vehicle.LUXE);
		
		Date fechaLloguer1 = createDate("24/5/2009", "d/M/yyyy");
		Date fechaLloguer2 = createDate("10/6/2012", "d/M/yyyy");
		Date fechaLloguer3 = createDate("15/7/2018", "d/M/yyyy");
		
		Lloguer lloguer1 = new Lloguer(fechaLloguer1, 130);
		Lloguer lloguer2 = new Lloguer(fechaLloguer2, 60);
		Lloguer lloguer3 = new Lloguer(fechaLloguer3, 3);
		
		lloguer1.lloga(coche1);
		lloguer2.lloga(coche2);
		lloguer3.lloga(coche3);
		
		Client client = new Client("12345789T", "Andres", "669 23 55 76");
		client.afegeix(lloguer1);
		client.afegeix(lloguer2);
		client.afegeix(lloguer3);
		
		String informe = informacioClient(client);
		System.out.println(informe);
	}

	public static String informacioClient(Client client) {
		String informe = "";
		informe += "Client: " + client.getNom() + "\n";
		informe += "\t" + client.getNif() + "\n";
		informe += "\t" + client.getTelefon() + "\n";
		informe += "Lloguers: " + client.getLloguers().size() + "\n";
		for (int i = 0; i < client.getLloguers().size(); i++) {
			informe += "\t" + indexOfLloguer(client.getLloguers(), i) + ". vehicle: "
					+ vehicle(client.getLloguers(), i).getMarca() + " " + vehicle(client.getLloguers(), i).getModel()
					+ "\n";
			informe += "\t   data d'inici: " + dataLloguer(client.getLloguers(), i) + "\n";
			informe += "\t   dies llogats: " + diesLloguer(client.getLloguers(), i) + "\n";
		}
		return informe;
	}
	
	private static Date createDate(String fecha, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = dateFormat.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	private static Date dataLloguer(ArrayList<Lloguer> Lloguers, int i) {
		return Lloguers.get(i).getData();
	}
	
	private static int diesLloguer(ArrayList<Lloguer> Lloguers, int i) {
		return Lloguers.get(i).getDies();
	}

	private static int indexOfLloguer(ArrayList<Ejercicio3.Lloguer> Lloguers, int i) {
		return Lloguers.indexOf(Lloguers.get(i));
	}

	private static Vehicle vehicle(ArrayList<Ejercicio3.Lloguer> Lloguers, int i) {
		return Lloguers.get(i).getVehicle();
	}
}