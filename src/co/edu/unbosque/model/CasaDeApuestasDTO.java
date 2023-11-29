package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase que representa una casa de apuestas.
 */
public class CasaDeApuestasDTO implements Serializable {

	private static final long serialVersionUID = 4698655269197423988L;
	private String bookMarkerName;
	private int NumberOfLocations;
	private double totalBudgetAvailable;

	/**
	 * Constructor por defecto de CasaDeApuestasDTO.
	 */
	public CasaDeApuestasDTO() {
	}

	/**
	 * Constructor de CasaDeApuestasDTO con parámetros.
	 *
	 * @param bookMarkerName       El nombre de la casa de apuestas.
	 * @param numberOfLocations    El número de ubicaciones.
	 * @param totalBudgetAvailable El presupuesto total disponible.
	 */
	public CasaDeApuestasDTO(String bookMarkerName, int numberOfLocations, double totalBudgetAvailable) {
		super();
		this.bookMarkerName = bookMarkerName;
		NumberOfLocations = numberOfLocations;
		this.totalBudgetAvailable = totalBudgetAvailable;
	}

	/**
	 * Obtiene el nombre de la casa de apuestas.
	 *
	 * @return El nombre de la casa de apuestas.
	 */
	public String getBookMarkerName() {
		return bookMarkerName;
	}

	/**
	 * Establece el nombre de la casa de apuestas.
	 *
	 * @param bookMarkerName El nombre de la casa de apuestas.
	 */
	public void setBookMarkerName(String bookMarkerName) {
		this.bookMarkerName = bookMarkerName;
	}

	/**
	 * Obtiene el número de ubicaciones de la casa de apuestas.
	 *
	 * @return El número de ubicaciones.
	 */
	public int getNumberOfLocations() {
		return NumberOfLocations;
	}

	/**
	 * Establece el número de ubicaciones de la casa de apuestas.
	 *
	 * @param numberOfLocations El número de ubicaciones.
	 */
	public void setNumberOfLocations(int numberOfLocations) {
		NumberOfLocations = numberOfLocations;
	}

	/**
	 * Obtiene el presupuesto total disponible de la casa de apuestas.
	 *
	 * @return El presupuesto total disponible.
	 */
	public double getTotalBudgetAvailable() {
		return totalBudgetAvailable;
	}

	/**
	 * Establece el presupuesto total disponible de la casa de apuestas.
	 *
	 * @param totalBudgetAvailable El presupuesto total disponible.
	 */
	public void setTotalBudgetAvailable(double totalBudgetAvailable) {
		this.totalBudgetAvailable = totalBudgetAvailable;
	}

	/**
	 * Obtiene el valor de serialVersionUID para la serialización.
	 *
	 * @return El valor de serialVersionUID.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Devuelve una representación en cadena de este objeto.
	 *
	 * @return Una representación en cadena de CasaDeApuestasDTO.
	 */
	@Override
	public String toString() {
		return "CasaDeApuestasDTO [bookMarkerName=" + bookMarkerName + ", NumberOfLocations=" + NumberOfLocations
				+ ", totalBudgetAvailable=" + totalBudgetAvailable + "]";
	}
}
