package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaBetPlayDAO;

public class ApuestaBetPlayDAOTest {
	private ApuestaBetPlayDAO apuestaBetPlayDAO;

	@Before
	public void setUp() {
		apuestaBetPlayDAO = new ApuestaBetPlayDAO();
	}

	@After
	@Test
	public void createAndReadTest() {
		apuestaBetPlayDAO.create("oficina1", "123456789", "lunes", "50000.0", "G2", "fnatic", "Win");
		assertEquals("oficina1", apuestaBetPlayDAO.getListOfBets().get(0).getBookmakerOffice());
		assertEquals(123456789, apuestaBetPlayDAO.getListOfBets().get(0).getIdentification());
		assertEquals("lunes", apuestaBetPlayDAO.getListOfBets().get(0).getDayOfTheWeek());
		assertEquals(50000.0, apuestaBetPlayDAO.getListOfBets().get(0).getValueOfTheBet(), 0.001);
		assertEquals("G2", apuestaBetPlayDAO.getListOfBets().get(0).getTeamOne());
		assertEquals("fnatic", apuestaBetPlayDAO.getListOfBets().get(0).getTeamTwo());
		assertEquals("Win", apuestaBetPlayDAO.getListOfBets().get(0).getResultBet());
		apuestaBetPlayDAO.getListOfBets().clear();
	}

	@Test
	public void updateTest() {
		apuestaBetPlayDAO.create("oficina1", "123456789", "lunes", "50000.0", "G2", "fnatic", "Win");

		assertTrue(
				apuestaBetPlayDAO.update(0, "oficina2", "987654321", "martes", "75000.0", "Excel", "vitality", "Loss"));

		assertEquals("oficina2", apuestaBetPlayDAO.getListOfBets().get(0).getBookmakerOffice());
		assertEquals(987654321, apuestaBetPlayDAO.getListOfBets().get(0).getIdentification());
		assertEquals("martes", apuestaBetPlayDAO.getListOfBets().get(0).getDayOfTheWeek());
		assertEquals(75000.0, apuestaBetPlayDAO.getListOfBets().get(0).getValueOfTheBet(), 0.001);
		assertEquals("Excel", apuestaBetPlayDAO.getListOfBets().get(0).getTeamOne());
		assertEquals("vitality", apuestaBetPlayDAO.getListOfBets().get(0).getTeamTwo());
		assertEquals("Loss", apuestaBetPlayDAO.getListOfBets().get(0).getResultBet());
		apuestaBetPlayDAO.getListOfBets().clear();
	}

	@Test
	public void deleteTest() {
		apuestaBetPlayDAO.create("oficina", "123456789", "Monday", "50000.0", "gambit", "cloud9", "Win");
		assertTrue(apuestaBetPlayDAO.delete(0));
	}
}
