package co.edu.unbosque.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * La clase `ApuestaDTO` representa las apuestas realizadas por los apostadores
 * en la aplicación. Contiene información sobre la sede de la casa de apuestas,
 * la identificación del apostador, el día de la semana en que se realizó la
 * apuesta y el valor de la apuesta.
 *
 * Esta clase implementa la interfaz `Serializable`, lo que permite su
 * serialización.
 */
public class ApuestaDTO implements Serializable {

	private static final long serialVersionUID = -2781358446157806900L;
	private String bookmakerHeadquarters;
	private double identification;
	private String dayOfTheWeek;
	private double valueOfTheBet;

	/**
	 * Constructor predeterminado de `ApuestaDTO`.
	 */
	public ApuestaDTO() {
	}

	/**
	 * Constructor de `ApuestaDTO` que recibe información detallada sobre la
	 * apuesta.
	 *
	 * @param bookmakerHeadquarters La sede de la casa de apuestas en la que se
	 *                              realizó la apuesta.
	 * @param identification        La identificación del apostador que realizó la
	 *                              apuesta.
	 * @param dayOfTheWeek          El día de la semana en que se realizó la
	 *                              apuesta.
	 * @param valueOfTheBet         El valor de la apuesta.
	 */
	public ApuestaDTO(String bookmakerHeadquarters, double identification, String dayOfTheWeek, double valueOfTheBet) {
		super();
		this.bookmakerHeadquarters = bookmakerHeadquarters;
		this.identification = identification;
		this.dayOfTheWeek = dayOfTheWeek;
		this.valueOfTheBet = valueOfTheBet;
	}

	/**
	 * Obtiene la sede de la casa de apuestas en la que se realizó la apuesta.
	 *
	 * @return La sede de la casa de apuestas.
	 */
	public String getBookmakerHeadquarters() {
		return bookmakerHeadquarters;
	}

	/**
	 * Establece la sede de la casa de apuestas en la que se realizó la apuesta.
	 *
	 * @param bookmakerHeadquarters La sede de la casa de apuestas.
	 */
	public void setBookmakerHeadquarters(String bookmakerHeadquarters) {
		this.bookmakerHeadquarters = bookmakerHeadquarters;
	}

	/**
	 * Obtiene la identificación del apostador que realizó la apuesta.
	 *
	 * @return La identificación del apostador.
	 */
	public double getIdentification() {
		return identification;
	}

	/**
	 * Establece la identificación del apostador que realizó la apuesta.
	 *
	 * @param identification La identificación del apostador.
	 */
	public void setIdentification(double identification) {
		this.identification = identification;
	}

	/**
	 * Obtiene el día de la semana en que se realizó la apuesta.
	 *
	 * @return El día de la semana.
	 */
	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	/**
	 * Establece el día de la semana en que se realizó la apuesta.
	 *
	 * @param dayOfTheWeek El día de la semana.
	 */
	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	/**
	 * Obtiene el valor de la apuesta.
	 *
	 * @return El valor de la apuesta.
	 */
	public double getValueOfTheBet() {
		return valueOfTheBet;
	}

	/**
	 * Establece el valor de la apuesta.
	 *
	 * @param valueOfTheBet El valor de la apuesta.
	 */
	public void setValueOfTheBet(double valueOfTheBet) {
		this.valueOfTheBet = valueOfTheBet;
	}

	/**
	 * Obtiene el valor de la versión serializable de la clase.
	 *
	 * @return El valor de la versión serializable.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ApuestasDTO [bookmakerHeadquarters=" + bookmakerHeadquarters + ", identification=" + identification
				+ ", dayOfTheWeek=" + dayOfTheWeek + ", valueOfTheBet=" + valueOfTheBet + "]";
	}

	/**
	 * Convierte una fecha en formato de cadena a su correspondiente día de la
	 * semana.
	 *
	 * @param fechaString La fecha en formato de cadena ("yyyy-MM-dd").
	 * @return El día de la semana correspondiente a la fecha.
	 */
	public static String obtenerDiaSemana(String fechaString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date fecha = sdf.parse(fechaString);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fecha);

			int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);

			String[] diasSemana = { "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" };

			return diasSemana[diaSemana - 1];
		} catch (ParseException e) {
			return "Fecha no válida";
		}
	}
}
