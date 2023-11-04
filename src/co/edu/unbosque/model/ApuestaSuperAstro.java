package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Arrays;

public class ApuestaSuperAstro extends ApuestaDTO implements Serializable {

	private static final long serialVersionUID = -4402814736606761069L;
	private int[] fourNumbers;
	private String zodiacSign;

	public ApuestaSuperAstro() {
		// TODO Auto-generated constructor stub
	}

	public ApuestaSuperAstro(int[] fourNumbers, String zodiacSign) {
		super();
		this.fourNumbers = fourNumbers;
		this.zodiacSign = zodiacSign;
	}

	public ApuestaSuperAstro(String bookmakerHeadquarters, double identification, String dayOfTheWeek,
			double valueOfTheBet) {
		super(bookmakerHeadquarters, identification, dayOfTheWeek, valueOfTheBet);
		// TODO Auto-generated constructor stub
	}

	public ApuestaSuperAstro(String bookmakerHeadquarters, double identification, String dayOfTheWeek,
			double valueOfTheBet, int[] fourNumbers, String zodiacSign) {
		super(bookmakerHeadquarters, identification, dayOfTheWeek, valueOfTheBet);
		this.fourNumbers = fourNumbers;
		this.zodiacSign = zodiacSign;
	}

	public int[] getFourNumbers() {
		return fourNumbers;
	}

	public void setFourNumbers(int[] fourNumbers) {
		this.fourNumbers = fourNumbers;
	}

	public String getZodiacSign() {
		return zodiacSign;
	}

	public void setZodiacSign(String zodiacSign) {
		this.zodiacSign = zodiacSign;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ApuestaSuperAstro [fourNumbers=" + Arrays.toString(fourNumbers) + ", zodiacSign=" + zodiacSign + "]";
	}

}
