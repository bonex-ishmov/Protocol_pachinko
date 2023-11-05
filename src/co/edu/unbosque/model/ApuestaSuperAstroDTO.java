package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Clase que representa un objeto de apuesta para el juego "Super Astro" y
 * extiende la clase ApuestaDTO. Esta clase contiene información específica
 * relacionada con las apuestas de Super Astro, como un conjunto de cuatro
 * números y el signo zodiacal asociado a la apuesta.
 */
public class ApuestaSuperAstroDTO extends ApuestaDTO implements Serializable {

	private static final long serialVersionUID = -4402814736606761069L;
	private int[] fourNumbers;
	private String zodiacSign;

	/**
	 * Constructor por defecto de ApuestaSuperAstroDTO.
	 */
	public ApuestaSuperAstroDTO() {
		super(); // Llama al constructor de la superclase ApuestaDTO
	}

	/**
	 * Constructor parametrizado de ApuestaSuperAstroDTO que permite inicializar los
	 * atributos específicos de Super Astro.
	 *
	 * @param fourNumbers Conjunto de cuatro números de la apuesta.
	 * @param zodiacSign  Signo zodiacal asociado a la apuesta de Super Astro.
	 */
	public ApuestaSuperAstroDTO(int[] fourNumbers, String zodiacSign) {
		super(); // Llama al constructor de la superclase ApuestaDTO
		this.fourNumbers = fourNumbers;
		this.zodiacSign = zodiacSign;
	}

	/**
	 * Constructor parametrizado de ApuestaSuperAstroDTO que permite inicializar
	 * tanto los atributos de la superclase como los atributos específicos de Super
	 * Astro.
	 *
	 * @param bookmakerOffice Sede de la casa de apuestas donde se realizó la
	 *                        apuesta.
	 * @param identification  Identificación del apostador que realizó la apuesta.
	 * @param dayOfTheWeek    Día de la semana en que se realizó la apuesta.
	 * @param valueOfTheBet   Valor de la apuesta realizada.
	 * @param fourNumbers     Conjunto de cuatro números de la apuesta.
	 * @param zodiacSign      Signo zodiacal asociado a la apuesta de Super Astro.
	 */
	public ApuestaSuperAstroDTO(String bookmakerOffice, double identification, String dayOfTheWeek,
			double valueOfTheBet, int[] fourNumbers, String zodiacSign) {
		super(bookmakerOffice, identification, dayOfTheWeek, valueOfTheBet);
		this.fourNumbers = fourNumbers;
		this.zodiacSign = zodiacSign;
	}

	// Getters y setters de los atributos específicos de Super Astro

	/**
	 * Obtiene el conjunto de cuatro números de la apuesta de Super Astro.
	 *
	 * @return Conjunto de cuatro números de la apuesta.
	 */
	public int[] getFourNumbers() {
		return fourNumbers;
	}

	/**
	 * Establece el conjunto de cuatro números de la apuesta de Super Astro.
	 *
	 * @param fourNumbers Conjunto de cuatro números de la apuesta.
	 */
	public void setFourNumbers(int[] fourNumbers) {
		this.fourNumbers = fourNumbers;
	}

	/**
	 * Obtiene el signo zodiacal asociado a la apuesta de Super Astro.
	 *
	 * @return Signo zodiacal de la apuesta.
	 */
	public String getZodiacSign() {
		return zodiacSign;
	}

	/**
	 * Establece el signo zodiacal asociado a la apuesta de Super Astro.
	 *
	 * @param zodiacSign Signo zodiacal de la apuesta.
	 */
	public void setZodiacSign(String zodiacSign) {
		this.zodiacSign = zodiacSign;
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
	 * ApuestaSuperAstro.
	 *
	 * @return Cadena que representa el objeto ApuestaSuperAstro.
	 */
	@Override
	public String toString() {
		return super.toString() + "ApuestaSuperAstro [fourNumbers=" + Arrays.toString(fourNumbers) + ", zodiacSign="
				+ zodiacSign + "]";
	}
}
