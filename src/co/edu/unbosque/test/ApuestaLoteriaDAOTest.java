package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaLoteriaDAO;

public class ApuestaLoteriaDAOTest {
	private ApuestaLoteriaDAO apuestaLoteriaDAO;

	@Before
	public void setUp() {
		apuestaLoteriaDAO = new ApuestaLoteriaDAO();
	}

	@After
	@Test
	public void createAndReadTest() {
		apuestaLoteriaDAO.create("oficinax", "123456789", "lunes", "50000.0", "LottoX", "1 2 3 4", "SerieA");

		assertEquals("oficinax", apuestaLoteriaDAO.getListOfBets().get(0).getBookmakerOffice());
		assertEquals(123456789, apuestaLoteriaDAO.getListOfBets().get(0).getIdentification());
		assertEquals("lunes", apuestaLoteriaDAO.getListOfBets().get(0).getDayOfTheWeek());
		assertEquals(50000.0, apuestaLoteriaDAO.getListOfBets().get(0).getValueOfTheBet(), 0.001);
		assertEquals("LottoX", apuestaLoteriaDAO.getListOfBets().get(0).getLotteryName());
		// assertEquals("1 2 3 4",
		// apuestaLoteriaDAO.getListOfBets().get(0).getFourNumbers());
		assertEquals("SerieA", apuestaLoteriaDAO.getListOfBets().get(0).getSeries());
		apuestaLoteriaDAO.getListOfBets().clear();
	}

	@Test
	public void updateTest() {
		apuestaLoteriaDAO.create("oficinax", "123456789", "martes", "50000.0", "loteriax", "1 2 3 4", "SerieA");

		assertTrue(apuestaLoteriaDAO.update(0, "nuevaoficina", "987654321", "miercoles", "75000.0", "loteriaxd",
				"5 6 7 8", "SerieB"));

		assertEquals("nuevaoficina", apuestaLoteriaDAO.getListOfBets().get(0).getBookmakerOffice());
		assertEquals(987654321, apuestaLoteriaDAO.getListOfBets().get(0).getIdentification());
		assertEquals("miercoles", apuestaLoteriaDAO.getListOfBets().get(0).getDayOfTheWeek());
		assertEquals(75000.0, apuestaLoteriaDAO.getListOfBets().get(0).getValueOfTheBet(), 0.001);
		assertEquals("loteriaxd", apuestaLoteriaDAO.getListOfBets().get(0).getLotteryName());
		// assertEquals("5 6 7 8",
		// apuestaLoteriaDAO.getListOfBets().get(0).getFourNumbers());
		assertEquals("SerieB", apuestaLoteriaDAO.getListOfBets().get(0).getSeries());
		apuestaLoteriaDAO.getListOfBets().clear();
	}

	@Test
	public void deleteTest() {
		apuestaLoteriaDAO.create("Office1", "123456789", "Monday", "50000.0", "LottoX", "1 2 3 4", "SeriesA");

		assertTrue(apuestaLoteriaDAO.delete(0));
	}
}
