package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Clase que representa un objeto de apuesta para el juego "Chance" y extiende
 * la clase ApuestaDTO. Esta clase contiene información específica relacionada
 * con las apuestas de Chance, como el nombre de la lotería de Chance y un
 * conjunto de cuatro números asociados a la apuesta.
 */
public class ApuestaChance extends ApuestaDTO implements Serializable {

	private static final long serialVersionUID = 6467706599620146542L;
	private String lotteryName;
	private int[] fourNumbers;

	/**
	 * Constructor por defecto de ApuestaChance.
	 */
	public ApuestaChance() {
		super(); // Llama al constructor de la superclase ApuestaDTO
	}

	/**
	 * Constructor parametrizado de ApuestaChance que permite inicializar los
	 * atributos específicos de Chance.
	 *
	 * @param lotteryName Nombre de la lotería de Chance.
	 * @param fourNumbers Conjunto de cuatro números de la apuesta.
	 */
	public ApuestaChance(String lotteryName, int[] fourNumbers) {
		super(); // Llama al constructor de la superclase ApuestaDTO
		this.lotteryName = lotteryName;
		this.fourNumbers = fourNumbers;
	}

	/**
	 * Constructor parametrizado de ApuestaChance que permite inicializar tanto los
	 * atributos de la superclase como los atributos específicos de Chance.
	 *
	 * @param bookmakerOffice Sede de la casa de apuestas donde se realizó la
	 *                        apuesta.
	 * @param identification  Identificación del apostador que realizó la apuesta.
	 * @param dayOfTheWeek    Día de la semana en que se realizó la apuesta.
	 * @param valueOfTheBet   Valor de la apuesta realizada.
	 * @param lotteryName     Nombre de la lotería de Chance.
	 * @param fourNumbers     Conjunto de cuatro números de la apuesta.
	 */
	public ApuestaChance(String bookmakerOffice, double identification, String dayOfTheWeek, double valueOfTheBet,
			String lotteryName, int[] fourNumbers) {
		super(bookmakerOffice, identification, dayOfTheWeek, valueOfTheBet);
		this.lotteryName = lotteryName;
		this.fourNumbers = fourNumbers;
	}

	// Getters y setters de los atributos específicos de Chance

	/**
	 * Obtiene el nombre de la lotería de Chance.
	 *
	 * @return Nombre de la lotería de Chance.
	 */
	public String getLotteryName() {
		return lotteryName;
	}

	/**
	 * Establece el nombre de la lotería de Chance.
	 *
	 * @param lotteryName Nombre de la lotería de Chance.
	 */
	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}

	/**
	 * Obtiene el conjunto de cuatro números de la apuesta de Chance.
	 *
	 * @return Conjunto de cuatro números de la apuesta.
	 */
	public int[] getFourNumbers() {
		return fourNumbers;
	}

	/**
	 * Establece el conjunto de cuatro números de la apuesta de Chance.
	 *
	 * @param fourNumbers Conjunto de cuatro números de la apuesta.
	 */
	public void setFourNumbers(int[] fourNumbers) {
		this.fourNumbers = fourNumbers;
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
	 * ApuestaChance.
	 *
	 * @return Cadena que representa el objeto ApuestaChance.
	 */
	@Override
	public String toString() {
		return super.toString() + "ApuestaChance [lotteryName=" + lotteryName + ", fourNumbers="
				+ Arrays.toString(fourNumbers) + "]";
	}
}
