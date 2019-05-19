package Ejercicio3;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.*;

public class TestInforme {
	
	@Test
	public void clienteSinLloguers() {
		Client client = new Client("12345789T", "Andres", "669 23 55 76");
		String informe = client.informe();
		String esperado= "Informe de lloguers del client Andres (12345789T)\n" +
						 "Import a pagar: 0.0€\n" +
						 "Punts guanyats: 0\n";
		Assert.assertEquals(esperado, informe);
	}
	
	@Test
	public void clientAmbUnSolLloguerBasic() {
		
		//creamos el vehiculo de prueba
		Vehicle coche1 = new Vehicle("Volkswagen", "Polo", Vehicle.BASIC);
		
		
		//creamos las fechas de los alquileres de prueba
		Date fechaLloguer1 = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			fechaLloguer1 = dateFormat.parse("24/5/2009");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//creamos el alquiler de prueba
		Lloguer lloguer1 = new Lloguer(fechaLloguer1, 130);
		
		//le añadimos al alquiler el coche.
		lloguer1.lloga(coche1);
		
		//creamos el cliente de prueba
		Client client = new Client("12345789T", "Andres", "669 23 55 76");
		
		//le añadimos al cliente el alquiler.
		client.afegeix(lloguer1);
		
		//pedimos el informe del cliente.
		String informe = client.informe();
		
		String esperado = "Informe de lloguers del client Andres (12345789T)\n" + 
						  "\tPolo Volkswagen: 5805.0€\n" +
						  "Import a pagar: 5805.0€\n" + 
						  "Punts guanyats: 1\n";
		
		Assert.assertEquals(esperado, informe);
	}
	
	@Test
	public void clientAmbUnSolLloguerBasicYPocsDies() {
		
		//creamos el vehiculo de prueba
		Vehicle coche1 = new Vehicle("Volkswagen", "Polo", Vehicle.BASIC);
		
		
		//creamos las fechas de los alquileres de prueba
		Date fechaLloguer1 = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			fechaLloguer1 = dateFormat.parse("24/5/2009");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//creamos el alquiler de prueba
		Lloguer lloguer1 = new Lloguer(fechaLloguer1, 1);
		
		//le añadimos al alquiler el coche.
		lloguer1.lloga(coche1);
		
		//creamos el cliente de prueba
		Client client = new Client("12345789T", "Andres", "669 23 55 76");
		
		//le añadimos al cliente el alquiler.
		client.afegeix(lloguer1);
		
		//pedimos el informe del cliente.
		String informe = client.informe();
		
		String esperado = "Informe de lloguers del client Andres (12345789T)\n" + 
						  "\tPolo Volkswagen: 90.0€\n" +
						  "Import a pagar: 90.0€\n" + 
						  "Punts guanyats: 1\n";
		Assert.assertEquals(esperado, informe);
	}
	
	@Test
	public void clientAmbUnSolLloguerGeneral() {
		
		//creamos el vehiculo de prueba
		Vehicle coche1 = new Vehicle("Nissan", "SkyLine", Vehicle.GENERAL);
		
		
		//creamos las fechas de los alquileres de prueba
		Date fechaLloguer1 = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			fechaLloguer1 = dateFormat.parse("10/6/2012");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//creamos el alquiler de prueba
		Lloguer lloguer1 = new Lloguer(fechaLloguer1, 60);
		
		//le añadimos al alquiler el coche.
		lloguer1.lloga(coche1);
		
		//creamos el cliente de prueba
		Client client = new Client("12345789T", "Andres", "669 23 55 76");
		
		//le añadimos al cliente el alquiler.
		client.afegeix(lloguer1);
		
		//pedimos el informe del cliente.
		String informe = client.informe();
		
		String esperado = "Informe de lloguers del client Andres (12345789T)\n" + 
						  "\tSkyLine Nissan: 4470.0€\n" +
						  "Import a pagar: 4470.0€\n" + 
						  "Punts guanyats: 1\n";
		
		Assert.assertEquals(esperado, informe);
	}
	
	@Test
	public void clientAmbUnSolLloguerGeneralAmbPocsDies() {
		
		//creamos el vehiculo de prueba
		Vehicle coche1 = new Vehicle("Nissan", "SkyLine", Vehicle.GENERAL);
		
		
		//creamos las fechas de los alquileres de prueba
		Date fechaLloguer1 = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			fechaLloguer1 = dateFormat.parse("10/6/2012");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//creamos el alquiler de prueba
		Lloguer lloguer1 = new Lloguer(fechaLloguer1, 1);
		
		//le añadimos al alquiler el coche.
		lloguer1.lloga(coche1);
		
		//creamos el cliente de prueba
		Client client = new Client("12345789T", "Andres", "669 23 55 76");
		
		//le añadimos al cliente el alquiler.
		client.afegeix(lloguer1);
		
		//pedimos el informe del cliente.
		String informe = client.informe();
		
		String esperado = "Informe de lloguers del client Andres (12345789T)\n" + 
						  "\tSkyLine Nissan: 120.0€\n" +
						  "Import a pagar: 120.0€\n" + 
						  "Punts guanyats: 1\n";
		
		Assert.assertEquals(esperado, informe);
	}
	
	@Test
	public void clientAmbUnSolLloguerLuxe() {
		
		//creamos el vehiculo de prueba
		Vehicle coche1 = new Vehicle("Bugatti", "Iberion", Vehicle.LUXE);
		
		
		//creamos las fechas de los alquileres de prueba
		Date fechaLloguer1 = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			fechaLloguer1 = dateFormat.parse("15/7/2018");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//creamos el alquiler de prueba
		Lloguer lloguer1 = new Lloguer(fechaLloguer1, 5);
		
		//le añadimos al alquiler el coche.
		lloguer1.lloga(coche1);
		
		//creamos el cliente de prueba
		Client client = new Client("12345789T", "Andres", "669 23 55 76");
		
		//le añadimos al cliente el alquiler.
		client.afegeix(lloguer1);
		
		//pedimos el informe del cliente.
		String informe = client.informe();
		
		String esperado = "Informe de lloguers del client Andres (12345789T)\n" + 
						  "\tIberion Bugatti: 900.0€\n" +
						  "Import a pagar: 900.0€\n" + 
						  "Punts guanyats: 2\n";
		
		Assert.assertEquals(esperado, informe);
	}
	
	
	@Test
	public void clientAmbUnSolLloguerLuxeAmbPocsDies() {
		
		//creamos el vehiculo de prueba
		Vehicle coche1 = new Vehicle("Bugatti", "Iberion", Vehicle.LUXE);
		
		
		//creamos las fechas de los alquileres de prueba
		Date fechaLloguer1 = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			fechaLloguer1 = dateFormat.parse("15/7/2018");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//creamos el alquiler de prueba
		Lloguer lloguer1 = new Lloguer(fechaLloguer1, 1);
		
		//le añadimos al alquiler el coche.
		lloguer1.lloga(coche1);
		
		//creamos el cliente de prueba
		Client client = new Client("12345789T", "Andres", "669 23 55 76");
		
		//le añadimos al cliente el alquiler.
		client.afegeix(lloguer1);
		
		//pedimos el informe del cliente.
		String informe = client.informe();
		
		String esperado = "Informe de lloguers del client Andres (12345789T)\n" + 
						  "\tIberion Bugatti: 180.0€\n" +
						  "Import a pagar: 180.0€\n" + 
						  "Punts guanyats: 1\n";
		
		Assert.assertEquals(esperado, informe);
	}
	
	@Test
	public void informeCompleto() {
		
		//creamos el vehiculo de prueba
		Vehicle coche1 = new Vehicle("Volkswagen", "Polo", Vehicle.BASIC);
		Vehicle coche2 = new Vehicle("Nissan", "SkyLine", Vehicle.GENERAL);
		Vehicle coche3 = new Vehicle("Bugatti", "Iberion", Vehicle.LUXE);
		
		//creamos las fechas de los alquileres de prueba
		Date fechaLloguer1 = null;
		Date fechaLloguer2 = null;
		Date fechaLloguer3 = null;
		try {
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("d/M/yyyy");
			fechaLloguer1 = dateFormat1.parse("24/5/2009");
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("d/M/yyyy");
			fechaLloguer2 = dateFormat2.parse("10/6/2012");
			SimpleDateFormat dateFormat3 = new SimpleDateFormat("d/M/yyyy");
			fechaLloguer3 = dateFormat3.parse("15/7/2018");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//creamos el alquiler de prueba
		Lloguer lloguer1 = new Lloguer(fechaLloguer1, 130);
		Lloguer lloguer2 = new Lloguer(fechaLloguer2, 60);
		Lloguer lloguer3 = new Lloguer(fechaLloguer3, 3);
		
		//le añadimos al alquiler el coche.
		lloguer1.lloga(coche1);
		lloguer2.lloga(coche2);
		lloguer3.lloga(coche3);
		
		//creamos el cliente de prueba
		Client client = new Client("12345789T", "Andres", "669 23 55 76");
		
		//le añadimos al cliente el alquiler.
		client.afegeix(lloguer1);
		client.afegeix(lloguer2);
		client.afegeix(lloguer3);
		
		//pedimos el informe del cliente.
		String informe = client.informe();
		
		String esperado = "Informe de lloguers del client Andres (12345789T)\n" + 
						  "\tPolo Volkswagen: 5805.0€\n" +
						  "\tSkyLine Nissan: 4470.0€\n" +
						  "\tIberion Bugatti: 540.0€\n" +
						  "Import a pagar: 10815.0€\n" + 
						  "Punts guanyats: 4\n";
		
		Assert.assertEquals(esperado, informe);
	}
	
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TestPunt");
    }
}
