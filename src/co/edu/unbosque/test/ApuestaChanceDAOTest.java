package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaChanceDAO;

public class ApuestaChanceDAOTest {

	private ApuestaChanceDAO apuestaChanceDAO;

	@Before
	public void setUp() {
		apuestaChanceDAO = new ApuestaChanceDAO();
	}

	@Test
	public void createAndReadTest() {
		apuestaChanceDAO.getListOfBets().clear();
		apuestaChanceDAO.create("oficinax", "123456789", "lunes", "50000.0", "loteriaRandom", "1 2 3 4");
		System.out.println(apuestaChanceDAO.read());
		assertEquals("oficinax", apuestaChanceDAO.getListOfBets().get(0).getBookmakerOffice());
		assertEquals(123456789, apuestaChanceDAO.getListOfBets().get(0).getIdentification());
		assertEquals("lunes", apuestaChanceDAO.getListOfBets().get(0).getDayOfTheWeek());
		assertEquals(50000.0, apuestaChanceDAO.getListOfBets().get(0).getValueOfTheBet(), 0.001);
		assertEquals("loteriaRandom", apuestaChanceDAO.getListOfBets().get(0).getLotteryName());
		apuestaChanceDAO.getListOfBets().clear();

	}

	@Test
	public void updateTest() {
		apuestaChanceDAO.getListOfBets().clear();
		apuestaChanceDAO.create("oficinax", "123456789", "martes", "50000.0", "LotteryX", "1 2 3 4");
		assertTrue(apuestaChanceDAO.update(0, "oficinanueva", "987654321", "miercoles", "75000.0", "loetriaxd",
				"5 6 7 8"));

		assertEquals("oficinanueva", apuestaChanceDAO.getListOfBets().get(0).getBookmakerOffice());
		assertEquals(987654321, apuestaChanceDAO.getListOfBets().get(0).getIdentification());
		assertEquals("miercoles", apuestaChanceDAO.getListOfBets().get(0).getDayOfTheWeek());
		assertEquals(75000.0, apuestaChanceDAO.getListOfBets().get(0).getValueOfTheBet(), 0.001);
		assertEquals("loetriaxd", apuestaChanceDAO.getListOfBets().get(0).getLotteryName());
		apuestaChanceDAO.getListOfBets().clear();
	}

	@Test
	public void deleteTest() {
		apuestaChanceDAO.getListOfBets().clear();
		apuestaChanceDAO.create("oficinaxd", "123456789", "lunes", "50000.0", "LotteryX", "1 2 3 4");
		assertTrue(apuestaChanceDAO.delete(0));
	}

}
