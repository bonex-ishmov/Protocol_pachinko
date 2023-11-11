package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.edu.unbosque.model.ApostadorDTO;

public class ApostadorDTOTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testConstructorPorDefecto() {
		ApostadorDTO apostador = new ApostadorDTO();

		assertEquals(null, apostador.getCompleteName());
		assertEquals(0, apostador.getIdentification());
		assertEquals(null, apostador.getBirthDate());
		assertEquals(null, apostador.getBookmakerHeadquarters());
		assertEquals(null, apostador.getAddressOfThePerson());
		assertEquals(0, apostador.getPhoneNumber());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testConstructorParametrizado() {
		ApostadorDTO apostador = new ApostadorDTO("Juan Perez", 1234567890, "1990-01-01", "Bogota", "Calle 123 # 45-67",
				315586063);

		assertEquals("Juan Perez", apostador.getCompleteName());
		assertEquals(1234567890, apostador.getIdentification());
		assertEquals("1990-01-01", apostador.getBirthDate());
		assertEquals("Bogota", apostador.getBookmakerHeadquarters());
		assertEquals("Calle 123 # 45-67", apostador.getAddressOfThePerson());
		assertEquals(315586063, apostador.getPhoneNumber());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGettersYSetters() {
		ApostadorDTO apostador = new ApostadorDTO();

		apostador.setCompleteName("Juan Perez");
		apostador.setIdentification(1234567890);
		apostador.setBirthDate("1990-01-01");
		apostador.setBookmakerHeadquarters("Bogotá");
		apostador.setAddressOfThePerson("Calle 123 # 45-67");
		apostador.setPhoneNumber(987654321);

		assertEquals("Juan Perez", apostador.getCompleteName());
		assertEquals(1234567890, apostador.getIdentification());
		assertEquals("1990-01-01", apostador.getBirthDate());
		assertEquals("Bogotá", apostador.getBookmakerHeadquarters());
		assertEquals("Calle 123 # 45-67", apostador.getAddressOfThePerson());
		assertEquals(987654321, apostador.getPhoneNumber());
	}

	@Test
	public void testToString() {
		ApostadorDTO apostador = new ApostadorDTO("Juan Perez", 1234567890, "1990-01-01", "Bogotá", "Calle 123 # 45-67",
				987654321);

		String expectedString = "ApostadoresDTO [completeName=Juan Perez, identification=1234567890, birthDate=1990-01-01, bookmakerHeadquarters=Bogotá, addressOfThePerson=Calle 123 # 45-67, phoneNumber=987654321]";

		assertEquals(expectedString, apostador.toString());
	}
}
