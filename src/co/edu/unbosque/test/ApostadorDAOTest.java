package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApostadorDAO;

public class ApostadorDAOTest {

	static private ApostadorDAO apostadorDAO;

	@Before
	public void setUp() {
		apostadorDAO = new ApostadorDAO();
	}

	@Test
	public void createAndReadTest() {

		apostadorDAO.create("awfef", "123456789", "1990-01-01", "Headquthsthtarters", "dhdjdytj", "987654321");
		System.out.println(apostadorDAO.read());
	}

	@Test
	public void updateTest() {

		String name = "roberto duran";
		long Id = 3456789L;
		String birth = "1994-05-09";
		String place = "gameland";
		String adress = "avenida cero";
		long phone = 456778L;
		apostadorDAO.create("John Doe", "123456789", "1990-01-01", "Headquarters", "123 Main St", "987654321");
		apostadorDAO.update(0, name, String.valueOf(Id), birth, place, adress, String.valueOf(phone));
		assertEquals(name, apostadorDAO.getListOfGamblers().get(0).getCompleteName());
		assertEquals(Id, apostadorDAO.getListOfGamblers().get(0).getIdentification());
		assertEquals(birth, apostadorDAO.getListOfGamblers().get(0).getBirthDate());
		assertEquals(place, apostadorDAO.getListOfGamblers().get(0).getBookmakerHeadquarters());
		assertEquals(adress, apostadorDAO.getListOfGamblers().get(0).getAddressOfThePerson());
		assertEquals(phone, apostadorDAO.getListOfGamblers().get(0).getPhoneNumber());
	}

	@Test
	public void deleteTest() {

		apostadorDAO.create("John Doe", "123456789", "1990-01-01", "Headquarters", "123 Main St", "987654321");
		assertTrue(apostadorDAO.delete(0));

	}
}
