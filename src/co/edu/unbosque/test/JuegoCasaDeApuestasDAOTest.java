package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.JuegoCasaDeApuestasDTO;
import co.edu.unbosque.model.persistence.JuegoCasaDeApuestasDAO;

public class JuegoCasaDeApuestasDAOTest {
	private JuegoCasaDeApuestasDAO juegoCasaDeApuestasDAO;

	@Before
	public void setUp() {
		juegoCasaDeApuestasDAO = new JuegoCasaDeApuestasDAO();
	}

	@Test
	public void createAndReadTest() {
		juegoCasaDeApuestasDAO.create("Sede1", "3", "100000.0", "Address1", "5", "Game1", "Type1", "5000.0");
		String juegoCasaDeApuestasList = juegoCasaDeApuestasDAO.read();
		assertTrue(juegoCasaDeApuestasList.contains("Sede1"));
		assertTrue(juegoCasaDeApuestasList.contains("3"));
		assertTrue(juegoCasaDeApuestasList.contains("100000.0"));
		assertTrue(juegoCasaDeApuestasList.contains("Address1"));
		assertTrue(juegoCasaDeApuestasList.contains("5"));
		assertTrue(juegoCasaDeApuestasList.contains("Game1"));
		assertTrue(juegoCasaDeApuestasList.contains("Type1"));
		assertTrue(juegoCasaDeApuestasList.contains("5000.0"));
	}

	@Test
	public void updateTest() {
		juegoCasaDeApuestasDAO.create("Sede1", "3", "100000.0", "Address1", "5", "Game1", "Type1", "5000.0");

		assertTrue(juegoCasaDeApuestasDAO.update(0, "SedeActualizada", "5", "150000.0", "AddressActualizada", "10",
				"GameActualizado", "TypeActualizado", "7000.0"));

		assertEquals("SedeActualizada", juegoCasaDeApuestasDAO.getListOfGames().get(0).getBookMarkerName());
		assertEquals(5, juegoCasaDeApuestasDAO.getListOfGames().get(0).getNumberOfLocations());
		assertEquals(150000.0, juegoCasaDeApuestasDAO.getListOfGames().get(0).getTotalBudgetAvailable(), 0.001);
		assertEquals("AddressActualizada", juegoCasaDeApuestasDAO.getListOfGames().get(0).getAddress());
		assertEquals(10, juegoCasaDeApuestasDAO.getListOfGames().get(0).getNumberOfEmployees());
		assertEquals("GameActualizado", juegoCasaDeApuestasDAO.getListOfGames().get(0).getGameName());
		assertEquals("TypeActualizado", juegoCasaDeApuestasDAO.getListOfGames().get(0).getTypeOfGame());
		assertEquals(7000.0, juegoCasaDeApuestasDAO.getListOfGames().get(0).getBudgetAllocated(), 0.001);
	}

	@Test
	public void deleteTest() {
		juegoCasaDeApuestasDAO.create("Sede1", "3", "100000.0", "Address1", "5", "Game1", "Type1", "5000.0");
		assertTrue(juegoCasaDeApuestasDAO.delete(0));
		assertFalse(juegoCasaDeApuestasDAO.getListOfGames()
				.contains(new JuegoCasaDeApuestasDTO("Sede1", 3, 100000.0, "Address1", 5, "Game1", "Type1", 5000.0)));
	}
}
