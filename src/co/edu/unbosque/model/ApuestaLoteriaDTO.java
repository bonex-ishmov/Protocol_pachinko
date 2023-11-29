package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para apuestas
 * de lotería, que extiende la clase ApuestaDTO. Esta clase contiene información
 * adicional específica para las apuestas de lotería, como el nombre de la
 * lotería, cuatro números de apuesta y una serie asociada.
 */
public class ApuestaLoteriaDTO extends ApuestaDTO implements Serializable {

	private static final long serialVersionUID = -1314661433241492823L;
	private String lotteryName;
	private int[] fourNumbers;
	private String series;

	/**
	 * Constructor por defecto de ApuestaLoteriaDTO.
	 */
	public ApuestaLoteriaDTO() {
		super(); // Llama al constructor de la superclase ApuestaDTO
	}

	/**
	 * Constructor parametrizado de ApuestaLoteriaDTO que permite inicializar los
	 * atributos específicos de lotería.
	 *
	 * @param lotteryName Nombre de la lotería.
	 * @param fourNumbers Array de cuatro números de apuesta.
	 * @param series      Serie asociada a la apuesta de lotería.
	 */
	public ApuestaLoteriaDTO(String lotteryName, int[] fourNumbers, String series) {
		super(); // Llama al constructor de la superclase ApuestaDTO
		this.lotteryName = lotteryName;
		this.fourNumbers = fourNumbers;
		this.series = series;
	}

	/**
	 * Constructor parametrizado de ApuestaLoteriaDTO que permite inicializar los
	 * atributos tanto de la superclase como los atributos específicos de lotería.
	 *
	 * @param bookmakerOffice Sede de la casa de apuestas donde se realizó la
	 *                        apuesta.
	 * @param identification  Identificación del apostador que realizó la apuesta.
	 * @param dayOfTheWeek    Día de la semana en que se realizó la apuesta.
	 * @param valueOfTheBet   Valor de la apuesta realizada.
	 * @param lotteryName     Nombre de la lotería.
	 * @param fourNumbers     Array de cuatro números de apuesta.
	 * @param series          Serie asociada a la apuesta de lotería.
	 */
	public ApuestaLoteriaDTO(String bookmakerOffice, long identification, String dayOfTheWeek, double valueOfTheBet,
			String lotteryName, int[] fourNumbers, String series) {
		super(bookmakerOffice, identification, dayOfTheWeek, valueOfTheBet);
		this.lotteryName = lotteryName;
		this.fourNumbers = fourNumbers;
		this.series = series;
	}

	// Getters y setters de los atributos específicos de lotería

	/**
	 * Obtiene el nombre de la lotería.
	 *
	 * @return Nombre de la lotería.
	 */
	public String getLotteryName() {
		return lotteryName;
	}

	/**
	 * Establece el nombre de la lotería.
	 *
	 * @param lotteryName Nombre de la lotería.
	 */
	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}

	/**
	 * Obtiene los cuatro números de apuesta.
	 *
	 * @return Array de cuatro números de apuesta.
	 */
	public int[] getFourNumbers() {
		return fourNumbers;
	}

	/**
	 * Establece los cuatro números de apuesta.
	 *
	 * @param fourNumbers Array de cuatro números de apuesta.
	 */
	public void setFourNumbers(int[] fourNumbers) {
		this.fourNumbers = fourNumbers;
	}

	/**
	 * Obtiene la serie asociada a la apuesta de lotería.
	 *
	 * @return Serie asociada a la apuesta de lotería.
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * Establece la serie asociada a la apuesta de lotería.
	 *
	 * @param series Serie asociada a la apuesta de lotería.
	 */
	public void setSeries(String series) {
		this.series = series;
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
	 * ApuestaLoteriaDTO.
	 *
	 * @return Cadena que representa el objeto ApuestaLoteriaDTO.
	 */
	@Override
	public String toString() {
		return super.toString() + "ApuestaLoteriaDTO [lotteryName=" + lotteryName + ", fourNumbers="
				+ Arrays.toString(fourNumbers) + ", series=" + series + "]";
	}
}
