package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.edu.unbosque.model.ApuestaBalotoDTO;

public class ApuestaBalotoDTOTest {

	@Test
	public void testConstructorPorDefecto() {
		ApuestaBalotoDTO apuesta = new ApuestaBalotoDTO();

		assertEquals(null, apuesta.getBookmakerOffice());
		assertEquals(0, apuesta.getIdentification());
		assertEquals(null, apuesta.getDayOfTheWeek());
		assertEquals(0, apuesta.getValueOfTheBet(), 0.001);
	}

	@Test
	public void testConstructorParametrizado() {
		int[] sixNumbers = new int[] { 1, 2, 3, 4, 5, 6 };
		ApuestaBalotoDTO apuesta = new ApuestaBalotoDTO(sixNumbers);

		assertEquals(null, apuesta.getBookmakerOffice());
		assertEquals(0, apuesta.getIdentification());
		assertEquals(null, apuesta.getDayOfTheWeek());
		assertEquals(0, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(sixNumbers, apuesta.getSixNumbers());
	}

	@Test
	public void testConstructorParametrizadoCompleto() {
		String bookmakerOffice = "Casa de Apuestas 1";
		long identification = 1234567890L;
		String dayOfTheWeek = "Lunes";
		double valueOfTheBet = 10000.0;
		int[] sixNumbers = new int[] { 1, 2, 3, 4, 5, 6 };
		ApuestaBalotoDTO apuesta = new ApuestaBalotoDTO(bookmakerOffice, identification, dayOfTheWeek, valueOfTheBet,
				sixNumbers);

		assertEquals(bookmakerOffice, apuesta.getBookmakerOffice());
		assertEquals(identification, apuesta.getIdentification());
		assertEquals(dayOfTheWeek, apuesta.getDayOfTheWeek());
		assertEquals(valueOfTheBet, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(sixNumbers, apuesta.getSixNumbers());
	}

	@Test
	public void testSettersYGetters() {
		ApuestaBalotoDTO apuesta = new ApuestaBalotoDTO();

		apuesta.setBookmakerOffice("Casa de Apuestas 2");
		apuesta.setIdentification(9876543210L);
		apuesta.setDayOfTheWeek("Martes");
		apuesta.setValueOfTheBet(20000.0);
		int[] sixNumbers = new int[] { 7, 8, 9, 10, 11, 12 };
		apuesta.setSixNumbers(sixNumbers);

		assertEquals("Casa de Apuestas 2", apuesta.getBookmakerOffice());
		assertEquals(9876543210L, apuesta.getIdentification());
		assertEquals("Martes", apuesta.getDayOfTheWeek());
		assertEquals(20000.0, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(sixNumbers, apuesta.getSixNumbers());
	}

}