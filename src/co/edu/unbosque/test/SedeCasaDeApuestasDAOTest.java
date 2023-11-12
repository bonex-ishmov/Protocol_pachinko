package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.SedeCasaDeApuestasDTO;
import co.edu.unbosque.model.persistence.SedeCasaDeApuestasDAO;

public class SedeCasaDeApuestasDAOTest {
	private SedeCasaDeApuestasDAO sedeCasaDeApuestasDAO;

	@Before
	public void setUp() {
		sedeCasaDeApuestasDAO = new SedeCasaDeApuestasDAO();
	}

	@Test
	public void createAndReadTest() {
		sedeCasaDeApuestasDAO.create("Sede1", "3", "100000.0", "Address1", "5");
		String sedeCasaDeApuestasList = sedeCasaDeApuestasDAO.read();
		assertTrue(sedeCasaDeApuestasList.contains("Sede1"));
		assertTrue(sedeCasaDeApuestasList.contains("3"));
		assertTrue(sedeCasaDeApuestasList.contains("100000.0"));
		assertTrue(sedeCasaDeApuestasList.contains("Address1"));
		assertTrue(sedeCasaDeApuestasList.contains("5"));
	}

	@Test
	public void updateTest() {
		sedeCasaDeApuestasDAO.create("Sede1", "3", "100000.0", "Address1", "5");

		assertTrue(sedeCasaDeApuestasDAO.update(0, "SedeActualizada", "5", "150000.0", "AddressActualizada", "10"));

		assertEquals("SedeActualizada", sedeCasaDeApuestasDAO.getListOfLocations().get(0).getBookMarkerName());
		assertEquals(5, sedeCasaDeApuestasDAO.getListOfLocations().get(0).getNumberOfLocations());
		assertEquals(150000.0, sedeCasaDeApuestasDAO.getListOfLocations().get(0).getTotalBudgetAvailable(), 0.001);
		assertEquals("AddressActualizada", sedeCasaDeApuestasDAO.getListOfLocations().get(0).getAddress());
		assertEquals(10, sedeCasaDeApuestasDAO.getListOfLocations().get(0).getNumberOfEmployees());
	}

	@Test
	public void deleteTest() {
		sedeCasaDeApuestasDAO.create("Sede1", "3", "100000.0", "Address1", "5");
		assertTrue(sedeCasaDeApuestasDAO.delete(0));
		assertFalse(sedeCasaDeApuestasDAO.getListOfLocations()
				.contains(new SedeCasaDeApuestasDTO("Sede1", 3, 100000.0, "Address1", 5)));
	}
}
