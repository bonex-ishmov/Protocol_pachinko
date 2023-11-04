package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Arrays;

public class ApuestaBaloto extends ApuestaDTO implements Serializable {

	private static final long serialVersionUID = -2432698889942765132L;
	private int[] sixNumbers;

	public ApuestaBaloto() {
		// TODO Auto-generated constructor stub
	}

	public ApuestaBaloto(int[] sixNumbers) {
		super();
		this.sixNumbers = sixNumbers;
	}

	public ApuestaBaloto(String bookmakerHeadquarters, double identification, String dayOfTheWeek,
			double valueOfTheBet) {
		super(bookmakerHeadquarters, identification, dayOfTheWeek, valueOfTheBet);
		// TODO Auto-generated constructor stub
	}

	public ApuestaBaloto(String bookmakerHeadquarters, double identification, String dayOfTheWeek, double valueOfTheBet,
			int[] sixNumbers) {
		super(bookmakerHeadquarters, identification, dayOfTheWeek, valueOfTheBet);
		this.sixNumbers = sixNumbers;
	}

	public int[] getSixNumbers() {
		return sixNumbers;
	}

	public void setSixNumbers(int[] sixNumbers) {
		this.sixNumbers = sixNumbers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ApuestaBaloto [sixNumbers=" + Arrays.toString(sixNumbers) + "]";
	}

}
