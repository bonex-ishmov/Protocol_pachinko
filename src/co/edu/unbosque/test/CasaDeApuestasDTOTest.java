package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.edu.unbosque.model.CasaDeApuestasDTO;

public class CasaDeApuestasDTOTest {

	@Test
	public void testConstructorPorDefecto() {
		CasaDeApuestasDTO casaDeApuestas = new CasaDeApuestasDTO();

		assertEquals(null, casaDeApuestas.getBookMarkerName());
		assertEquals(0, casaDeApuestas.getNumberOfLocations());
		assertEquals(0.0, casaDeApuestas.getTotalBudgetAvailable(), 0.001);
	}

	@Test
	public void testConstructorParametrizado() {
		String bookMarkerName = "Casa de Apuestas 1";
		int numberOfLocations = 10;
		double totalBudgetAvailable = 1000000.0;
		CasaDeApuestasDTO casaDeApuestas = new CasaDeApuestasDTO(bookMarkerName, numberOfLocations,
				totalBudgetAvailable);

		assertEquals(bookMarkerName, casaDeApuestas.getBookMarkerName());
		assertEquals(numberOfLocations, casaDeApuestas.getNumberOfLocations());
		assertEquals(totalBudgetAvailable, casaDeApuestas.getTotalBudgetAvailable(), 0.001);
	}

}