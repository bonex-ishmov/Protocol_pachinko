package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para apuestas.
 * Esta clase contiene información relacionada con las apuestas, como la sede de
 * la casa de apuestas, la identificación del apostador, el día de la semana en
 * que se realizó la apuesta y el valor de la apuesta.
 */
public class ApuestaDTO implements Serializable {

	private static final long serialVersionUID = -2781358446157806900L;
	private String bookmakerOffice;
	private double identification;
	private String dayOfTheWeek;
	private double valueOfTheBet;

	/**
	 * Constructor por defecto de ApuestaDTO.
	 */
	public ApuestaDTO() {

	}

	/**
	 * Constructor parametrizado de ApuestaDTO que permite inicializar todos los
	 * atributos de la clase.
	 *
	 * @param bookmakerOffice Sede de la casa de apuestas donde se realizó la
	 *                        apuesta.
	 * @param identification  Identificación del apostador que realizó la apuesta.
	 * @param dayOfTheWeek    Día de la semana en que se realizó la apuesta.
	 * @param valueOfTheBet   Valor de la apuesta realizada.
	 */
	public ApuestaDTO(String bookmakerOffice, double identification, String dayOfTheWeek, double valueOfTheBet) {
		super();
		this.bookmakerOffice = bookmakerOffice;
		this.identification = identification;
		this.dayOfTheWeek = dayOfTheWeek;
		this.valueOfTheBet = valueOfTheBet;
	}

	// Getters y setters de los atributos de la clase

	/**
	 * Obtiene la sede de la casa de apuestas.
	 *
	 * @return Sede de la casa de apuestas.
	 */
	public String getBookmakerOffice() {
		return bookmakerOffice;
	}

	/**
	 * Establece la sede de la casa de apuestas.
	 *
	 * @param bookmakerOffice Sede de la casa de apuestas.
	 */
	public void setBookmakerOffice(String bookmakerOffice) {
		this.bookmakerOffice = bookmakerOffice;
	}

	/**
	 * Obtiene la identificación del apostador.
	 *
	 * @return Identificación del apostador.
	 */
	public double getIdentification() {
		return identification;
	}

	/**
	 * Establece la identificación del apostador.
	 *
	 * @param identification Identificación del apostador.
	 */
	public void setIdentification(double identification) {
		this.identification = identification;
	}

	/**
	 * Obtiene el día de la semana en que se realizó la apuesta.
	 *
	 * @return Día de la semana.
	 */
	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	/**
	 * Establece el día de la semana en que se realizó la apuesta.
	 *
	 * @param dayOfTheWeek Día de la semana.
	 */
	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	/**
	 * Obtiene el valor de la apuesta realizada.
	 *
	 * @return Valor de la apuesta.
	 */
	public double getValueOfTheBet() {
		return valueOfTheBet;
	}

	/**
	 * Establece el valor de la apuesta realizada.
	 *
	 * @param valueOfTheBet Valor de la apuesta.
	 */
	public void setValueOfTheBet(double valueOfTheBet) {
		this.valueOfTheBet = valueOfTheBet;
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
	 * ApuestaDTO.
	 *
	 * @return Cadena que representa el objeto ApuestaDTO.
	 */
	@Override
	public String toString() {
		return "ApuestaDTO [bookmakerOffice=" + bookmakerOffice + ", identification=" + identification
				+ ", dayOfTheWeek=" + dayOfTheWeek + ", valueOfTheBet=" + valueOfTheBet + "]";
	}
}
