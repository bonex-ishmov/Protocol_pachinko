package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase que representa una sede de una casa de apuestas.
 */
public class SedeCasaDeApuestasDTO extends CasaDeApuestasDTO implements Serializable {

	private static final long serialVersionUID = -3655071777418037463L;
	private String address;
	private int numberOfEmployees;

	/**
	 * Constructor por defecto de SedeCasaDeApuestasDTO.
	 */
	public SedeCasaDeApuestasDTO() {

	}

	/**
	 * Constructor de SedeCasaDeApuestasDTO con parámetros de dirección y número de
	 * empleados.
	 *
	 * @param address           La dirección de la sede de la casa de apuestas.
	 * @param numberOfEmployees El número de empleados de la sede.
	 */
	public SedeCasaDeApuestasDTO(String address, int numberOfEmployees) {
		super();
		this.address = address;
		this.numberOfEmployees = numberOfEmployees;
	}

	/**
	 * Constructor de SedeCasaDeApuestasDTO con parámetros relacionados a la casa de
	 * apuestas.
	 *
	 * @param bookMarkerName       El nombre de la casa de apuestas.
	 * @param numberOfLocations    El número de ubicaciones.
	 * @param totalBudgetAvailable El presupuesto total disponible.
	 */
	public SedeCasaDeApuestasDTO(String bookMarkerName, int numberOfLocations, double totalBudgetAvailable) {
		super(bookMarkerName, numberOfLocations, totalBudgetAvailable);
	}

	/**
	 * Constructor de SedeCasaDeApuestasDTO con parámetros relacionados a la casa de
	 * apuestas, dirección y número de empleados.
	 *
	 * @param bookMarkerName       El nombre de la casa de apuestas.
	 * @param numberOfLocations    El número de ubicaciones.
	 * @param totalBudgetAvailable El presupuesto total disponible.
	 * @param address              La dirección de la sede de la casa de apuestas.
	 * @param numberOfEmployees    El número de empleados de la sede.
	 */
	public SedeCasaDeApuestasDTO(String bookMarkerName, int numberOfLocations, double totalBudgetAvailable,
			String address, int numberOfEmployees) {
		super(bookMarkerName, numberOfLocations, totalBudgetAvailable);
		this.address = address;
		this.numberOfEmployees = numberOfEmployees;
	}

	/**
	 * Obtiene la dirección de la sede de la casa de apuestas.
	 *
	 * @return La dirección de la sede.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Establece la dirección de la sede de la casa de apuestas.
	 *
	 * @param address La dirección de la sede.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Obtiene el número de empleados de la sede de la casa de apuestas.
	 *
	 * @return El número de empleados de la sede.
	 */
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	/**
	 * Establece el número de empleados de la sede de la casa de apuestas.
	 *
	 * @param numberOfEmployees El número de empleados de la sede.
	 */
	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
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
	 * @return Una representación en cadena de SedeCasaDeApuestasDTO.
	 */
	@Override
	public String toString() {
		return super.toString() + "SedeCasaDeApuestasDTO [address=" + address + ", numberOfEmployees="
				+ numberOfEmployees + "]";
	}
}
