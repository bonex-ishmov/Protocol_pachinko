package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.ApuestaDTO;
import co.edu.unbosque.model.persistence.ApuestaDAO;

public class ApuestaDAOTest {
	static private ApuestaDAO apuestaDAO;

	@Before
	public void setUp() {
		apuestaDAO = new ApuestaDAO();
	}

	@Test
	public void testCreateAndRead() {
		// Prueba de creación y lectura
		apuestaDAO.create("Oficina1", "123456789", "2023-11-15", "100.50");
		String result = apuestaDAO.read();
		System.out.println(result);

	}

	@Test
	public void testUpdate() {
		// Prueba de actualización
		apuestaDAO.create("Oficina2", "987654321", "2023-11-16", "150.75");
		apuestaDAO.update(0, "NuevaOficina", "111222333", "2023-11-17", "200.25");
		ApuestaDTO updatedBet = apuestaDAO.getListOfBets().get(0);
		assertEquals("NuevaOficina", updatedBet.getBookmakerOffice());
		assertEquals(111222333, updatedBet.getIdentification());
		assertEquals("2023-11-17", updatedBet.getDayOfTheWeek());
		assertEquals(200.25, updatedBet.getValueOfTheBet(), 0.001);
	}

	@Test
	public void testDelete() {
		// Prueba de eliminación
		apuestaDAO.create("Oficina3", "555666777", "2023-11-18", "75.25");
		apuestaDAO.delete(0);
		assertEquals(true, apuestaDAO.delete(0));
	}
}
