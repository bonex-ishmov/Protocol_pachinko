package co.edu.unbosque.model;

import java.io.Serializable;

public class SedeCasaDeApuestasDTO implements Serializable{

	private static final long serialVersionUID = -3655071777418037463L;
	private String address;
	private int numberOfEmployees;
	private CasaDeApuestasDTO onwerBookmarker;
	
	public SedeCasaDeApuestasDTO() {
		// TODO Auto-generated constructor stub
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

	public CasaDeApuestasDTO getOnwerBookmarker() {
		return onwerBookmarker;
	}

	public void setOnwerBookmarker(CasaDeApuestasDTO onwerBookmarker) {
		this.onwerBookmarker = onwerBookmarker;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SedeCasaDeApuestasDTO [address=" + address + ", numberOfEmployees=" + numberOfEmployees
				+ ", onwerBookmarker=" + onwerBookmarker + "]";
	}
}
