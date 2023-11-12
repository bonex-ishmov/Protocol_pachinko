package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.CasaDeApuestasDTO;
import co.edu.unbosque.model.persistence.CasaDeApuestasDAO;

public class CasaDeApuestasDAOTest {

	private CasaDeApuestasDAO casaDeApuestasDAO;

	@Before
	public void setUp() {
		casaDeApuestasDAO = new CasaDeApuestasDAO();
	}

	@Test
	public void createAndReadTest() {
		casaDeApuestasDAO.create("Casa1", "3", "100000.0");
		String casaDeApuestasList = casaDeApuestasDAO.read();
		assertTrue(casaDeApuestasList.contains("Casa1"));
		assertTrue(casaDeApuestasList.contains("3"));
		assertTrue(casaDeApuestasList.contains("100000.0"));
	}

	@Test
	public void updateTest() {
		casaDeApuestasDAO.create("Casa1", "3", "100000.0");

		assertTrue(casaDeApuestasDAO.update(0, "CasaActualizada", "5", "150000.0"));

		assertEquals("CasaActualizada", casaDeApuestasDAO.getListOfHouses().get(0).getBookMarkerName());
		assertEquals(5, casaDeApuestasDAO.getListOfHouses().get(0).getNumberOfLocations());
		assertEquals(150000.0, casaDeApuestasDAO.getListOfHouses().get(0).getTotalBudgetAvailable(), 0.001);
	}

	@Test
	public void deleteTest() {
		casaDeApuestasDAO.create("Casa1", "3", "100000.0");
		assertTrue(casaDeApuestasDAO.delete(0));
		assertFalse(casaDeApuestasDAO.getListOfHouses().contains(new CasaDeApuestasDTO("Casa1", 3, 100000.0)));
	}
}
