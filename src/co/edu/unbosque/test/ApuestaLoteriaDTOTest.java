package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.edu.unbosque.model.ApuestaLoteriaDTO;

public class ApuestaLoteriaDTOTest {

	@Test
	public void testConstructorPorDefecto() {
		ApuestaLoteriaDTO apuesta = new ApuestaLoteriaDTO();

		assertEquals(null, apuesta.getBookmakerOffice());
		assertEquals(0L, apuesta.getIdentification());
		assertEquals(null, apuesta.getDayOfTheWeek());
		assertEquals(0.0, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(null, apuesta.getLotteryName());

		assertEquals(null, apuesta.getSeries());
	}

	@Test
	public void testConstructorParametrizado() {
		String lotteryName = "La Lotería";
		int[] fourNumbers = new int[] { 1, 2, 3, 4 };
		String series = "1234";
		ApuestaLoteriaDTO apuesta = new ApuestaLoteriaDTO(lotteryName, fourNumbers, series);

		assertEquals(null, apuesta.getBookmakerOffice());
		assertEquals(0L, apuesta.getIdentification());
		assertEquals(null, apuesta.getDayOfTheWeek());
		assertEquals(0.0, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(lotteryName, apuesta.getLotteryName());
		assertEquals(fourNumbers, apuesta.getFourNumbers());
		assertEquals(series, apuesta.getSeries());
	}

	@Test
	public void testConstructorParametrizadoCompleto() {
		String bookmakerOffice = "Casa de Apuestas 1";
		long identification = 1234567890L;
		String dayOfTheWeek = "Lunes";
		double valueOfTheBet = 10000.0;
		String lotteryName = "La Lotería";
		int[] fourNumbers = new int[] { 1, 2, 3, 4 };
		String series = "1234";
		ApuestaLoteriaDTO apuesta = new ApuestaLoteriaDTO(bookmakerOffice, identification, dayOfTheWeek, valueOfTheBet,
				lotteryName, fourNumbers, series);

		assertEquals(bookmakerOffice, apuesta.getBookmakerOffice());
		assertEquals(identification, apuesta.getIdentification());
		assertEquals(dayOfTheWeek, apuesta.getDayOfTheWeek());
		assertEquals(valueOfTheBet, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(lotteryName, apuesta.getLotteryName());
		assertEquals(fourNumbers, apuesta.getFourNumbers());
		assertEquals(series, apuesta.getSeries());
	}
}