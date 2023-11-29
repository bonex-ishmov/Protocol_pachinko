package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.edu.unbosque.model.ApuestaChanceDTO;

public class ApuestaChanceDTOTest {

	@Test
	public void testConstructorPorDefecto() {
		ApuestaChanceDTO apuesta = new ApuestaChanceDTO();

		assertEquals(null, apuesta.getBookmakerOffice());
		assertEquals(0L, apuesta.getIdentification());
		assertEquals(null, apuesta.getDayOfTheWeek());
		assertEquals(0.0, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(null, apuesta.getLotteryName());
		
	}

	@Test
	public void testConstructorParametrizado() {
		String lotteryName = "La Lotería";
		int[] fourNumbers = new int[] { 1, 2, 3, 4 };
		ApuestaChanceDTO apuesta = new ApuestaChanceDTO(lotteryName, fourNumbers);

		assertEquals(null, apuesta.getBookmakerOffice());
		assertEquals(0L, apuesta.getIdentification());
		assertEquals(null, apuesta.getDayOfTheWeek());
		assertEquals(0.0, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(lotteryName, apuesta.getLotteryName());
		assertEquals(fourNumbers, apuesta.getFourNumbers());
	}

	@Test
	public void testConstructorParametrizadoCompleto() {
		String bookmakerOffice = "Casa de Apuestas 1";
		long identification = 1234567890L;
		String dayOfTheWeek = "Lunes";
		double valueOfTheBet = 10000.0;
		String lotteryName = "La Lotería";
		int[] fourNumbers = new int[] { 1, 2, 3, 4 };
		ApuestaChanceDTO apuesta = new ApuestaChanceDTO(bookmakerOffice, identification, dayOfTheWeek, valueOfTheBet,
				lotteryName, fourNumbers);

		assertEquals(bookmakerOffice, apuesta.getBookmakerOffice());
		assertEquals(identification, apuesta.getIdentification());
		assertEquals(dayOfTheWeek, apuesta.getDayOfTheWeek());
		assertEquals(valueOfTheBet, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(lotteryName, apuesta.getLotteryName());
		assertEquals(fourNumbers, apuesta.getFourNumbers());
	}
}