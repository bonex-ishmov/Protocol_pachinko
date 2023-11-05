package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Clase que representa un objeto de apuesta para el juego "Baloto" y extiende
 * la clase ApuestaDTO. Esta clase contiene información específica relacionada
 * con las apuestas de Baloto, como un conjunto de seis números seleccionados
 * para la apuesta.
 */
public class ApuestaBaloto extends ApuestaDTO implements Serializable {

	private static final long serialVersionUID = -2432698889942765132L;
	private int[] sixNumbers;

	/**
	 * Constructor por defecto de ApuestaBaloto.
	 */
	public ApuestaBaloto() {
		
	}

	/**
	 * Constructor parametrizado de ApuestaBaloto que permite inicializar los
	 * atributos específicos de Baloto.
	 *
	 * @param sixNumbers Conjunto de seis números seleccionados para la apuesta de
	 *                   Baloto.
	 */
	public ApuestaBaloto(int[] sixNumbers) {
		super(); // Llama al constructor de la superclase ApuestaDTO
		this.sixNumbers = sixNumbers;
	}

	/**
	 * Constructor parametrizado de ApuestaBaloto que permite inicializar tanto los
	 * atributos de la superclase como los atributos específicos de Baloto.
	 *
	 * @param bookmakerOffice Sede de la casa de apuestas donde se realizó la
	 *                        apuesta.
	 * @param identification  Identificación del apostador que realizó la apuesta.
	 * @param dayOfTheWeek    Día de la semana en que se realizó la apuesta.
	 * @param valueOfTheBet   Valor de la apuesta realizada.
	 * @param sixNumbers      Conjunto de seis números seleccionados para la apuesta
	 *                        de Baloto.
	 */
	public ApuestaBaloto(String bookmakerOffice, double identification, String dayOfTheWeek, double valueOfTheBet,
			int[] sixNumbers) {
		super(bookmakerOffice, identification, dayOfTheWeek, valueOfTheBet);
		this.sixNumbers = sixNumbers;
	}

	// Getters y setters de los atributos específicos de Baloto

	/**
	 * Obtiene el conjunto de seis números seleccionados para la apuesta de Baloto.
	 *
	 * @return Conjunto de seis números de la apuesta.
	 */
	public int[] getSixNumbers() {
		return sixNumbers;
	}

	/**
	 * Establece el conjunto de seis números seleccionados para la apuesta de
	 * Baloto.
	 *
	 * @param sixNumbers Conjunto de seis números de la apuesta.
	 */
	public void setSixNumbers(int[] sixNumbers) {
		this.sixNumbers = sixNumbers;
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
	 * ApuestaBaloto.
	 *
	 * @return Cadena que representa el objeto ApuestaBaloto.
	 */
	@Override
	public String toString() {
		return super.toString() + "ApuestaBaloto [sixNumbers=" + Arrays.toString(sixNumbers) + "]";
	}
}
