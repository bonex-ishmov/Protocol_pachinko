package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.edu.unbosque.model.ApuestaDTO;

public class ApuestaDTOTest {

	@Test
	public void testConstructorPorDefecto() {
		ApuestaDTO apuesta = new ApuestaDTO();

		assertEquals(null, apuesta.getBookmakerOffice());
		assertEquals(0, apuesta.getIdentification());
		assertEquals(null, apuesta.getDayOfTheWeek());
		assertEquals(0, apuesta.getValueOfTheBet(), 0.001);
	}

	@Test
	public void testConstructorParametrizado() {
		ApuestaDTO apuesta = new ApuestaDTO("Casa de Apuestas 1", 12345678L, "Lunes", 10000.0f);

		assertEquals("Casa de Apuestas 1", apuesta.getBookmakerOffice());
		assertEquals(12345678L, apuesta.getIdentification());
		assertEquals("Lunes", apuesta.getDayOfTheWeek());
		assertEquals(10000.0f, apuesta.getValueOfTheBet(), 0.001);
	}

	@Test
	public void testSettersYGetters() {
		ApuestaDTO apuesta = new ApuestaDTO();

		apuesta.setBookmakerOffice("Casa de Apuestas 2");
		apuesta.setIdentification(98765432L);
		apuesta.setDayOfTheWeek("Martes");
		apuesta.setValueOfTheBet(20000.0f);

		assertEquals("Casa de Apuestas 2", apuesta.getBookmakerOffice());
		assertEquals(98765432L, apuesta.getIdentification());
		assertEquals("Martes", apuesta.getDayOfTheWeek());
		assertEquals(20000.0, apuesta.getValueOfTheBet(), 0.001);
	}

	@Test
	public void testToString() {
		ApuestaDTO apuesta = new ApuestaDTO("Casa de Apuestas 3", 765432109L, "Miércoles", 30000.0);

		String expectedString = "ApuestaDTO [bookmakerOffice=Casa de Apuestas 3, identification=765432109, dayOfTheWeek=Miércoles, valueOfTheBet=30000.0]";

		assertEquals(expectedString, apuesta.toString());
	}
}