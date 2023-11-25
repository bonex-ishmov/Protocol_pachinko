package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para
 * apostador. Esta clase contiene información relacionada con los apostadores,
 * como su nombre completo, identificación, fecha de nacimiento, sede de la casa
 * de apuestas, dirección y número de teléfono.
 */
public class ApostadorDTO implements Serializable {

	private static final long serialVersionUID = -6733443461609975906L;
	private String completeName;
	private String identification;
	private String birthDate;
	private String bookmakerHeadquarters;
	private String addressOfThePerson;
	private String phoneNumber;

	/**
	 * Constructor por defecto de ApostadorDTO.
	 */
	public ApostadorDTO() {

	}

	/**
	 * Constructor parametrizado de ApostadorDTO que permite inicializar todos los
	 * atributos de la clase.
	 *
	 * @param completeName          Nombre completo del apostador.
	 * @param identification        Identificación del apostador.
	 * @param birthDate             Fecha de nacimiento del apostador.
	 * @param bookmakerHeadquarters Sede de la casa de apuestas a la que está
	 *                              asociado el apostador.
	 * @param addressOfThePerson    Dirección del apostador.
	 * @param phoneNumber           Número de teléfono del apostador.
	 */
	public ApostadorDTO(String completeName, String identification, String birthDate, String bookmakerHeadquarters,
			String addressOfThePerson, String phoneNumber) {
		super();
		this.completeName = completeName;
		this.identification = identification;
		this.birthDate = birthDate;
		this.bookmakerHeadquarters = bookmakerHeadquarters;
		this.addressOfThePerson = addressOfThePerson;
		this.phoneNumber = phoneNumber;
	}

	// Getters y setters de los atributos de la clase

	/**
	 * Obtiene el nombre completo del apostador.
	 *
	 * @return Nombre completo del apostador.
	 */
	public String getCompleteName() {
		return completeName;
	}

	/**
	 * Establece el nombre completo del apostador.
	 *
	 * @param completeName Nombre completo del apostador.
	 */
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	/**
	 * Obtiene la identificación del apostador.
	 *
	 * @return Identificación del apostador.
	 */
	public String getIdentification() {
		return identification;
	}

	/**
	 * Establece la identificación del apostador.
	 *
	 * @param identification Identificación del apostador.
	 */
	public void setIdentification(String identification) {
		this.identification = identification;
	}

	/**
	 * Obtiene la fecha de nacimiento del apostador.
	 *
	 * @return Fecha de nacimiento del apostador.
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * Establece la fecha de nacimiento del apostador.
	 *
	 * @param birthDate Fecha de nacimiento del apostador.
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Obtiene la sede de la casa de apuestas a la que está asociado el apostador.
	 *
	 * @return Sede de la casa de apuestas.
	 */
	public String getBookmakerHeadquarters() {
		return bookmakerHeadquarters;
	}

	/**
	 * Establece la sede de la casa de apuestas a la que está asociado el apostador.
	 *
	 * @param bookmakerHeadquarters Sede de la casa de apuestas.
	 */
	public void setBookmakerHeadquarters(String bookmakerHeadquarters) {
		this.bookmakerHeadquarters = bookmakerHeadquarters;
	}

	/**
	 * Obtiene la dirección del apostador.
	 *
	 * @return Dirección del apostador.
	 */
	public String getAddressOfThePerson() {
		return addressOfThePerson;
	}

	/**
	 * Establece la dirección del apostador.
	 *
	 * @param addressOfThePerson Dirección del apostador.
	 */
	public void setAddressOfThePerson(String addressOfThePerson) {
		this.addressOfThePerson = addressOfThePerson;
	}

	/**
	 * Obtiene el número de teléfono del apostador.
	 *
	 * @return Número de teléfono del apostador.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Establece el número de teléfono del apostador.
	 *
	 * @param phoneNumber Número de teléfono del apostador.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	 * ApostadorDTO.
	 *
	 * @return Cadena que representa el objeto ApostadorDTO.
	 */
	@Override
	public String toString() {
		return "ApostadoresDTO [completeName=" + completeName + ", identification=" + identification + ", birthDate="
				+ birthDate + ", bookmakerHeadquarters=" + bookmakerHeadquarters + ", addressOfThePerson="
				+ addressOfThePerson + ", phoneNumber=" + phoneNumber + "]";
	}
}
