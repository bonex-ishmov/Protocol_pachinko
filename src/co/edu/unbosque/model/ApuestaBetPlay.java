package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase que representa un objeto de apuesta para el juego "BetPlay" y extiende
 * la clase ApuestaDTO. Esta clase contiene información específica relacionada
 * con las apuestas de BetPlay, como los equipos involucrados en la apuesta y el
 * resultado de la misma.
 */
public class ApuestaBetPlay extends ApuestaDTO implements Serializable {

	private static final long serialVersionUID = -6341812716503899102L;
	private String teamOne;
	private String teamTwo;
	private String resultBet;

	/**
	 * Constructor por defecto de ApuestaBetPlay.
	 */
	public ApuestaBetPlay() {

	}

	/**
	 * Constructor parametrizado de ApuestaBetPlay que permite inicializar los
	 * atributos específicos de BetPlay.
	 *
	 * @param teamOne   Nombre del primer equipo involucrado en la apuesta.
	 * @param teamTwo   Nombre del segundo equipo involucrado en la apuesta.
	 * @param resultBet Resultado de la apuesta.
	 */
	public ApuestaBetPlay(String teamOne, String teamTwo, String resultBet) {
		super(); // Llama al constructor de la superclase ApuestaDTO
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.resultBet = resultBet;
	}

	/**
	 * Constructor parametrizado de ApuestaBetPlay que permite inicializar tanto los
	 * atributos de la superclase como los atributos específicos de BetPlay.
	 *
	 * @param bookmakerOffice Sede de la casa de apuestas donde se realizó la
	 *                        apuesta.
	 * @param identification  Identificación del apostador que realizó la apuesta.
	 * @param dayOfTheWeek    Día de la semana en que se realizó la apuesta.
	 * @param valueOfTheBet   Valor de la apuesta realizada.
	 * @param teamOne         Nombre del primer equipo involucrado en la apuesta.
	 * @param teamTwo         Nombre del segundo equipo involucrado en la apuesta.
	 * @param resultBet       Resultado de la apuesta.
	 */
	public ApuestaBetPlay(String bookmakerOffice, double identification, String dayOfTheWeek, double valueOfTheBet,
			String teamOne, String teamTwo, String resultBet) {
		super(bookmakerOffice, identification, dayOfTheWeek, valueOfTheBet);
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.resultBet = resultBet;
	}

	// Getters y setters de los atributos específicos de BetPlay

	/**
	 * Obtiene el nombre del primer equipo involucrado en la apuesta de BetPlay.
	 *
	 * @return Nombre del primer equipo de BetPlay.
	 */
	public String getTeamOne() {
		return teamOne;
	}

	/**
	 * Establece el nombre del primer equipo involucrado en la apuesta de BetPlay.
	 *
	 * @param teamOne Nombre del primer equipo de BetPlay.
	 */
	public void setTeamOne(String teamOne) {
		this.teamOne = teamOne;
	}

	/**
	 * Obtiene el nombre del segundo equipo involucrado en la apuesta de BetPlay.
	 *
	 * @return Nombre del segundo equipo de BetPlay.
	 */
	public String getTeamTwo() {
		return teamTwo;
	}

	/**
	 * Establece el nombre del segundo equipo involucrado en la apuesta de BetPlay.
	 *
	 * @param teamTwo Nombre del segundo equipo de BetPlay.
	 */
	public void setTeamTwo(String teamTwo) {
		this.teamTwo = teamTwo;
	}

	/**
	 * Obtiene el resultado de la apuesta de BetPlay.
	 *
	 * @return Resultado de la apuesta de BetPlay.
	 */
	public String getResultBet() {
		return resultBet;
	}

	/**
	 * Establece el resultado de la apuesta de BetPlay.
	 *
	 * @param resultBet Resultado de la apuesta de BetPlay.
	 */
	public void setResultBet(String resultBet) {
		this.resultBet = resultBet;
	}

	/**
	 * Obtiene el valor del serialVersionUID.
	 *
	 * @return Valor del serialVersionUID.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Devuelve una representación en forma de cadena (String) de un objeto
	 * ApuestaBetPlay.
	 *
	 * @return Cadena que representa el objeto ApuestaBetPlay.
	 */
	@Override
	public String toString() {
		return super.toString() + "ApuestaBetPlay [teamOne=" + teamOne + ", teamTwo=" + teamTwo + ", resultBet="
				+ resultBet + "]";
	}
}
