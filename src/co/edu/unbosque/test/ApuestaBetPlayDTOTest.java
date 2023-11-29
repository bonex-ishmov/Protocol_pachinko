package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.edu.unbosque.model.ApuestaBetPlayDTO;

public class ApuestaBetPlayDTOTest {

	@Test
	public void testConstructorPorDefecto() {
		ApuestaBetPlayDTO apuesta = new ApuestaBetPlayDTO();

		assertEquals(null, apuesta.getBookmakerOffice());
		assertEquals(0L, apuesta.getIdentification());
		assertEquals(null, apuesta.getDayOfTheWeek());
		assertEquals(0.0, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(null, apuesta.getTeamOne());
		assertEquals(null, apuesta.getTeamTwo());
		assertEquals(null, apuesta.getResultBet());
	}

	@Test
	public void testConstructorParametrizado() {
		String teamOne = "Millonarios";
		String teamTwo = "Santa Fe";
		String resultBet = "Gana Millonarios";
		ApuestaBetPlayDTO apuesta = new ApuestaBetPlayDTO(teamOne, teamTwo, resultBet);

		assertEquals(null, apuesta.getBookmakerOffice());
		assertEquals(0L, apuesta.getIdentification());
		assertEquals(null, apuesta.getDayOfTheWeek());
		assertEquals(0.0, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(teamOne, apuesta.getTeamOne());
		assertEquals(teamTwo, apuesta.getTeamTwo());
		assertEquals(resultBet, apuesta.getResultBet());
	}

	@Test
	public void testConstructorParametrizadoCompleto() {
		String bookmakerOffice = "Casa de Apuestas 1";
		long identification = 1234567890L;
		String dayOfTheWeek = "Lunes";
		double valueOfTheBet = 10000.0;
		String teamOne = "Millonarios";
		String teamTwo = "Santa Fe";
		String resultBet = "Gana Millonarios";
		ApuestaBetPlayDTO apuesta = new ApuestaBetPlayDTO(bookmakerOffice, identification, dayOfTheWeek, valueOfTheBet,
				teamOne, teamTwo, resultBet);

		assertEquals(bookmakerOffice, apuesta.getBookmakerOffice());
		assertEquals(identification, apuesta.getIdentification());
		assertEquals(dayOfTheWeek, apuesta.getDayOfTheWeek());
		assertEquals(valueOfTheBet, apuesta.getValueOfTheBet(), 0.001);
		assertEquals(teamOne, apuesta.getTeamOne());
		assertEquals(teamTwo, apuesta.getTeamTwo());
		assertEquals(resultBet, apuesta.getResultBet());
	}

}