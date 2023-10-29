package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase `ApostadoresDTO` representa a los apostadores en la aplicación. Contiene información
 * sobre los apostadores, como su nombre completo, identificación, sede de la casa de apuestas,
 * dirección y número de teléfono.
 *
 * Esta clase implementa la interfaz `Serializable`, lo que permite su serialización.
 */
public class ApostadoresDTO implements Serializable {

    private static final long serialVersionUID = -6733443461609975906L;
    private String completeName;
    private double identification;
    private String bookmakerHeadquarters;
    private String addressOfThePerson;
    private double phoneNumber;

    /**
     * Constructor predeterminado de `ApostadoresDTO`.
     */
    public ApostadoresDTO() {
    }

    /**
     * Constructor de `ApostadoresDTO` que recibe información detallada sobre el apostador.
     *
     * @param completeName           El nombre completo del apostador.
     * @param identification          El número de identificación del apostador.
     * @param bookmakerHeadquarters   La sede de la casa de apuestas a la que está asociado el apostador.
     * @param addressOfThePerson     La dirección del apostador.
     * @param phoneNumber            El número de teléfono del apostador.
     */
    public ApostadoresDTO(String completeName, double identification, String bookmakerHeadquarters,
                          String addressOfThePerson, double phoneNumber) {
        super();
        this.completeName = completeName;
        this.identification = identification;
        this.bookmakerHeadquarters = bookmakerHeadquarters;
        this.addressOfThePerson = addressOfThePerson;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Obtiene el nombre completo del apostador.
     *
     * @return El nombre completo del apostador.
     */
    public String getCompleteName() {
        return completeName;
    }

    /**
     * Establece el nombre completo del apostador.
     *
     * @param completeName El nombre completo del apostador.
     */
    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    /**
     * Obtiene el número de identificación del apostador.
     *
     * @return El número de identificación del apostador.
     */
    public double getIdentification() {
        return identification;
    }

    /**
     * Establece el número de identificación del apostador.
     *
     * @param identification El número de identificación del apostador.
     */
    public void setIdentification(double identification) {
        this.identification = identification;
    }

    /**
     * Obtiene la sede de la casa de apuestas a la que está asociado el apostador.
     *
     * @return La sede de la casa de apuestas.
     */
    public String getBookmakerHeadquarters() {
        return bookmakerHeadquarters;
    }

    /**
     * Establece la sede de la casa de apuestas a la que está asociado el apostador.
     *
     * @param bookmakerHeadquarters La sede de la casa de apuestas.
     */
    public void setBookmakerHeadquarters(String bookmakerHeadquarters) {
        this.bookmakerHeadquarters = bookmakerHeadquarters;
    }

    /**
     * Obtiene la dirección del apostador.
     *
     * @return La dirección del apostador.
     */
    public String getAddressOfThePerson() {
        return addressOfThePerson;
    }

    /**
     * Establece la dirección del apostador.
     *
     * @param addressOfThePerson La dirección del apostador.
     */
    public void setAddressOfThePerson(String addressOfThePerson) {
        this.addressOfThePerson = addressOfThePerson;
    }

    /**
     * Obtiene el número de teléfono del apostador.
     *
     * @return El número de teléfono del apostador.
     */
    public double getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Establece el número de teléfono del apostador.
     *
     * @param phoneNumber El número de teléfono del apostador.
     */
    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return "ApostadoresDTO [completeName=" + completeName + ", identification=" + identification
                + ", bookmakerHeadquarters=" + bookmakerHeadquarters + ", addressOfThePerson=" + addressOfThePerson
                + ", phoneNumber=" + phoneNumber + "]";
    }
}
