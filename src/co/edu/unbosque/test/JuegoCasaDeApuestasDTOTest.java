package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.edu.unbosque.model.JuegoCasaDeApuestasDTO;

public class JuegoCasaDeApuestasDTOTest {

	@Test
	public void testConstructorPorDefecto() {
		JuegoCasaDeApuestasDTO juego = new JuegoCasaDeApuestasDTO();

		assertEquals(null, juego.getGameName());
		assertEquals(null, juego.getTypeOfGame());
		assertEquals(0.0, juego.getBudgetAllocated(), 0.001);
	}

	@Test
	public void testConstructorParametrizado() {
		String gameName = "Lotería";
		String typeOfGame = "Azar";
		double budgetAllocated = 100000.0;
		JuegoCasaDeApuestasDTO juego = new JuegoCasaDeApuestasDTO(gameName, typeOfGame, budgetAllocated);

		assertEquals(gameName, juego.getGameName());
		assertEquals(typeOfGame, juego.getTypeOfGame());
		assertEquals(budgetAllocated, juego.getBudgetAllocated(), 0.001);
	}

	@Test
	public void testConstructorConSedeCasaDeApuestas() {
		String bookMarkerName = "Casa de Apuestas 1";
		int numberOfLocations = 10;
		double totalBudgetAvailable = 1000000.0;
		JuegoCasaDeApuestasDTO juego = new JuegoCasaDeApuestasDTO(bookMarkerName, numberOfLocations,
				totalBudgetAvailable);

		assertEquals(bookMarkerName, juego.getBookMarkerName());
		assertEquals(numberOfLocations, juego.getNumberOfLocations());
		assertEquals(totalBudgetAvailable, juego.getTotalBudgetAvailable(), 0.001);
		assertEquals(null, juego.getGameName());
		assertEquals(null, juego.getTypeOfGame());
		assertEquals(0.0, juego.getBudgetAllocated(), 0.001);
	}

	@Test
	public void testConstructorConNombreJuegoYTipoJuego() {
		String gameName = "Lotería";
		String typeOfGame = "Azar";
		JuegoCasaDeApuestasDTO juego = new JuegoCasaDeApuestasDTO(gameName, typeOfGame, 0);

		assertEquals(gameName, juego.getGameName());
		assertEquals(typeOfGame, juego.getTypeOfGame());
		assertEquals(0.0, juego.getBudgetAllocated(), 0.001);
	}

	@Test
	public void testConstructorConSedeCasaDeApuestasNombreJuegoYTipoJuego() {
		String bookMarkerName = "Casa de Apuestas 1";
		int numberOfLocations = 10;
		double totalBudgetAvailable = 1000000.0;
		String gameName = "Lotería";
		String typeOfGame = "Azar";
		JuegoCasaDeApuestasDTO juego = new JuegoCasaDeApuestasDTO(bookMarkerName, numberOfLocations,
				totalBudgetAvailable, gameName, typeOfGame, 0);

		assertEquals(bookMarkerName, juego.getBookMarkerName());
		assertEquals(numberOfLocations, juego.getNumberOfLocations());
		assertEquals(totalBudgetAvailable, juego.getTotalBudgetAvailable(), 0.001);
		assertEquals(gameName, juego.getGameName());
		assertEquals(typeOfGame, juego.getTypeOfGame());
	}
}