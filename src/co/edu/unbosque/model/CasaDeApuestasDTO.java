package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CasaDeApuestasDTO implements Serializable {

	private static final long serialVersionUID = 4698655269197423988L;
	private String bookMarkerName;
	private int NumberOfLocations;
	private double totalBudgetAvailable;

	public CasaDeApuestasDTO() {
		// TODO Auto-generated constructor stub
	}

	public CasaDeApuestasDTO(String bookMarkerName, int numberOfLocations, double totalBudgetAvailable) {
		super();
		this.bookMarkerName = bookMarkerName;
		NumberOfLocations = numberOfLocations;
		this.totalBudgetAvailable = totalBudgetAvailable;
	}

	public String getBookMarkerName() {
		return bookMarkerName;
	}

	public void setBookMarkerName(String bookMarkerName) {
		this.bookMarkerName = bookMarkerName;
	}

	public int getNumberOfLocations() {
		return NumberOfLocations;
	}

	public void setNumberOfLocations(int numberOfLocations) {
		NumberOfLocations = numberOfLocations;
	}

	public double getTotalBudgetAvailable() {
		return totalBudgetAvailable;
	}

	public void setTotalBudgetAvailable(double totalBudgetAvailable) {
		this.totalBudgetAvailable = totalBudgetAvailable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CasaDeApuestasDTO [bookMarkerName=" + bookMarkerName + ", NumberOfLocations=" + NumberOfLocations
				+ ", totalBudgetAvailable=" + totalBudgetAvailable + "]";
	}

}
