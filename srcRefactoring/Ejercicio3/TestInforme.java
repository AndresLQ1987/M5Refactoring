package Ejercicio3;

import java.util.Date;
import org.junit.*;
import Ejercicio3.GestorLloguersLite;

public class TestInforme {
	
	private Vehicle coche1;
	private Lloguer lloguer1;
	private Client client;
	
	@Before
	public void setUp() {
		//creamos el vehiculo de prueba
		coche1 = new Vehicle("Volkswagen", "Polo", Vehicle.BASIC);
				
		//creamos una fecha de prueba
		Date fechaLloguer1 = GestorLloguersLite.createDate("24/5/2009", "d/M/yyyy");
		
		//creamos el alquiler de prueba
		lloguer1 = new Lloguer(fechaLloguer1, 130);
		
		//le añadimos al alquiler el coche.
		lloguer1.lloga(coche1);
		
		//creamos el cliente de prueba
		client = new Client("12345789T", "Andres", "669 23 55 76");
		
		//le añadimos al cliente el alquiler.
		client.afegeix(lloguer1);
	}
	
	@Test
	public void InformeCompleto() {
		
		//pedimos el informe del cliente.
		String informe = client.informe();
		
		String esperado = "Informe de lloguers del client Andres (12345789T)\n" + 
						  "\tPolo Volkswagen: 5805.0€\n" +  
						  "Import a pagar: 5805.0€\n" + 
						  "Punts guanyats: 1\n";
		Assert.assertEquals(esperado, informe);
	}
	
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TestPunt");
    }
}
