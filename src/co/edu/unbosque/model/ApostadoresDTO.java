package co.edu.unbosque.model;

import java.io.Serializable;

public class ApostadoresDTO implements Serializable {

	private static final long serialVersionUID = -6733443461609975906L;
	private String completeName;
	private double identification;
	private SedeCasaDeApuestasDTO bookmakerHeadquarters;
	private String addressOfThePerson;
	private double phoneNumber;

	public ApostadoresDTO() {
		// TODO Auto-generated constructor stub
	}

	public ApostadoresDTO(String completeName, double identification, SedeCasaDeApuestasDTO bookmakerHeadquarters,
			String addressOfThePerson, double phoneNumber) {
		super();
		this.completeName = completeName;
		this.identification = identification;
		this.bookmakerHeadquarters = bookmakerHeadquarters;
		this.addressOfThePerson = addressOfThePerson;
		this.phoneNumber = phoneNumber;
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public double getIdentification() {
		return identification;
	}

	public void setIdentification(double identification) {
		this.identification = identification;
	}

	public SedeCasaDeApuestasDTO getBookmakerHeadquarters() {
		return bookmakerHeadquarters;
	}

	public void setBookmakerHeadquarters(SedeCasaDeApuestasDTO bookmakerHeadquarters) {
		this.bookmakerHeadquarters = bookmakerHeadquarters;
	}

	public String getAddressOfThePerson() {
		return addressOfThePerson;
	}

	public void setAddressOfThePerson(String addressOfThePerson) {
		this.addressOfThePerson = addressOfThePerson;
	}

	public double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

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
