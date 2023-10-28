package co.edu.unbosque.model;

import java.io.Serializable;

public class SedeCasaDeApuestasDTO extends CasaDeApuestasDTO implements Serializable {

	private static final long serialVersionUID = -3655071777418037463L;
	private String address;
	private int numberOfEmployees;
	
	public SedeCasaDeApuestasDTO() {
		// TODO Auto-generated constructor stub
	}

	public SedeCasaDeApuestasDTO(String address, int numberOfEmployees) {
		super();
		this.address = address;
		this.numberOfEmployees = numberOfEmployees;
	}

	public SedeCasaDeApuestasDTO(String bookMarkerName, int numberOfLocations, double totalBudgetAvailable) {
		super(bookMarkerName, numberOfLocations, totalBudgetAvailable);
		// TODO Auto-generated constructor stub
	}

	public SedeCasaDeApuestasDTO(String bookMarkerName, int numberOfLocations, double totalBudgetAvailable,
			String address, int numberOfEmployees) {
		super(bookMarkerName, numberOfLocations, totalBudgetAvailable);
		this.address = address;
		this.numberOfEmployees = numberOfEmployees;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SedeCasaDeApuestasDTO [address=" + address + ", numberOfEmployees=" + numberOfEmployees + "]";
	}
	
}
