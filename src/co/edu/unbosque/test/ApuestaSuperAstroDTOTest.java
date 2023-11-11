package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.edu.unbosque.model.ApuestaSuperAstroDTO;

public class ApuestaSuperAstroDTOTest {

	@Test
	public void testConstructorPorDefecto() {
		ApuestaSuperAstroDTO apuesta = new ApuestaSuperAstroDTO();

		assertEquals(null, apuesta.getBookmakerOffice());
		assertEquals(0L, apuesta.getIdentification());
		assertEquals(null, apuesta.getDayOfTheWeek());
		assertEquals(0.0, apuesta.getValueOfTheBet(), 0.001);

		assertEquals(null, apuesta.getZodiacSign());
	}

	@Test
	public void testConstructorParametrizado() {
		int[] fourNumbers = new int[] { 1, 2, 3, 4 };
		String zodiacSign = "Acuario";
		ApuestaSuperAstroDTO apuesta = new ApuestaSuperAstroDTO(fourNumbers, zodiacSign);

		assertEquals(null, apuesta.getBookmakerOffice());
		assertEquals(0L, apuesta.getIdentification());
		assertEquals(null, apuesta.getDayOfTheWeek());
		assertEquals(0.0, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(fourNumbers, apuesta.getFourNumbers());
		assertEquals(zodiacSign, apuesta.getZodiacSign());
	}

	@Test
	public void testConstructorParametrizadoCompleto() {
		String bookmakerOffice = "Casa de Apuestas 1";
		long identification = 1234567890L;
		String dayOfTheWeek = "Lunes";
		double valueOfTheBet = 10000.0;
		int[] fourNumbers = new int[] { 1, 2, 3, 4 };
		String zodiacSign = "Acuario";
		ApuestaSuperAstroDTO apuesta = new ApuestaSuperAstroDTO(bookmakerOffice, identification, dayOfTheWeek,
				valueOfTheBet, fourNumbers, zodiacSign);

		assertEquals(bookmakerOffice, apuesta.getBookmakerOffice());
		assertEquals(identification, apuesta.getIdentification());
		assertEquals(dayOfTheWeek, apuesta.getDayOfTheWeek());
		assertEquals(valueOfTheBet, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(fourNumbers, apuesta.getFourNumbers());
		assertEquals(zodiacSign, apuesta.getZodiacSign());
	}
}