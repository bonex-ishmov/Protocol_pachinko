package co.edu.unbosque.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.ApuestaBalotoDTO;
import co.edu.unbosque.model.persistence.ApuestaBalotoDAO;

public class ApuestaBalotoDAOTest {

	private ApuestaBalotoDAO apuestaBalotoDAO;

	@Before
	public void setUp() {
		apuestaBalotoDAO = new ApuestaBalotoDAO();
	}

	@Test
	public void createAndReadTest() {
		apuestaBalotoDAO.create("ahjebfuhijaefa", "123456789", "lunes", "50000.0", "1 2 3 4 5 6");
		String apuestaBalotoList = apuestaBalotoDAO.read();
		assertTrue(apuestaBalotoList.contains("ahjebfuhijaefa"));
		assertTrue(apuestaBalotoList.contains("123456789"));
		assertTrue(apuestaBalotoList.contains("lunes"));
		assertTrue(apuestaBalotoList.contains("50000.0"));
		apuestaBalotoDAO.getListOfBets().clear();
	}

	@Test
	public void updateTest() {
		apuestaBalotoDAO.create("oficina1", "123456789", "martes", "50000.0", "1 2 3 4 5 6");

		assertTrue(apuestaBalotoDAO.update(0, "oficina2", "987654321", "martes", "75000.0", "7 8 9 10 11 12"));

		assertEquals("oficina2", apuestaBalotoDAO.getListOfBets().get(0).getBookmakerOffice());
		assertEquals(987654321, apuestaBalotoDAO.getListOfBets().get(0).getIdentification());
		assertEquals("martes", apuestaBalotoDAO.getListOfBets().get(0).getDayOfTheWeek());
		assertEquals(75000.0, apuestaBalotoDAO.getListOfBets().get(0).getValueOfTheBet(), 0.001);
		int[] expectedNumbers = new int[] { 7, 8, 9, 10, 11, 12 };
		int[] actualNumbers = apuestaBalotoDAO.getListOfBets().get(0).getSixNumbers();
		assertArrayEquals(expectedNumbers, actualNumbers);
		apuestaBalotoDAO.getListOfBets().clear();
	}

	@Test
	public void deleteTest() {
		apuestaBalotoDAO.create("oficina3", "123456789", "miercoles", "50000.0", "1 2 3 4 5 6");
		assertTrue(apuestaBalotoDAO.delete(0));
		assertFalse(apuestaBalotoDAO.getListOfBets().contains(
				new ApuestaBalotoDTO("oficina3", 123456789, "miercoles", 50000.0, new int[] { 1, 2, 3, 4, 5, 6 })));
	}
}
