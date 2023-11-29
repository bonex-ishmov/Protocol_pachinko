package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.edu.unbosque.model.SedeCasaDeApuestasDTO;

public class SedeCasaDeApuestasDTOTest {

	@Test
	public void testConstructorPorDefecto() {
		SedeCasaDeApuestasDTO sede = new SedeCasaDeApuestasDTO();

		assertEquals(null, sede.getAddress());
		assertEquals(0, sede.getNumberOfEmployees());
	}

	@Test
	public void testConstructorParametrizado() {
		String address = "Calle 123 # 45-67";
		int numberOfEmployees = 10;
		SedeCasaDeApuestasDTO sede = new SedeCasaDeApuestasDTO(address, numberOfEmployees);

		assertEquals(address, sede.getAddress());
		assertEquals(numberOfEmployees, sede.getNumberOfEmployees());
	}

	@Test
	public void testConstructorConSedeCasaDeApuestas() {
		String bookMarkerName = "Casa de Apuestas 1";
		int numberOfLocations = 10;
		double totalBudgetAvailable = 1000000.0;
		SedeCasaDeApuestasDTO sede = new SedeCasaDeApuestasDTO(bookMarkerName, numberOfLocations, totalBudgetAvailable);

		assertEquals(bookMarkerName, sede.getBookMarkerName());
		assertEquals(numberOfLocations, sede.getNumberOfLocations());
		assertEquals(totalBudgetAvailable, sede.getTotalBudgetAvailable(), 0.001);
		assertEquals(null, sede.getAddress());
		assertEquals(0, sede.getNumberOfEmployees());
	}

	@Test
	public void testConstructorConSedeCasaDeApuestas1() {
		String bookMarkerName = "Casa de Apuestas 1";
		int numberOfLocations = 10;
		double totalBudgetAvailable = 1000000.0;
		String gameName = "Lotería";
		String typeOfGame = "Azar";
		SedeCasaDeApuestasDTO sede = new SedeCasaDeApuestasDTO(bookMarkerName, numberOfLocations, totalBudgetAvailable);

		assertEquals(bookMarkerName, sede.getBookMarkerName());
		assertEquals(numberOfLocations, sede.getNumberOfLocations());
		assertEquals(totalBudgetAvailable, sede.getTotalBudgetAvailable(), 0.001);

	}

}