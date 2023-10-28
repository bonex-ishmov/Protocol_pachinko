package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase que representa a un apostador.
 */
public class ApostadoresDTO implements Serializable {

    private static final long serialVersionUID = -6733443461609975906L;
    private String completeName;
    private double identification;
    private SedeCasaDeApuestasDTO bookmakerHeadquarters;
    private String addressOfThePerson;
    private double phoneNumber;

    /**
     * Constructor por defecto de ApostadoresDTO.
     */
    public ApostadoresDTO() {
    }

    /**
     * Constructor de ApostadoresDTO con parámetros.
     *
     * @param completeName           El nombre completo del apostador.
     * @param identification         La identificación del apostador.
     * @param bookmakerHeadquarters  La sede de la casa de apuestas a la que pertenece el apostador.
     * @param addressOfThePerson     La dirección del apostador.
     * @param phoneNumber            El número de teléfono del apostador.
     */
    public ApostadoresDTO(String completeName, double identification, SedeCasaDeApuestasDTO bookmakerHeadquarters,
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
     * Obtiene la identificación del apostador.
     *
     * @return La identificación del apostador.
     */
    public double getIdentification() {
        return identification;
    }

    /**
     * Establece la identificación del apostador.
     *
     * @param identification La identificación del apostador.
     */
    public void setIdentification(double identification) {
        this.identification = identification;
    }

    /**
     * Obtiene la sede de la casa de apuestas a la que pertenece el apostador.
     *
     * @return La sede de la casa de apuestas.
     */
    public SedeCasaDeApuestasDTO getBookmakerHeadquarters() {
        return bookmakerHeadquarters;
    }

    /**
     * Establece la sede de la casa de apuestas a la que pertenece el apostador.
     *
     * @param bookmakerHeadquarters La sede de la casa de apuestas.
     */
    public void setBookmakerHeadquarters(SedeCasaDeApuestasDTO bookmakerHeadquarters) {
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
     * @return Una representación en cadena de ApostadoresDTO.
     */
    @Override
    public String toString() {
        return "ApostadoresDTO [completeName=" + completeName + ", identification=" + identification
                + ", bookmakerHeadquarters=" + bookmakerHeadquarters + ", addressOfThePerson=" + addressOfThePerson
                + ", phoneNumber=" + phoneNumber + "]";
    }
}
