package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaSuperAstroDAO;

public class ApuestaSuperAstroDAOTest {

	private ApuestaSuperAstroDAO apuestaSuperAstroDAO;

	@Before
	public void setUp() {
		apuestaSuperAstroDAO = new ApuestaSuperAstroDAO();
	}

	@Test
	public void createAndReadTest() {
		apuestaSuperAstroDAO.getListOfBets().clear();
		apuestaSuperAstroDAO.create("Office1", "123456789", "Monday", "50000.0", "1 2 3 4", "Leo");
		assertEquals("Office1", apuestaSuperAstroDAO.getListOfBets().get(0).getBookmakerOffice());
		assertEquals(123456789, apuestaSuperAstroDAO.getListOfBets().get(0).getIdentification());
		assertEquals("Monday", apuestaSuperAstroDAO.getListOfBets().get(0).getDayOfTheWeek());
		assertEquals(50000.0, apuestaSuperAstroDAO.getListOfBets().get(0).getValueOfTheBet(), 0.001);
		// assertEquals("1 2 3 4",
		// apuestaSuperAstroDAO.getListOfBets().get(0).getFourNumbers());
		assertEquals("Leo", apuestaSuperAstroDAO.getListOfBets().get(0).getZodiacSign());
		apuestaSuperAstroDAO.getListOfBets().clear();
	}

	@Test
	public void updateTest() {
		apuestaSuperAstroDAO.getListOfBets().clear();
		apuestaSuperAstroDAO.create("Office1", "123456789", "Monday", "50000.0", "1 2 3 4", "Leo");
		assertTrue(
				apuestaSuperAstroDAO.update(0, "OfficeUpdated", "987654321", "Tuesday", "75000.0", "5 6 7 8", "Virgo"));
		assertEquals("OfficeUpdated", apuestaSuperAstroDAO.getListOfBets().get(0).getBookmakerOffice());
		assertEquals(987654321, apuestaSuperAstroDAO.getListOfBets().get(0).getIdentification());
		assertEquals("Tuesday", apuestaSuperAstroDAO.getListOfBets().get(0).getDayOfTheWeek());
		assertEquals(75000.0, apuestaSuperAstroDAO.getListOfBets().get(0).getValueOfTheBet(), 0.001);
		// assertEquals("5 6 7 8",
		// apuestaSuperAstroDAO.getListOfBets().get(0).getFourNumbers());
		assertEquals("Virgo", apuestaSuperAstroDAO.getListOfBets().get(0).getZodiacSign());
		apuestaSuperAstroDAO.getListOfBets().clear();
	}

	@Test
	public void deleteTest() {
		apuestaSuperAstroDAO.getListOfBets().clear();
		apuestaSuperAstroDAO.create("Office1", "123456789", "Monday", "50000.0", "1 2 3 4", "Leo");

		assertTrue(apuestaSuperAstroDAO.delete(0));
	}
}
